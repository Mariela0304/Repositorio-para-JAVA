package bonilla.mariela.bl.user;

public class User {
    private String userName;
    private String userPwd;


    public User() {
    }

    public User(String user, String pwd) {
        this.userName = user;
        this.userPwd = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
