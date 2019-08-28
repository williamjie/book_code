package com.irish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.irish.model.Member;
import com.irish.service.MemberService;
import com.irish.service.impl.UserMongoDbService;
import com.irish.util.RedisUtil;

@RestController
public class IndexController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private UserMongoDbService  UserMongoDbService;

	@Autowired
	private RedisUtil redisUtil;
	
	
	@RequestMapping("/")
	public String index() {
		return "SpringBoot2.0";
	}

	
	/**********************操作mysql**********************/
	
	@RequestMapping("/addMember")
	public void insertMember() {
		Member m = new Member().withId(2000L).withUsername("zhangsan").withNickname("张三");
		memberService.insert(m);
	}

	@RequestMapping("/listMember/{offset}/{pageSize}")
	public void selectByExample(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize) {
		memberService.selectByExample(offset, pageSize);
	}

	/**********************操作mongodb**********************/

	@RequestMapping("/saveUser/{id}")
	public void saveUser(@PathVariable("id")  Long  id) {
		UserMongoDbService.saveObj( id);
	}

	@RequestMapping("/deleteUser")
	public void deleteUser() {
		UserMongoDbService.deleteById();
	}
	
	@RequestMapping("/listUsers")
	public void listUsers() {
		UserMongoDbService.listUser();
	}
	
	
	/**********************操作redis**********************/
	@RequestMapping("/saveUserToken")
	public void saveUserToken() {
		boolean bool = redisUtil.set("u001", "abcdef", 120);
	}
	
	@RequestMapping("/deleteUserToken")
	public void deleteUserToken() {
		redisUtil.del("u001");
	}
	
}
