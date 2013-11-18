package cn.emagsoftware.framework.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-6
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
public class Menu {

	private Long id;

	private Long parentId;

	private String menuName;

	private String url;

	private String leaf;

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
