package cn.emagsoftware.framework.services.impl;

import cn.emagsoftware.framework.pojo.LoveTalkUser;
import cn.emagsoftware.framework.pojo.Menu;
import cn.emagsoftware.framework.services.LoveTalkUserService;
import cn.emagsoftware.framework.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-6
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Menu> getMenuList() {
		return this.jdbcTemplate.query("select id, parent_Id as parentId, menu_name as menuName, url from tb_menu where parent_Id is null", new BeanPropertyRowMapper<Menu>(Menu.class));
	}

	@Override
	public List<Menu> getMenuListById(Long id) {
		return this.jdbcTemplate.query("select id, parent_Id as parentId, menu_name as menuName, url from tb_menu where parent_Id = ?",new Object[]{id},new int[]{Types.BIGINT}, new BeanPropertyRowMapper<Menu>(Menu.class));
	}


}
