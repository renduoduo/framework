package cn.emagsoftware.framework.services.impl;

import cn.emagsoftware.framework.pojo.LoveTalkUser;
import cn.emagsoftware.framework.services.LoveTalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-6
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoveTalkUserServiceImpl implements LoveTalkUserService{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<LoveTalkUser> getUserList() {
		return this.jdbcTemplate.query("select id, userName, sex, age, address from abc", new BeanPropertyRowMapper<LoveTalkUser>(LoveTalkUser.class));
	}

	public void save(final LoveTalkUser user){
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			String sql = "insert into user(userName, sex, age, address) values(?,?,?,?)";
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps =con.prepareStatement(sql);//返回id
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getSex());
				ps.setInt(3, user.getAge());
				ps.setString(4, user.getAddress());
				return ps;  //To change body of implemented methods use File | Settings | File Templates.
			}
		});
	}
}
