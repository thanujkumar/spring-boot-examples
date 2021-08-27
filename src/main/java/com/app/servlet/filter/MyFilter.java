package com.app.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

@Component //declared as a bean
//OR
//@WebFilter //In this case you need to add ServletComponentScan to Application
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init called " + this);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destroy"  + " called " + this);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filter invoked and logic goes here " + this);
        chain.doFilter(request, response);

    }

}
