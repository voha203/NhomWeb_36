<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
                    <img src="${product.link}" alt="${product.productName}">I
                    <!-- Hiển thị tên sản phẩm -->
                    <p class="product-name">${product.productName}</p>
                    <!-- Hiển thị giá sản phẩm -->
                    <p class="price">${product.price} đ</p>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
</body>
</html>
