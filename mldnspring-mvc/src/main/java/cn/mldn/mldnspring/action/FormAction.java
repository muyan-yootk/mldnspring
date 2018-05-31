package cn.mldn.mldnspring.action;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.util.action.AbstractAction;

@Controller
@RequestMapping("/pages/form/*")	
public class FormAction extends AbstractAction {
	@RequestMapping(value="input",method=RequestMethod.GET) 
	public String input() {
		return "/pages/form/input.jsp" ; 
	}
	/**
	 * 进行用户的Echo处理逻辑，在请求参数前追加有“ECHO”的信息
	 * @param msg 用户发送的数据
	 * @return 处理后的ECHO内容
	 */
	@RequestMapping(value="show",method=RequestMethod.POST) 
	public ModelAndView show(String msg, int level, Date pubdate, String tags[]) {
		ModelAndView mav = new ModelAndView("/pages/form/show.jsp") ;
		mav.addObject("echoMsg", "【ECHO】" + msg) ; // 设置request属性
		mav.addObject("echoLevel", "【ECHO】" + level) ; // 设置request属性
		mav.addObject("echoPubdate", "【ECHO】" + pubdate) ; // 设置request属性
		mav.addObject("echoTags", "【ECHO】" + Arrays.toString(tags)) ; // 设置request属性
		return mav ;
	} 
}
