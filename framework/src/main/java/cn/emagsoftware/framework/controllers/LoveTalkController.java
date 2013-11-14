package cn.emagsoftware.framework.controllers;

import cn.emagsoftware.framework.pojo.LoveTalkUser;
import cn.emagsoftware.framework.services.LoveTalkUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-6
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/loveTalk")
public class LoveTalkController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private LoveTalkUserService loveTalkUserService;

	@RequestMapping("userList")
	public String userList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<LoveTalkUser> userList = this.loveTalkUserService.getUserList();
		model.put("userList",userList);
		return "/example/userList";
	}

	@RequestMapping("init")
	public String init(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/example/main";
	}

	@RequestMapping("initList")
	public String initList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/example/ajax";
	}

	@RequestMapping("list")
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<LoveTalkUser> userList = this.loveTalkUserService.getUserList();
		return userList;
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("form") LoveTalkUser user) {
		this.loveTalkUserService.save(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success","true");
		map.put("message","保存成功！");
		return map;
	}
}
