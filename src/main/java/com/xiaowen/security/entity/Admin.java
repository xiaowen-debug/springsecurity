package com.xiaowen.security.entity;

/**
 * @Author wen.he
 * @Date 2020/7/22 18:02
 */
public class Admin {

  private Integer id;

  private String username;

  private String password;

  private Integer status;

  public Admin(Integer id, String username, String password, Integer status) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.status = status;
  }

  public Admin() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Admin{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", status=" + status +
        '}';
  }
}
