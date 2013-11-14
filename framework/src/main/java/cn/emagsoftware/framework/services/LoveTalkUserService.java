package cn.emagsoftware.framework.services;

import cn.emagsoftware.framework.pojo.LoveTalkUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-6
 * Time: 下午4:59
 * To change this template use File | Settings | File Templates.
 */
public interface LoveTalkUserService {

	public List<LoveTalkUser> getUserList();

	public void save(LoveTalkUser user);
}
