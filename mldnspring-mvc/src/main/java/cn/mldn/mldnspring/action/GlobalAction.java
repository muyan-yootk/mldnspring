package cn.mldn.mldnspring.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalAction {
	@RequestMapping("/error")
	public String error() {
		return "plugins/errors" ;
	} 
}
