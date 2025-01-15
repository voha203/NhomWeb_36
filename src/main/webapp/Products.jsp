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
    <header class="header">
        <div class="grid">
            <nav class="header_navbar">
                <ul class="header_navbar-list">
                    <li class="header_navbar-item shop">SHOP TTV-Bag
                        <div class="header__qr">
                            <img src="./assets/img/QR_code.png" alt="" class="header__qr-img">
                            <div class="header__qr-apps">
                                <a href="" class="header__qr-link">
                                    <img src="./assets/img/GG_p.png" alt="Google play" class="header__qr-dl">
                                </a>
                                <a href="" class="header__qr-link">
                                    <img src="./assets/img/App_store.png" alt="App Store" class="header__qr-dl">
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class="header_navbar-item">
                        <span class="header_navbar-title--no-pointer">Kết nối</span>
                        <a class="header__navbar-icon-link"></a>
                        <i class="header_navbar-icons ti-facebook"></i>
                        <a class="header__navbar-icon-link"></a>
                        <i class="header_navbar-icons ti-instagram"></i>
                    </li>
                </ul>

                <ul class="header_navbar-list">
                    <li class="header_navbar-item header__navbar-item--has-notify">
                        <a href="" class="header_navbar-item-link">Thông báo
                            <a class="header__navbar-icon-link"></a>
                            <i class="header_navbar-icons ti-bell"></i>
                        </a>
                        <div class="header__notify">
                            <header class="header__notify-header">
                                <h3>Thông báo mới nhận</h3>
                            </header>
                            <ul class="header__notify-list">
                                <li class="header__notify-item">
                                    <a href="" class="header__notify-link">
                                        <img src="images/mwc0831.jpg" alt="header__notify-img" width="48" height="48">
                                        <div class="header__notify-info">
                                            <span class="header__notify-name">Balo MWC chính hãng</span>
                                            <span class="header__notify-description">Mô tả Balo MWC chính hãng</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="header__notify-item header__notify-item--view">
                                    <a href="" class="header__notify-link">
                                        <img src="images/mwc0831.jpg" alt="header__notify-img" width="48" height="48">
                                        <div class="header__notify-info">
                                            <span class="header__notify-name">Balo MWC chính hãng</span>
                                            <span class="header__notify-description">Mô tả Balo MWC chính hãng</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="header__notify-item">
                                    <a href="" class="header__notify-link">
                                        <img src="images/mwc0831.jpg" alt="header__notify-img" width="48" height="48">
                                        <div class="header__notify-info">
                                            <span class="header__notify-name">Balo MWC chính hãng</span>
                                            <span class="header__notify-description">Mô tả Balo MWC chính hãng</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="header__notify-item">
                                    <a href="" class="header__notify-link">
                                        <img src="images/mwc0831.jpg" alt="header__notify-img" width="48" height="48">
                                        <div class="header__notify-info">
                                            <span class="header__notify-name">Balo MWC chính hãng</span>
                                            <span class="header__notify-description">Mô tả Balo MWC chính hãng</span>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                            <footer class="header__notify-footer">
                                <a href="" class="header__notify-footer-bnt">Xem thông báo</a>
                            </footer>
                        </div>
                    </li>
                    <li class="header_navbar-item">
                        <a href="" class="header_navbar-item-link">Trợ giúp
                            <a class="header__navbar-icon-link"></a>
                            <i class="header_navbar-icons ti-help-alt"></i>
                        </a>
                    </li>
                    <li class="header_navbar-item strong">
                        <a href="">Đăng nhập</a>
                    </li>
                    <li class="header_navbar-item f">
                        <a href="">Đăng ký</a>
                    </li>

                </ul>
            </nav>
            <div class="header-with-search">
                <div class="header__logo">
                    <a href="Home">
                        <img src="images/logoshop.png" alt="header__logo-img" width="70" height="70">
                    </a>
                </div>



                <div class="header__search">
                    <div class="header__search-input-wrap">
                        <input type="text" class="header__search-input" placeholder="Tìm kiếm balo">
                        <!-- search history-->
                        <div class="header__search-history">
                            <h3 class="header__search-history-heading">Lịch sử tìm kiếm</h3>
                            <ul class="header__search-history-list">
                                <li class="header__search-history-item">
                                    <a href="">Balo MWC nam</a>
                                </li>
                                <li class="header__search-history-item">
                                    <a href="">Balo MWC nữ</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="header__search-select">
                        <span class="header__search-select-label">Trong shop</span>
                        <i class="header__search-select-icon ti-angle-down"></i>
                        <ul class="header__search-option">
                            <li class="header__search-option-item header__search-option-item--active">
                                <span>Trong shop</span>
                                <i class="ti-check"></i>
                            </li>
                            <li class="header__search-option-item">
                                <span>Ngoài shop</span>
                                <i class="ti-check"></i>
                            </li>
                        </ul>
                    </div>
                    <button class="header__search-btn">
                        <i class="header__search-btn-icon ti-search"></i>
                    </button>
                </div>
                <!-- cart-->
                <div class="header__cart">
                    <a href=""><i class="header__cart-icon ti-shopping-cart"></i></a>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <div class="product-container">
            <h1>TẤT CẢ SẢN PHẨM</h1>
        </div>

        <div class="product-grid">
            <!-- Lặp qua danh sách sản phẩm -->
            <c:forEach var="product" items="${products}">
                <div class="product">
                    <!-- Link đến trang chi tiết sản phẩm -->
                    <a class="product-link" href="${pageContext.request.contextPath}/Detail?product_id=<c:out value='${product.product_id}' />">

                    <!-- Hiển thị ảnh sản phẩm -->
                        <img src="${product.image_url}" alt="${product.product_name}">
                        <!-- Hiển thị tên sản phẩm -->
                        <p class="product-name">${product.product_name}</p>
                        <!-- Hiển thị giá sản phẩm -->
                        <p class="price">${product.price} đ</p>
                    </a>
                </div>
            </c:forEach>
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
                        <a href="#"><img src="images/FACE.jpg" alt="Facebook"></a>
                        <a href="#"><img src="images/instagram1.jpg" alt="instagram"></a>
                        <a href="#"><img src="images/dt.jpg" alt="goidien"></a>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
</body>
</html>
