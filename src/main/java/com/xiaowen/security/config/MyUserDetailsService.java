package com.xiaowen.security.config;

import com.xiaowen.security.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wen.he
 * @Date 2020/7/22 17:52
 *
 * 根据表单提交的用户名查询User对象
 * 并装配角色、权限等信息
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    //1、查询用户
    String sql = "SELECT ID, USERNAME, PASSWORD, STATUS FROM sys_user WHERE USERNAME = ? ";

    List<Admin> adminlist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Admin.class), username);

    Admin admin = adminlist.get(0);

    //2、设置角色信息
    ArrayList<GrantedAuthority> authoritieList = new ArrayList<>();
    authoritieList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    authoritieList.add(new SimpleGrantedAuthority("UPDATE"));

    //3、把admin对象与authoritieList封装到UserDetails
    return new User(username, admin.getPassword(), authoritieList);
  }
}
