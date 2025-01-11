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
<%--    <span> (<c:out value="${product.reviewsCount}" /> đánh giá)</span>--%>
<%--    <span> (<c:out value="${product.likesCount}" /> lượt thích)</span>--%>
  </div>

  <div class="product-price"><c:out value="${product.price}" /> đ</div>

  <a href="GioHang.jsp" class="btn btn-primary">Mua ngay</a>
  <a href="GioHang.jsp" class="btn btn-secondary">Thêm vào giỏ hàng</a>

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
<div class="product-description-details">
<h2>MÔ TẢ SẢN PHẨM</h2>
<%--<p><c:out value="${product.longDescription}" /></p>--%>
</div>

<!-- Sản phẩm liên quan -->
<div class="related-products">
<h1>CÓ THỂ BẠN CŨNG THÍCH</h1>
<div class="product-grid">
  <c:forEach var="relatedProduct" items="${relatedProducts}">
    <div class="product-card">
      <img src="<c:out value='${relatedProduct.image_url}' />" alt="<c:out value='${relatedProduct.product_name}' />">
      <p class="product-name"><c:out value="${relatedProduct.product_name}" /></p>
      <p class="price"><c:out value="${relatedProduct.price}" /> đ</p>
      <a href="productDetail.jsp?product_id=<c:out value='${relatedProduct.product_id}' />" class="btn btn-link">Xem chi tiết</a>
    </div>
  </c:forEach>
</div>
<a href="Products.jsp" class="view-all">XEM TẤT CẢ</a>
</div>
</div>
</body>
</html>
