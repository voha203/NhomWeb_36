<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/13/2025
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/base.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>
<div class="container">

    <div class="container_0">
        <div class="hinhanh">
            <img src="images/slider_1_master.webp" alt="Balo MWC">

        </div>

    </div>

    <div class="container_1">

        <div class="product-container">
            <h1>SẢN PHẨM MỚI</h1>

        </div>
        <div class="product-grid">
            <a href="ChiTietSanPham.html" class="product-link">
                <div class="product">
                    <img src="images/1165.jpg" alt="Balo MWC 1165">
                    <p class="product-name">BALO 1165 - Balo Unisex Du Lịch Thời Trang</p>
                    <p class="price">215.000 đ</p>
                </div>
            </a>
            <div class="product">
                <img src="images/1168.jpg" alt="Balo MWC 1257">
                <p class="product-name">BALO MWC 1168 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">215.000 đ</p>
            </div>

            <div class="product">
                <img src="images/1216.jpg" alt="Balo 1216">
                <p class="product-name">BALO 1216 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">395.000 đ</p>
            </div>
            <div class="product">
                <img src="images/1113.jpg" alt="Balo 1113">
                <p class="product-name">BALO 1113 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">180.000 đ</p>
            </div>
            <div class="product">
                <img src="images/1185.jpg" alt="Balo 1185">
                <p class="product-name">BALO MWC 1185 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">295.000 đ</p>
            </div>

        </div>
        <div class="view-all-container">

            <a href="TrangSanPham.html" class="view-all">XEM TẤT CẢ</a>
        </div>
    </div>

    <div class="container_2">

        <div class="product-container">
            <h1>SẢN PHẨM BÁN CHẠY</h1>

        </div>
        <div class="product-grid">
            <div class="product">
                <img src="images/1218.jpg" alt="Balo 1218">
                <p class="product-name">BALO 1218 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">275.000 đ</p>
            </div>
            <div class="product">
                <img src="images/1108.jpg" alt="Balo 1108">
                <p class="product-name">BALO 1108 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">295.000 đ</p>
            </div>

            <div class="product">
                <img src="images/1090.jpg" alt="Balo 1090">
                <p class="product-name">BALO 1090 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">215.000 đ</p>
            </div>
            <div class="product">
                <img src="images/1239.jpg" alt="Balo MWC 1239">
                <p class="product-name">BALO 1239 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">375.000 đ</p>
            </div>
            <div class="product">
                <img src="images/1144.jpg" alt="Balo 1144">
                <p class="product-name">BALO 1144 - Balo Unisex Du Lịch Thời Trang</p>
                <p class="price">250.000 đ</p>
            </div>

        </div>
        <div class="view-all-container">
            <a href="TrangSanPham.html" class="view-all">XEM TẤT CẢ</a>
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
            <!-- Testimonial 1 -->

            <div class="testimonial">
                <img src="images/av2.jpg" alt="Võ Ngọc Quyết" class="testimonial-avatar">
                <div class="testimonial-content-wrapper">
                    <p class="testimonial-content">
                        “Chuyến đi công tác vừa rồi tôi cần Balo Laptop size lớn để vừa đựng Laptop vừa để thêm quần
                        áo.
                        Sau khi cân nhắc thì tôi chọn cách đặt hàng Online. Tôi rất hài lòng về chất lượng sản phẩm
                        Shop cung cấp...”
                    </p>
                    <p class="testimonial-author">Anh Võ Ngọc Quyết,<br>Founder & CEO LEATERMAN Jsc</p>
                </div>
            </div>

            <!-- Testimonial 2 -->
            <div class="testimonial">
                <img src="images/av3.jpg" alt="Emily Doan" class="testimonial-avatar">
                <div class="testimonial-content-wrapper">
                    <p class="testimonial-content">
                        “Cách đây 3 tháng mình mua balo tặng bạn trai, dùng chưa tới 5 ngày thì bị hỏng khóa kéo.
                        Mình liên hệ với Shop thì được hỗ trợ hoàn toàn miễn phí...”
                    </p>
                    <p class="testimonial-author">Chị Emily Doan,<br>Nhà Phân Phối Mỹ Phẩm SiCa White</p>
                </div>
            </div>

            <!-- Testimonial 3 -->
            <div class="testimonial">
                <img src="images/av4.jpg" alt="Trần Phong" class="testimonial-avatar">
                <div class="testimonial-content-wrapper">
                    <p class="testimonial-content">
                        “Từ khi biết đến cửa hàng, mình hầu như không mua đồ Balo cặp túi công sở nơi khác nữa. Ở
                        đây bán balo rất chất lượng.”
                    </p>
                    <p class="testimonial-author">Anh Trần Phong,<br>Sáng Lập LeonDio.com</p>
                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>
