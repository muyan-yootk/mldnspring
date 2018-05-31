package cn.mldn.mldnspring.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.mldnspring.vo.Emp;
import cn.mldn.util.action.AbstractAction;

@Controller
@RequestMapping("/pages/emp/*")	
public class EmpAction extends AbstractAction {
	@GetMapping("input")
	public String input() {
		return "/pages/emp/input.jsp" ; 
	}
	@PostMapping("show")
	@ResponseBody
	public Object show(Emp emp) {
		return emp ;  
	}  
}
