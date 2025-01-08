<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/8/2025
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/base.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>
<div id="main">
    <header></header>
    <div class="container">
        <div class="product-container">
            <h1>TẤT CẢ SẢN PHẨM</h1>
        </div>

        <div class="product-grid">
            <!-- Lặp qua danh sách sản phẩm -->
            <c:forEach var="product" items="${products}">
                <div class="product">
                    <!-- Hiển thị ảnh sản phẩm -->
                    <img src="${product.image_url}" alt="${product.product_name}">
                    <!-- Hiển thị tên sản phẩm -->
                    <p class="product-name">${product.product_name}</p>
                    <!-- Hiển thị giá sản phẩm -->
                    <p class="price">${product.price} đ</p>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
</body>
</html>
