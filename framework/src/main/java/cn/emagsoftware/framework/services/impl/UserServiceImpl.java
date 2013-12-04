package cn.emagsoftware.framework.services.impl;

import cn.emagsoftware.framework.jdbc.JdbcDao;
import cn.emagsoftware.framework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-12-4
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcDao jdbcDao;

	@Override
	public Map<String, Object> queryUserList(int page, int rows, Object... param){
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "SELECT CREATE_TIME,ID,CREATE_USER,STATUS,UPDATE_TIME,UPDATE_USER,VERSION,ADDRESS,EMAIL,LOGIN_NAME,MOBILEPHONE,NAME,PASSWORD,SEX,TEL,DEFAULT_ORGANID FROM t_base_user";
		List<Map<String, Object>> userList = jdbcDao.queryForList(sql,page,rows,param);
		Long total = jdbcDao.queryForLong(sql, param);
		map.put("total",total);
		map.put("rows",userList);
		return map;
	}

}
