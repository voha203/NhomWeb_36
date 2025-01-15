<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  Product product = (Product) request.getAttribute("products"); // Lấy sản phẩm từ Servlet
  List<Product> relatedProducts = (List<Product>) request.getAttribute("relatedProducts"); // Sản phẩm liên quan
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title><c:out value="${product.product_name}" /> - Chi tiết sản phẩm</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/font_Icon/themify-icons-font/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/base.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300&family=Roboto:wght@300;400;500;700&display=swap">
</head>
<body>

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

  <!-- Chi tiết sản phẩm -->
  <div class="container_ctsp_1">
    <div class="product_left">
      <div class="main_image">
        <img src="<c:out value='${product.image_url}' />" alt="<c:out value='${product.product_name}' />">
      </div>
      <div class="thumbnail_images">
        <c:forEach var="image" items="${imageUrls}">
          <img src="<c:out value='${image}' />" alt="Thumbnail" class="thumbnail" onclick="changeImage('<c:out value='${image}' />')">
        </c:forEach>
      </div>
    </div>

<div class="product_right">
  <h1 class="product-title"><c:out value="${product.product_name}" /></h1>
  <p class="product-description"><c:out value="${product.description}" /></p>

  <div class="rating">
    <span>⭐⭐⭐⭐☆</span>

  </div>

  <div class="product-price"><c:out value="${product.price}" /> đ</div>

  <a href="GioHang.jsp">
    <button class="btn btn-primary">Mua ngay</button>
  </a>

  <a href="GioHang.jsp">
    <button class="btn btn-secondary">Thêm vào giỏ hàng</button>
  </a>

  <div class="container_1_item">
    <div class="feature-items">
      <img src="images/baohanh.jpg" alt="Bảo hàng">
      <p>Bảo hành 3 năm</p>
    </div>
    <div class="feature-items">
      <img src="images/vanchuyen.jpg" alt="Vận chuyển">
      <p>Miễn phí vận chuyển toàn quốc cho đơn hàng từ 399k</p>
    </div>
    <div class="feature-items">
      <img src="images/doitra.jpg" alt="Đổi trả">
      <p>Đổi trả dễ dàng trong vòng 7 ngày nếu lỗi nhà sản xuất </p>
    </div>
    <div class="feature-items">
      <img src="images/hotline.jpg" alt="Hotline">
      <p>Hotline 1900.633.349 hỗ trợ từ 8h30-21h3</p>
    </div>
    <div class="feature-items">
      <img src="images/giaohang.jpg" alt="Giao hàng">
      <p>Giao hàng tận nơi nhận hàng xong thanh toán</p>
    </div>
    <div class="feature-items">
      <img src="images/tichdiem.jpg" alt="Tích diểm">
      <p>Ưu đãi tích điểm và hưởng quyền lợi thành viên</p>
    </div>
  </div>
</div>
</div>

<!-- Mô tả sản phẩm -->
  <div class="container_ctsp_2">

    <div class="title_tdc">
      <h>CHI TIẾT SẢN PHẨM</h>
    </div>

    <div class="mt">
      <div class="title_mt">
        <h1 class="product-title"><c:out value="${product.product_name}" /></h1>
        <p class="product-description"><c:out value="${product.description}" /></p>
        <div class="product-description"><!--MÔ TẢ SẢN PHẨM-->
          <ul>
            <li>Balo thiết kế theo phong cách Hàn Quốc nhiều ngăn rộng rãi dễ dàng sắp xếp và mang theo nhiều đồ.</li>
            <li>Chất liệu vải Canvas kháng nước và bụi bẩn dễ vệ sinh và phù hợp với mọi thời tiết. Lớp lót dù polyester chống nước 2 lần, bảo vệ đồ vật bên trong khi trời mưa.</li>
            <li>Quai đeo có lớp lót đệm xốp tạo cảm giác êm vai, thoải mái mang trong thời gian dài. Có thể điều chỉnh linh hoạt với mọi chiều cao.</li>
          </ul>
        </div>

      </div>

      <div class="title_mt">
        <h1 class="product-title">CHI TIẾT SẢN PHẨM:</h1>
        <div class="product-description"><!--MÔ TẢ SẢN PHẨM-->
          <h1>- Kích thước: 42*30*10</h1>
          <h1>- Chất liệu: Vải canvas</h1>
          <h1>- Họa tiết: Logo hình tròn cùng khóa kéo lạ mắt</h1>
          <h1>- Ngăn chống sốc laptop 15.6 inch</h1>
          <h1>- Xuất xứ: Việt Nam</h1>
        </div>

      </div>

      <div class="title_mt">
        <h1 class="product-title">Thiết kế gồm:</h1>
        <div class="product-description"><!--MÔ TẢ SẢN PHẨM-->
          <h1>-Tổng số ngăn: 5 ngăn</h1>
          <h1>- Bên ngoài: 1 ngăn ngoài may thêm 2 túi đôi nhỏ phía trước</h1>
          <h1>- Bên trong: 1 ngăn chính lớn, 1 ngăn chống sốc</h1>
          <h1>- Quai đeo đệm mút với chức năng chống nhức mỏi khi đeo</h1>
        </div>

      </div>
    </div>

  </div>





<!-- Sản phẩm liên quan -->
<div class="container_ctsp_3">
  <div class="product-container">
  <h1>CÓ THỂ BẠN CŨNG THÍCH</h1>

</div>
<div class="product-grid">
  <c:forEach var="relatedProduct" items="${relatedProducts}">
    <a class="product-link" href="${pageContext.request.contextPath}/Detail?product_id=<c:out value='${product.product_id}' />">
    <div class="product">
      <img src="<c:out value='${relatedProduct.image_url}' />" alt="<c:out value='${relatedProduct.product_name}' />">
      <p class="product-name"><c:out value="${relatedProduct.product_name}" /></p>
      <p class="price"><c:out value="${relatedProduct.price}" /> đ</p>

    </div>
  </c:forEach>
</div>
  <div class="view-all-container">

    <a href="Product" class="view-all">XEM TẤT CẢ</a>
  </div>

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
</body>
<script src="<c:url value='/js/main.js'/>"></script>


</html>
