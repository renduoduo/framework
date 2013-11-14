package cn.emagsoftware.framework.controllers;

import cn.emagsoftware.framework.pojo.UserVO;
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
    public Object appInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") String id) {

        return null;
    }
}
