package cn.mldn.mldnspring.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.mldnspring.vo.Emp;
import cn.mldn.util.action.AbstractAction;

@Controller
@RequestMapping("/pages/emp/*")	
public class EmpAction extends AbstractAction {
//	@GetMapping("object")
//	public ModelAndView object(HttpServletRequest request , HttpServletResponse response) {
//		HttpSession session = request.getSession() ; 
//		ServletContext application = request.getServletContext() ;
//		System.out.println("ContextPath = " + request.getContextPath());
//		System.out.println("ContentType = " + response.getContentType());
//		System.out.println("SessionID = " + session.getId());
//		System.out.println("RealPath = " + application.getRealPath("/upload/"));
//		return null ; // 不进行跳转
//	} 

	@GetMapping("object")
	public ModelAndView object() {
		HttpSession session = super.getRequest().getSession() ; 
		ServletContext application = super.getRequest().getServletContext() ;
		System.out.println("ContextPath = " + super.getRequest().getContextPath());
		System.out.println("ContentType = " + super.getResponse().getContentType());
		System.out.println("SessionID = " + session.getId());
		System.out.println("RealPath = " + application.getRealPath("/upload/"));
		return null ; // 不进行跳转
	}

	
	
	@GetMapping("input")
	public String input() {
		System.out.println(super.getMessage("welcome.info", "MLDN")); 
		return super.getMessage("emp.input.page") ; 
	}
	@PostMapping("show")
	@ResponseBody
	public Object show(Emp emp,MultipartFile photo) {
		if (photo != null) {
			System.out.println("【上传照片】" + photo.getContentType() + "、" + photo.getName());
		}
		return emp ;  
	}  
}
