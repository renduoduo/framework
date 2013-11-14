package cn.emagsoftware.framework.services;

import cn.emagsoftware.framework.pojo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * function description
 *
 * @author huzl
 * @version 1.0.0
 */
@Service
public class ExampleService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserVO getUser(String userTel){
        List<UserVO> users = jdbcTemplate.query("select id,tel,user_agent from tb_gh_user where tel=?", new BeanPropertyRowMapper<UserVO>(UserVO.class),userTel);
        return users.isEmpty()?null:users.get(0);
    }
}
