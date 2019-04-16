/**
 * 
 */
package com.bjsxt.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author zhaoyangyang
 */

@Controller
public class HomeController {
	// @RequestMapping(value="/", method="get")
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
}
