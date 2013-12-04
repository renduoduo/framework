package cn.emagsoftware.framework.services;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-12-4
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
	public Map<String, Object> queryUserList(int page, int rows, Object... param);
}
