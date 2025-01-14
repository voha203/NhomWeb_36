<%@ page import="model.User" %>
<%@ page import="model.Product" %>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="assets/css/base.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>
<div id="main">
    <div id="admin-container">

        <!-- Sidebar -->
        <div class="sidebar">
            <div class="profile-container">
                <img src="images/av2.jpg" alt="Admin" class="profile-image">
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
                                <button class="edit-button" onclick="window.location.href='Admin?userId=${employee.user_id}'">Sửa</button>
                                <form method="post" action="Admin" style="display:inline;">
                                    <input type="hidden" name="deleteUserId" value="${employee.user_id}" />
                                    <button type="submit" class="delete-button">Xóa</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>

            <div class="form-popup" id="customerForm">
                <form method="post" action="Admin" id="customerFormContent">
                    <input type="hidden" name="userId" value="${employee != null ? employee.user_id : ''}" />
                    <div class="form-group">
                        <label for="name">Tên nhân viên:</label>
                        <input type="text" id="name" name="name" placeholder="Nhập tên nhân viên" value="${employee != null ? employee.user_name : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="address">Địa chỉ:</label>
                        <input type="text" id="address" name="address" placeholder="Nhập địa chỉ" value="${employee != null ? employee.address : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Số điện thoại:</label>
                        <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại" value="${employee != null ? employee.phone : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="tdm">Tên đăng nhập:</label>
                        <input type="text" id="tdm" name="tdm" placeholder="Nhập tên đăng nhập" value="${employee != null ? employee.username : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="mk">Mật khẩu:</label>
                        <input type="password" id="mk" name="mk" placeholder="Nhập mật khẩu" value="${employee != null ? employee.password_hash : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" placeholder="Nhập email" value="${employee != null ? employee.email : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="quyen">Quyền:</label>
                        <input type="text" id="quyen" name="quyen" placeholder="Nhập quyền" value="${employee != null ? employee.role : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="tt">Trạng thái:</label>
                        <input type="text" id="tt" name="tt" placeholder="Nhập trạng thái" value="${employee != null ? employee.status : ''}" required>
                    </div>
                    <div class="form-group">
                        <button class="add-button" type="submit">${employee != null ? 'Cập nhật' : 'Lưu'}</button>
                    </div>
                </form>
            </div>
        </div>

       <div id="content2" class="content">
    <head>
        <H1>Danh Sách Sản Phẩm</H1>
    </head>

        <section>
            <table>
                <thead>
                <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Hình ảnh</th>
            <th>Mô tả</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Ngày nhập kho</th>
            <th>Chỉnh sửa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.product_id}</td>
                <td>${product.product_name}</td>
                <td><img src="${product.image_url}" alt="Product Image" height="60" width="60"></td>
                <td>${product.description}</td>
                <td>${product.stock}</td>
                <td>${product.price}</td>
                <td>${product.created_at}</td>
                <td>
<%--                    <button class="edit">Sửa</button>--%>
    <button class="edit-button" onclick="window.location.href='product?product_id=${product.product_id}'">Sửa</button>

                    <form method="post" action="Admin">
                        <input type="hidden" name="deleteProductId" value="${product.product_id}">
                        <button type="submit" class="delete-button"> Xóa </button>
                    </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>

            <div class="form-popup" id="customerForm">
                <form method="post" action="Admin" id="productFormContent">
                    <input type="hidden" name="productId" value="${product.product_id}" />

                   <div class="form-group">
                       <label for="productName">Tên sản phẩm:</label>
                       <input type="text" id="productName" name="productName" placeholder="Nhập tên sản phẩm" value="${product.product_name}" required>
                   </div>

                   <div class="form-group">
                       <label for="imageUrl">Hình ảnh:</label>
                       <input type="text" id="imageUrl" name="imageUrl" placeholder="Nhập đường dẫn hình ảnh" value="${product.image_url}" required>
                   </div>

                   <div class="form-group">
                       <label for="description">Mô tả:</label>
                       <input  type="text" id="description" name="description" placeholder="Nhập mô tả" required>${product.description}</input>
                   </div>



                   <div class="form-group">
                       <label for="stock">Số lượng:</label>
                       <input type="text" id="stock" name="stock" placeholder="Nhập số lượng" value="${product.stock}" required>
                   </div>
                   <div class="form-group">
                       <label for="price">Giá:</label>
                       <input type="text" id="price" name="price" placeholder="Nhập giá sản phẩm" value="${product.price}" required>
                   </div>

                   <div class="form-group">
                       <button class="add-button" type="submit">Lưu</button>
                   </div>
               </form>
           </div>

       </div>

        <div id="content3" class="content">
            <header>
                <h1>Danh sách đơn hàng </h1>
            </header>
            <section>
                <table>
                    <thead>
                    <tr>
                        <th>Mã hóa đơn</th>
                        <th>Tên khách hàng</th>
                        <th>Số điện thoại</th>
                        <th>Ngày cập nhật</th>
                        <th>Địa chỉ nhận hàng</th>
                        <th>Tổng số tiền</th>
                        <th>Trạng thái đơn hàng</th>
                        <th>Chỉnh sửa</th>
                    </tr>
                    </thead>
                    <tbody>
                       <c:forEach var="order" items="${orders}">
                            <tr>
                                <td>${order.order_id}</td>
                                <td>${order.name}</td>
                                <td>${order.phone}</td>
                                <td>${order.order_date}</td>
                                <td>${order.address}</td>
                                <td>${order.total_amount}</td>
                                <td>${order.order_status}</td>
                                        <td>
                            <button class="edit-button">Sửa</button>
                          <button class="delete-button">Xóa</button>
                                        </td>
                            </tr>
                       </c:forEach>
                    </tbody>
                </table>
            </section>


<%--            <div class="form-popup" id="customerForm">--%>
<%--                <form id="customerFormContent">--%>
<%--                    <button class="add-button">Thêm đơn hàng</button>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="name">Tên khách hàng:</label>--%>
<%--                        <input type="text" id="name" placeholder="Nhập tên khách hàng">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="phone">Số điện thoại:</label>--%>
<%--                        <input type="text" id="phone" placeholder="Nhập số điện thoại">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="email">Ngày cập nhật</label>:</label>--%>
<%--                        <input type="email" id="email" placeholder="Nhập ngày cập nhật">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="address">Địa chỉ nhận hàng:</label>--%>
<%--                        <input type="text" id="address" placeholder="Nhập địa chỉ">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="address">Tổng số tiền:</label>--%>
<%--                        <input type="text" id="address" placeholder="Nhập tổng số tiền">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="address">Trạng thái đơn hàng:</label>--%>
<%--                        <input type="text" id="address" placeholder="Nhập trạng thái đơn hàng">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <button class="add-button">Lưu</button>--%>
<%--                        <button class="add-button">Xóa</button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
        </div>

        <div id="content4" class="content">
            <header>
                <h1>Danh sách khách hàng</h1>
            </header>
            <section>
                <table>
                    <thead>
                    <tr>
                        <th>Mã khách hàng</th>
                        <th>Tên khách hàng</th>
                        <th>Số điện thoại</th>
                        <th>Email</th>
                        <th>Địa chỉ nhận hàng</th>
                        <th>Chỉnh sửa</th>
                    </tr>
                    </thead>
                    <tbody>


                    <tr>
                        <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.user_id}</td>
                        <td>${customer.user_name}</td>

                        <td>${customer.phone}</td>
                        <td>${customer.email}</td>
                        <td>${customer.address}</td>
                        <td>
<%--                            <button class="edit-button" onclick="window.location.href='Admin?userId=${employee.user_id}'">Sửa</button>--%>
<%--                            <form method="post" action="Admin" style="display:inline;">--%>
<%--                                <input type="hidden" name="deleteUserId" value="${employee.user_id}" />--%>
<%--                                <button type="submit" class="delete-button">Xóa</button>--%>
<%--                            </form>--%>
                          <button class="edit-button">Sửa</button>
                            <button class="delete-button">Xóa</button>
                        </td>
                    </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </section>

            <div class="form-popup" id="customerForm">
                <form id="customerFormContent">
                    <button class="add-button">Thêm khách hàng</button>
                    <div class="form-group">
                        <label for="name">Tên khách hàng:</label>
                        <input type="text" id="name" placeholder="Nhập tên khách hàng">
                    </div>

                    <div class="form-group">
                        <label for="phone">Số điện thoại:</label>
                        <input type="text" id="phone" placeholder="Nhập số điện thoại">
                    </div>

                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" placeholder="Nhập email">
                    </div>

                    <div class="form-group">
                        <label for="address">Địa chỉ nhận hàng:</label>
                        <input type="text" id="address" placeholder="Nhập địa chỉ">
                    </div>
                    <div class="form-group">
                        <button class="add-button">Lưu</button>
                        <button class="add-button">Xóa</button>
                    </div>
                </form>
            </div>
        </div>


</div>
</div>
</body>

<script src="<c:url value='/js/main.js'/>"></script>
</html>
