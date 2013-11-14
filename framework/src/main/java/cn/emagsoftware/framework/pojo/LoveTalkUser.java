package cn.emagsoftware.framework.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-6
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
public class LoveTalkUser {

	private long id;

	private String userName;

	private String sex;

	private Integer age;

	private String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
