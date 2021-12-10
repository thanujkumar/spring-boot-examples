package com.app.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

        @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        DataSource dataSource = databaseBuilder.setType(EmbeddedDatabaseType.H2)
                .setName("testdb;MODE=Oracle") //Oracle mode
                .addScript("batch-schema.sql")
               .build();
        return dataSource;
    }

    @Bean
    @StepScope
    FlatFileItemReader<Person> flatFileItemReader(@Value("#{jobParameters[file]}") File file) {
        FlatFileItemReader<Person> reader = new FlatFileItemReader();
        reader.setResource(new FileSystemResource(file));
//        reader.setLineMapper(new LineMapper<Person>() {
//            @Override
//            public Person mapLine(String s, int i) throws Exception {
//                return null;
//            }
//        });
        //OR
        reader.setLineMapper(new DefaultLineMapper<Person>() {
            {
                this.setLineTokenizer(new DelimitedLineTokenizer(",") {
                    {
                        this.setNames(new String[]{"first", "last", "email"});
                    }
                });
                this.setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {
                    {
                        this.setTargetType(Person.class);
                    }
                });
            }
        });
        return reader;
    }

    @Bean
    JdbcBatchItemWriter<Person> jdbcBatchItemWriter(DataSource h2) {
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(h2);
        writer.setSql("insert into PEOPLE (first, last, email) values (:first, :last, :email)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }

    @Bean
    Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, FlatFileItemReader<Person> reader, JdbcBatchItemWriter<Person> writer) {

        Step step = stepBuilderFactory.get("file-to-database")
                .<Person, Person>chunk(5).reader(reader)
                .writer(writer).build();
        return jobBuilderFactory.get("etl").start(step).build();
    }

    @Bean
    CommandLineRunner runner(JobLauncher launcher, Job job, @Value("${infile}") File file, JdbcTemplate template) {
        return args -> {
           JobExecution execution = launcher.run(job,
                    new JobParametersBuilder().addString("file", file.getAbsolutePath()).toJobParameters());
            System.out.println("execution status: "+ execution.getExitStatus().toString());

            //print the data that is database
            List<Person> personList = template.query("select * from PEOPLE", new RowMapper<Person>() {
                @Override
                public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Person(rs.getString(1), rs.getString(2), rs.getString(3));
                }
            });
            personList.stream().forEach(System.out::println);
        };
    }
}
