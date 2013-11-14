package cn.emagsoftware.framework.pojo;

/**
 * function description
 *
 * @author huzl
 * @version 1.0.0
 */
public class UserVO {
    private long id;
    private String tel;
    private String userAgent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
