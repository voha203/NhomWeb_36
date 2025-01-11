<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  Product product = (Product) request.getAttribute("product"); // Lấy sản phẩm từ Servlet
  List<Product> relatedProducts = (List<Product>) request.getAttribute("relatedProducts"); // Sản phẩm liên quan
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><c:out value="${product.product_name}" /> - Chi tiết sản phẩm</title>
  <link rel="stylesheet" href="styles.css"> <!-- Đường dẫn file CSS -->
  <script src="scripts.js" defer></script> <!-- Đường dẫn file JavaScript -->
</head>
<body>
<div class="container">

  <!-- Chi tiết sản phẩm -->
  <div class="product-details">
    <div class="product-left">
      <div class="main-image">
        <img src="<c:out value='${product.image_url}' />" alt="<c:out value='${product.product_name}' />">
      </div>
      <div class="thumbnail-images">
        <c:forEach var="image" items="${product.imageUrls}">
          <img src="<c:out value='${image}' />" alt="Thumbnail" class="thumbnail" onclick="changeImage('<c:out value='${image}' />')">
        </c:forEach>
      </div>
    </div>

    <div class="product-right">
      <h1 class="product-title"><c:out value="${product.product_name}" /></h1>
      <p class="product-description"><c:out value="${product.description}" /></p>

      <div class="rating">
        <span>⭐⭐⭐⭐☆</span>
        <span> (<c:out value="${product.reviewsCount}" /> đánh giá)</span>
        <span> (<c:out value="${product.likesCount}" /> lượt thích)</span>
      </div>

      <div class="product-price"><c:out value="${product.price}" /> đ</div>

      <div class="options">
        <p>Màu: <span class="color-sample"><c:out value="${product.color}" /></span></p>
        <p>Kích thước: <span class="size"><c:out value="${product.size}" /></span></p>
      </div>

      <a href="GioHang.jsp" class="btn btn-primary">Mua ngay</a>
      <a href="GioHang.jsp" class="btn btn-secondary">Thêm vào giỏ hàng</a>

      <div class="features">
        <c:forEach var="feature" items="${features}">
          <div class="feature-item">
            <img src="<c:out value='${feature.image}' />" alt="<c:out value='${feature.title}' />">
            <p><c:out value="${feature.description}" /></p>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>

  <!-- Chi tiết mô tả sản phẩm -->
  <div class="product-description-details">
    <h1>CHI TIẾT SẢN PHẨM</h1>
    <h2>MÔ TẢ SẢN PHẨM</h2>
    <p><c:out value="${product.longDescription}" /></p>
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
          <a href="ChiTietSanPham.jsp?productId=<c:out value='${relatedProduct.product_id}' />" class="btn btn-link">Xem chi tiết</a>
        </div>
      </c:forEach>
    </div>
    <a href="TrangSanPham.jsp" class="view-all">XEM TẤT CẢ</a>
  </div>

</div>
</body>
</html>
