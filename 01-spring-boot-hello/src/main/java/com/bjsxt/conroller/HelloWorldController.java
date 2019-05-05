package com.bjsxt.conroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/hello")
	public Map<String, Object> hello() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("hello", "你好");
		result.put("fuck you", 2333);
		result.put("list", new String[] { "zhaoyangyang", "nidid" });
		// add view(controller)视图
		
		//redis这里是能取到值的，但是打开dos界面却取不到（get zho）
		userService.set("zho", "nidegkdje");
		String tmp = (String) userService.get("zho");

		System.out.println(tmp);
		return result;
	}
}
