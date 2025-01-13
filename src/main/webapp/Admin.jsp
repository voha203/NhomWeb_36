<%@ page import="model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/13/2025
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="assets/css/base.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>
<div id="main">
    <div id="admin-container">
        <button class="sidebar-toggle" onclick="toggleSidebar()">☰</button>
        <!-- Sidebar -->
        <div class="sidebar">
            <div class="profile-container">
                <!-- Hình ảnh admin -->
                <img src="images/av2.jpg" alt="Admin" class="profile-image">

                <!-- Tên admin -->
                <h2 class="profile-name">Admin</h2>
            </div>
            <div>
                <h2>TRANG QUẢN LÝ</h2>
            </div>
            <div>
                <ul>
                    <li><a href="#" onclick="changeContent('content1')"><i class="ti-home"></i>Trang chủ</a></li>
                    <li><a href="#" onclick="changeContent('content2')"><i class="ti-bag"></i>Sản phẩm</a></li>
                    <li><a href="#" onclick="changeContent('content3')"><i class="ti-package"></i>Đơn hàng</a></li>
                    <li><a href="#" onclick="changeContent('content4')"><i class="ti-user"></i>Khách hàng</a></li>
                </ul>
                <div class="divider"></div>
                <ul>
                    <li><a href="Home.jsp"><i class="ti-arrow-left"></i> Đăng xuất (về trang chủ)</a></li>
                </ul>
            </div>
        </div>

        <!-- Main Content  -->
        <div id="content1" class="content active">

                <div class="dashboard">
                    <div class="box">
                        <h2>Doanh Thu</h2>
                        <p><span><%= request.getAttribute("totalRevenue") %></span></p>
                        <p class="status">Tổng doanh thu tháng</p>
                    </div>
                    <div class="box">
                        <h2>Số Lượng Sản Phẩm</h2>
                        <p><span><%= request.getAttribute("totalProducts") %></span></p>
                        <p class="status">Tổng sản phẩm hiện có</p>
                    </div>
                    <div class="box">
                        <h2>Số Lượt Bán</h2>
                        <p><span><%= request.getAttribute("totalOrders") %></span></p>
                        <p class="status">Tổng lượt bán được</p>
                    </div>
                    <div class="box">
                        <h2>Sản Phẩm Đã Bán</h2>
                        <p><span><%= request.getAttribute("totalSoldProducts") %></span></p>
                        <p class="status">Sản phẩm đã bán</p>
                    </div>
                </div>


                <header>
                    <h1>Danh sách nhân viên</h1>
                </header>

                <section>
                    <table>
                        <thead>
                        <tr>
                            <th>Mã nhân viên</th>
                            <th>Họ tên</th>
                            <th>Địa chỉ</th>
                            <th>Số điện thoại</th>
                            <th>Tên đăng nhập</th>
                            <th>Mật khẩu</th>
                            <th>Email</th>
                            <th>Quyền</th>
                            <th>Trạng thái</th>
                            <th>Chỉnh sửa</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="employee" items="${employees}">
                            <tr>
                                <td>${employee.user_id}</td>
                                <td>${employee.user_name}</td>
                                <td>${employee.address}</td>
                                <td>${employee.phone}</td>
                                <td>${employee.username}</td>
                                <td>${employee.password_hash}</td>
                                <td>${employee.email}</td>
                                <td>${employee.role}</td>
                                <td>${employee.status}</td>
                                <td>
                                    <button class="edit">Sửa</button>
                                    <button class="delete">Xóa</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </section>

                <!-- Form thêm nhân viên -->
<%--                <div class="form-popup" id="customerForm">--%>
<%--                    <form method="post" action="addUser" id="customerFormContent">--%>
<%--                        <button class="add-button" type="submit">Thêm nhân viên</button>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="name">Tên nhân viên:</label>--%>
<%--                            <input type="text" id="name" name="name" placeholder="Nhập tên nhân viên" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="address">Địa chỉ:</label>--%>
<%--                            <input type="text" id="address" name="address" placeholder="Nhập địa chỉ" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="phone">Số điện thoại:</label>--%>
<%--                            <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="tdm">Tên đăng nhập:</label>--%>
<%--                            <input type="text" id="tdm" name="tdm" placeholder="Nhập tên đăng nhập" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="mk">Mật khẩu:</label>--%>
<%--                            <input type="password" id="mk" name="mk" placeholder="Nhập mật khẩu" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="email">Email:</label>--%>
<%--                            <input type="email" id="email" name="email" placeholder="Nhập email" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="quyen">Quyền:</label>--%>
<%--                            <input type="text" id="quyen" name="quyen" placeholder="Nhập quyền" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="tt">Trạng thái:</label>--%>
<%--                            <input type="text" id="tt" name="tt" placeholder="Nhập trạng thái" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <button class="add-button" type="submit">Lưu</button>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </div>--%>

<%--        </div>--%>
<%--    </div>--%>
        </div>
    </div>
</div>
</body>
</html>

