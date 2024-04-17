package Common;//时间：2023/9/17 15:32

import java.io.Serializable;

/*用户 */
public class User implements Serializable /*要以对象的形式进行传输要实现序列化*/
{
    private static final long serialVersionUID = 1L;
    private String UserId;//用户ID/用户名
    private String passwd;//用户密码

    public User(){}
    public User(String userId, String passwd) {
        this.UserId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
