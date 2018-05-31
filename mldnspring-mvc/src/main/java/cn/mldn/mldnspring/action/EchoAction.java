package cn.mldn.mldnspring.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages/message/*")	
public class EchoAction {
	@RequestMapping(value="input",method=RequestMethod.GET) 
	public String input() {
		return "/pages/message/input.jsp" ; 
	}
	/**
	 * 进行用户的Echo处理逻辑，在请求参数前追加有“ECHO”的信息
	 * @param msg 用户发送的数据
	 * @return 处理后的ECHO内容
	 */
	@RequestMapping(value="echo",method=RequestMethod.POST) 
	public ModelAndView echo(String msg) {
		ModelAndView mav = new ModelAndView("/pages/message/show.jsp") ;
		mav.addObject("echoMessage", "【ECHO】" + msg) ; // 设置request属性
		return mav ;
	}
}
