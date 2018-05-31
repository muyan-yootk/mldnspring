package cn.mldn.mldnspring.action;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.util.action.AbstractAction;

@Controller
@RequestMapping("/pages/upload/*")	
public class UploadAction extends AbstractAction {
	@RequestMapping(value="input",method=RequestMethod.GET) 
	public String input() {
		return "upload/input" ; 
	}
	@RequestMapping(value="upload",method=RequestMethod.POST) 
	public ModelAndView upload(String msg, MultipartFile photo) {
		System.out.println("【上传处理】msg = " + msg);
		System.out.println("【上传处理】photo-size = " + photo.getSize());
		System.out.println("【上传处理】photo-mime = " + photo.getContentType());
		System.out.println("【上传处理】photo-name = " + photo.getName());
		String fileName = UUID.randomUUID() + "." + photo.getContentType().substring(photo.getContentType().lastIndexOf("/") + 1) ;
		String filePath = super.getRequest().getServletContext().getRealPath("/WEB-INF/upload/") + fileName ;
		System.out.println(filePath);
		try {
			photo.transferTo(new File(filePath));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return null ;
	}
}
