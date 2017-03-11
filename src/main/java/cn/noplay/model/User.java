package cn.noplay.model;

/**
 * Created  on 12/13 0013.
 */
public class User {
    private Integer userid;

    private String username;
    private int age;

    private String userpassword;

    private String account;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name == null ? null : name.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
