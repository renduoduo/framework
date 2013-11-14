package cn.emagsoftware.framework.controllers;

import cn.emagsoftware.framework.pojo.UserVO;
import cn.emagsoftware.framework.services.ExampleService;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * spring mvc Example controller
 *
 * @author huzl
 * @version 1.0.0
 */
@Controller
@RequestMapping("/api")
public class ExampleController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Configuration configuration;
    @Autowired
    private ExampleService exampleService;

    @RequestMapping("appInfo")
    public String appInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestParam("userTel") String userTel) {
        logger.info("Example appInfo userTel={}", userTel);
        UserVO user = null;
        if(StringUtils.isNotEmpty(userTel))
            user = exampleService.getUser(userTel);
        model.put("user",user);
        model.put("appName",configuration.getString("app.name","PrizeX"));
        return "/example/appInfo";
    }
}
