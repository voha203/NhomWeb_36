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
    <header class="header">
    </header>
    <div class="container">
        <div class="product-container">
            <h1>TẤT CẢ SẢN PHẨM</h1>
        </div>

        <div class="product-grid">
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                for (Product product : products) {
            %>
            <div class="product">
                <img src="<%= product.getImageUrl() %>" alt="<%= product.getProductName() %>">
                <p class="product-name"><%= product.getProductName() %></p>
                <p class="price"><%= product.getPrice() %> đ</p>
            </div>
            <% } %>
        </div>
    </div>

    <div class="pagination">
        <button class="pagination-btn" disabled>&lt;</button>
        <button class="pagination-btn active">1</button>
        <button class="pagination-btn">2</button>
        <button class="pagination-btn">3</button>
        <button class="pagination-btn">...</button>
        <button class="pagination-btn">8</button>
        <button class="pagination-btn">&gt;</button>
    </div>
</div>

<div id="footer">
    <div class="footer-container">
        <div class="footer-section">
            <h3>Thông tin liên hệ</h3>
            <p><strong>Địa chỉ:</strong> 452G Lũy Bán Bích, phường Hòa Thạnh, Quận Tân Phú, TP Hồ Chí Minh</p>
            <p><strong>Điện thoại:</strong> 0901487456</p>
            <p><strong>Email:</strong> shopbalo.vn</p>
        </div>
        <div class="footer-section">
            <h3>Hỗ trợ khách hàng</h3>
            <ul>
                <li>Chính sách bán hàng</li>
                <li>Chính sách thanh toán</li>
                <li>Chính sách đổi trả, bảo hành</li>
            </ul>
        </div>
        <div class="footer-section">
            <h3>Kết nối với chúng tôi</h3>
            <div class="connect-with-us">
                <div class="email-box">
                    <input type="email" id="email-input" placeholder="Your Email Address" />
                    <button type="submit">&#10004;</button>
                </div>
                <div class="social-icons">
                    <a href="#"><img src="<%= request.getContextPath() %>/images/FACE.jpg" alt="Facebook"></a>
                    <a href="#"><img src="<%= request.getContextPath() %>/images/instagram1.jpg" alt="instagram"></a>
                    <a href="#"><img src="<%= request.getContextPath() %>/images/dt.jpg" alt="goidien"></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
