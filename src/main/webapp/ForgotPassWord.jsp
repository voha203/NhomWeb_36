
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
  <title>Quên mật khẩu</title>
  <link rel="stylesheet" href="assets/css/main.css">
  <link rel="stylesheet" href="assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="assets/css/base.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>
<div id="main">

  <div id="container">
    <div id="container_forgot_password">
      <div class="forgot-password-container">
        <h2>QUÊN MẬT KHẨU</h2>
        <p>Vui lòng nhập địa chỉ email mà bạn đã đăng ký tài khoản hoặc bằng số điện thoại.</p>
        <form action="UserController" method="post" class="forgot-password-form">
          <label for="email">Email <span>*</span></label>
          <input type="email" id="email" placeholder="Nhập địa chỉ email" required>
          <button type="submit" class="btn-submit">Gửi yêu cầu</button>
        </form>
        <div class="support-info">
          <p>Nếu bạn gặp vấn đề, vui lòng liên hệ:</p>
          <p><strong>Hotline:</strong> 1900.633.349</p>
        </div>
        <p>Remembered your password? <a href="Login.jsp">Login here</a></p>
        <a href="DangNhap.html" class="back-to-login">Quay lại trang đăng nhập</a>
      </div>
    </div>

  </div>

</div>
</body>
</html>
