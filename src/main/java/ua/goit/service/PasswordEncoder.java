package ua.goit.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
  public static String encode(String password) {
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      return passwordEncoder.encode(password);
  }

}
