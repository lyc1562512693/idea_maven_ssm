package com.surfilter.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/hs")
public class HttpsServerController {
	
	@ResponseBody
	@RequestMapping(value = "getTest.action", method=RequestMethod.GET)
	public String getTest(String userName) {
		System.out.println("用户名：" + userName);
		return "get success!";
	}
	
	@ResponseBody
	@RequestMapping(value="postTest.action", method = RequestMethod.POST)
	public String postTest(@RequestBody String userName) {
		System.out.println("用户名：" + userName);
		return "post success!";
	}

}
