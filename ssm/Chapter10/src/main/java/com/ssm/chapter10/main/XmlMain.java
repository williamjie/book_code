package com.ssm.chapter10.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.chapter10.annotation.config.DataSourceBean;
import com.ssm.chapter10.annotation.service.RoleDataSourceService;
import com.ssm.chapter10.pojo.UserRoleAssembly;
public class XmlMain {

	public static void main(String[] args) {
		test3();
	}

	public static void test1() {
		System.err.println(" XmlMain test1");

		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("spring-config.xml");
		UserRoleAssembly userRoleAssembly = context.getBean(UserRoleAssembly.class);
			System.err.println(userRoleAssembly.getList().get(0).getId());
	}
	
	public static void test2() {
		System.err.println(" XmlMain test2");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-props.xml");
		DataSourceBean dsBean = context.getBean(DataSourceBean.class);
		System.out.println(dsBean.getUrl());
	}
	
	public static void test3() {
		System.err.println(" XmlMain test3 ");
		System.out.println(System.getProperty("user.dir"));

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-props.xml");


		System.out.println(System.getProperty("user.dir"));

		RoleDataSourceService RoleService = ctx.getBean(RoleDataSourceService.class);
		RoleDataSourceService RoleService2 =  ctx.getBean(RoleDataSourceService.class);
		System.out.println(RoleService == RoleService2);
	}
}
