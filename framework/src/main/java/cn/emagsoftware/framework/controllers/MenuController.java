package cn.emagsoftware.framework.controllers;

import cn.emagsoftware.framework.pojo.Menu;
import cn.emagsoftware.framework.pojo.UserVO;
import cn.emagsoftware.framework.services.MenuService;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * spring mvc Example controller
 *
 * @author huzl
 * @version 1.0.0
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Configuration configuration;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/tree")
	@ResponseBody
    public Object buildTree(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		List<Menu> menuList = new ArrayList<Menu>();
		if("0".equals(id)){
			menuList = menuService.getMenuList();
		}else{
			menuList = menuService.getMenuListById(Long.parseLong(id));
		}
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
		for(Menu menu : menuList){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id",menu.getId());
			map.put("text", menu.getMenuName());
			if(menu.getLeaf().equals("0")){
				map.put("state", "closed");
			}else{
				map.put("state", "open");
			}
			Map<String, Object> attributeMap = new HashMap<String, Object>();
			attributeMap.put("url", menu.getUrl());
			map.put("attributes", attributeMap);
			treeList.add(map);
		}
        return treeList;
    }
}
