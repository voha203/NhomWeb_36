
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="controller.UserController" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="assets/css/main.css">
  <link rel="stylesheet" href="assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="assets/css/base.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>
<div id="main">

  <div id ="container">
    <div id="container_dn">
      <div class="login-container">

        <h2>ĐĂNG NHẬP</h2>

        <form action="UserController" method="post" class="login-form">
          <label for="username">Tên đăng nhập <span>*</span></label>
          <input type="text" id="username" placeholder="Nhập tên đăng nhập" required>

          <label for="password">Mật khẩu <span>*</span></label>
          <input type="password" id="password" placeholder="Nhập mật khẩu" required>

          <div class="form-actions">
            <button type="submit" class="btn-login">Đăng nhập</button>
            <a href="TrangQuenMK.html" class="forgot-password">Quên mật khẩu?</a>
          </div>
          <div class="register-link">
            <p>Bạn chưa có tài khoản? <a href="Dangky.html">Đăng ký ngay</a></p>
          </div>
        </form>
        <div class="divider">HOẶC</div>
        <div class="social-login">
          <button class="btn-social facebook">Facebook</button>
          <button class="btn-social google">Google</button>
        </div>
        <div class="support-info">
          <p>Nếu Quý khách có vấn đề gì thắc mắc hoặc cần hỗ trợ gì thêm có thể liên hệ:</p>
          <p><strong>Hotline:</strong> 1900.633.349</p>
        </div>
        <a href="TrangChu.html" class="back-to-trangchu">Quay lại trang chủ</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>

