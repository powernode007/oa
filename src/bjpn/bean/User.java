package bjpn.bean;

import java.util.Objects;

public class User {
    private Integer userid;
    private String username;
    private String usercode;
    private String userpwd;
    private String userphoto;



    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public User() {
    }

    public User(Integer userid, String username, String usercode, String userpwd, String userphoto) {
        this.userid = userid;
        this.username = username;
        this.usercode = usercode;
        this.userpwd = userpwd;
        this.userphoto = userphoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userid, user.userid) &&
                Objects.equals(username, user.username) &&
                Objects.equals(usercode, user.usercode) &&
                Objects.equals(userpwd, user.userpwd) &&
                Objects.equals(userphoto, user.userphoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, usercode, userpwd, userphoto);
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", usercode='" + usercode + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", userphoto='" + userphoto + '\'' +
                '}';
    }
}
