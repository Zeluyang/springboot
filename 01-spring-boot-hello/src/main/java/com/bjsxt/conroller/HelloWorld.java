package com.bjsxt.conroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorld {
	@ResponseBody
	@RequestMapping(value = "/hello")
	public Map<String, Object> hello() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("hello", "你好");
		result.put("fuck you", 2333);
		result.put("list", new String[] { "zhaoyangyang", "nidid" });
		// add view(controller)视图
		return result;
	}
}
