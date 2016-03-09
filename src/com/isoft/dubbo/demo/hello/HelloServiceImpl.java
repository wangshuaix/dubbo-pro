package com.isoft.dubbo.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.isoft.dubbo.demo.hello.dao.BaseDao;

public class HelloServiceImpl implements HelloService {
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public String hello() {
		return "hello";
	}

	@Override
	public String sayHello(String name) {
		saveDate(name);
		return "hello" + name;
	}

	private void saveDate(String name) {
		baseDao.saveDate(name);
		System.out.println("dao is over");
	}
}
