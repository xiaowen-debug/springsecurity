package com.xiaowen.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @Author wen.he
 * @Date 2020/7/22 18:13
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(CharSequence rawPassword) {
    return pEncode(rawPassword);
  }

  /**
   *
   * @param rawPassword  明文密码 表单
   * @param encodedPassword  加密密码 数据库
   * @return
   */
  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return Objects.equals(pEncode(rawPassword),encodedPassword);
  }

  /**
   * 加密
   */
  private String pEncode(CharSequence rawPassword){
    String algorithm = "MD5";
    String encoded = null;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
      // 获取输入的字节数组
      byte[] input = ((String) rawPassword).getBytes();
      // 加密
      byte[] digest = messageDigest.digest(input);
      // 将加密后的字节数组转成 16 进制
      encoded = new BigInteger(1, digest).toString(16).toUpperCase();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return encoded;
  }
}
