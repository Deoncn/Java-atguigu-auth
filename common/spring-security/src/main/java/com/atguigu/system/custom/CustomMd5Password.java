package com.atguigu.system.custom;

import com.atguigu.common.utils.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * ClassName:CustomMd5Password
 * Package: IntelliJ IDEA
 * Description:
 * @ Author: Deoncn
 * @ Create: 2023/8/3 - 22:56
 * @ Version: v1.0
 */

// 自定义密码组件
@Component
public class CustomMd5Password implements PasswordEncoder {

 public String encode(CharSequence rawPassword) {
  return MD5.encrypt(rawPassword.toString());
 }

 public boolean matches(CharSequence rawPassword, String encodedPassword) {
  return encodedPassword.equals(MD5.encrypt(rawPassword.toString()));
 }
}
