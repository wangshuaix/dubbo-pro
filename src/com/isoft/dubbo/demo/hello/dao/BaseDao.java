package com.isoft.dubbo.demo.hello.dao;

import org.springframework.stereotype.Component;

@Component
public class BaseDao {

	public String saveDate(String data) {
		System.out.println("dao is run");
		return "success";
	}
}
