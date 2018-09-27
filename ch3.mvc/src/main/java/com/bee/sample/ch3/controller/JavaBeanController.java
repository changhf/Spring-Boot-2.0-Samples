package com.bee.sample.ch3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bee.sample.ch3.controller.form.OrderPostForm;
import com.bee.sample.ch3.entity.User;
import com.bee.sample.ch3.service.UserService;
/**
 * 通过form提交的各种映射举例
 * @author lijiazhi
 *
 */
@Controller
@RequestMapping("/javabean")
public class JavaBeanController {
	
	@Autowired UserService userService;
	
	@GetMapping(path = "/update.json")
	@ResponseBody
	public String updateUser(User user) {
		System.out.println(user.getName());
		System.out.println(user.getId());
		return "success";
	}
	
	@GetMapping(path = "/update2.json")
	@ResponseBody
	public String updateUser2(Integer id, String name) {
		System.out.println(id);
		System.out.println(name);
		return "success";
	}
	
	
	@GetMapping(path = "/update3.json")
	@ResponseBody
	public String updateUser3(@RequestParam(name="id",required=true) Integer id, String name) {
		System.out.println(id);
		System.out.println(name);
		return "success";
	}

	@PostMapping(path = "/saveOrder.json")
	@ResponseBody
	public String saveOrder( OrderPostForm form) {
		return "success";
	}
	
	@PostMapping(path = "/savejsonorder.json")
	@ResponseBody
	public String saveOrderByJson(@RequestBody User user) {
		return user.getName();
	}
	
}
