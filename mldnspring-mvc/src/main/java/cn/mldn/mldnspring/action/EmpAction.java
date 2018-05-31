package cn.mldn.mldnspring.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView show(Emp emp) {
		System.out.println(emp);
		System.out.println(emp.getDept());
		return null ; 
	} 
}
