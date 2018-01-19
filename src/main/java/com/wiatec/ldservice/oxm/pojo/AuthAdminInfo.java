package com.wiatec.ldservice.oxm.pojo;


/**
 * @author patrick
 */
public class AuthAdminInfo {

    private int id;
    private String username;
    private String password;
    private int permisssion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermisssion() {
        return permisssion;
    }

    public void setPermisssion(int permisssion) {
        this.permisssion = permisssion;
    }

    @Override
    public String toString() {
        return "AuthAdminInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permisssion=" + permisssion +
                '}';
    }
}
