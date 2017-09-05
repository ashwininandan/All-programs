/**
 * 
 */
package com.spring;

/**
 * @author win 10
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(value="/index",method=RequestMethod.GET)
public String index(ModelMap model){
	model.addAttribute("message", "hii this is finally done");
	return "hello";
}
}
