package com.app2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DataHierarchy {

	private ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

	private String str;

	public ConcurrentMap<String, String> getMap() {
		return map;
	}

	public void setMap(ConcurrentMap<String, String> map) {
		this.map = map;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
