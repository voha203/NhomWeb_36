<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>
<div class="container">

    <div class="container_1">
        <div class="product-container">
            <h1>SẢN PHẨM MỚI</h1>
        </div>
        <div class="product-grid">
            <c:forEach var="product" items="${newProducts}">
                <a class="product-link" href="${pageContext.request.contextPath}/Detail?product_id=<c:out value='${product.product_id}' />">
                    <div class="product">
                        <img src="${product.image_url}" alt="${product.product_name}">
                        <!-- Hiển thị tên sản phẩm -->
                        <p class="product-name">${product.product_name}</p>
                        <!-- Hiển thị giá sản phẩm -->
                        <p class="price">${product.price} đ</p>
                    </div>
                </a>
            </c:forEach>
        </div>
        <div class="view-all-container">
            <a href="Product" class="view-all">XEM TẤT CẢ</a>
        </div>
    </div>

    <div class="container_2">
        <div class="product-container">
            <h1>SẢN PHẨM BÁN CHẠY</h1>
        </div>
        <div class="product-grid">
            <c:forEach var="product" items="${bestSellingProducts}">
                <a class="product-link" href="${pageContext.request.contextPath}/Detail?product_id=<c:out value='${product.product_id}' />">

                <div class="product">
                    <img src="${product.image_url}" alt="${product.product_name}">
                    <!-- Hiển thị tên sản phẩm -->
                    <p class="product-name">${product.product_name}</p>
                    <!-- Hiển thị giá sản phẩm -->
                    <p class="price">${product.price} đ</p>
                </div>
            </c:forEach>
        </div>
        <div class="view-all-container">
            <a href="Product" class="view-all">XEM TẤT CẢ</a>
        </div>
    </div>

    <div class="container_3">
        <div class="feature-item">
            <img src="images/doi-tra-365.png" alt="Đổi trả">
            <p>ĐỔI TRẢ 7 NGÀY</p>
        </div>
        <div class="feature-item">
            <img src="images/gear.png" alt="Bảo hành">
            <p>MIỄN PHÍ BẢO HÀNH ĐẾN 3 NĂM</p>
        </div>
        <div class="feature-item">
            <img src="images/shipped.png" alt="Miễn phí giao hàng">
            <p>MIỄN PHÍ ĐƠN HÀNG TỪ 399K</p>
        </div>
        <div class="feature-item">
            <img src="images/badge.png" alt="Chính hãng">
            <p>SẢN PHẨM CHÍNH HÃNG</p>
        </div>
    </div>

    <div class="container_4">
        <h1 class="testimonial-title">PHẢN HỒI KHÁCH HÀNG</h1>
        <div class="testimonials">
            <!-- Loop through the testimonials -->
            <c:forEach var="testimonial" items="${testimonials}">
                <div class="testimonial">
                    <!-- Display the testimonial image -->
                    <img src="${testimonial.image}" alt="${testimonial.review_name}" class="testimonial-avatar">

                    <!-- Display the testimonial content -->
                    <div class="testimonial-content-wrapper">
                        <p class="testimonial-content">“${testimonial.content}”</p>
                        <p class="testimonial-author">${testimonial.review_name},<br>${testimonial.review_date}</p>
                    </div>


                </div>
            </c:forEach>
        </div>
    </div>


</div>
</body>
</html>