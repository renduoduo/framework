package cn.emagsoftware.framework.services;

import cn.emagsoftware.framework.pojo.Menu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-13
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public interface MenuService {
	List<Menu> getMenuList();

	List<Menu> getMenuListById(Long id);
}
