
function changeImage(imageSrc) {
    document.getElementById('displayed-image').src = imageSrc;
}

// Hàm thay đổi hình ảnh chính
function changeImage(imageSrc) {
    const mainImage = document.querySelector('.main_image img'); // Chọn hình ảnh chính
    mainImage.src = imageSrc; // Thay đổi src của hình ảnh chính
}

// Gán sự kiện onclick cho các hình ảnh nhỏ
document.querySelectorAll('.thumbnail').forEach((thumbnail) => {
    thumbnail.addEventListener('click', function () {
        changeImage(this.src); // Thay đổi hình ảnh chính dựa trên hình ảnh nhỏ được bấm
    });
});


function changeContent(contentId) {
    // Ẩn tất cả các phần nội dung
    const contents = document.querySelectorAll('.content');
    contents.forEach(content => {
        content.classList.remove('active');
    });

    // Hiển thị phần nội dung được chọn
    const selectedContent = document.getElementById(contentId);
    if (selectedContent) {
        selectedContent.classList.add('active');
    }
}

 // Toggle Sidebar
function toggleSidebar() {
    const sidebar = document.querySelector('.sidebar');
    const adminContainer = document.getElementById('admin-container');

    if (sidebar.classList.contains('active')) {
        // Nếu Sidebar đang hiện
        sidebar.classList.remove('active'); // Ẩn Sidebar
        adminContainer.style.marginLeft = '0'; // Đưa nội dung chính về toàn màn hình
    } else {
        // Nếu Sidebar đang ẩn
        sidebar.classList.add('active'); // Hiện Sidebar
        adminContainer.style.marginLeft = '250px'; // Đẩy nội dung chính sang phải
    }
}
// Array để lưu các sản phẩm trong giỏ hàng
let cart = [];

// Hàm cập nhật hiển thị giỏ hàng
function updateCart() {
    const cartContentLeft = document.querySelector('.cart-content-left table');
    const cartContentRight = document.querySelector('.cart-content-right table');
    const cartRightText = document.querySelector('.cart-content-right-text');

    let totalItems = 0;
    let totalPrice = 0;

    // Làm sạch nội dung bảng giỏ hàng
    cartContentLeft.innerHTML = `
        <tr>
            <th>Sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Màu</th>
            <th>Size</th>
            <th>SL</th>
            <th>Thành Tiền</th>
            <th>Xóa</th>
        </tr>
    `;

    // Duyệt qua các sản phẩm trong giỏ
    cart.forEach((item, index) => {
        const itemTotal = item.quantity * item.price;
        totalItems += item.quantity;
        totalPrice += itemTotal;

        const row = document.createElement('tr');
        row.innerHTML = `
            <td><img src="${item.image}" alt="${item.name}" style="width: 50px;"></td>
            <td><p>${item.name}</p></td>
            <td><p>${item.color}</p></td>
            <td>${item.size}</td>
            <td>
                <input type="number" value="${item.quantity}" min="1" onchange="updateQuantity(${index}, this.value)">
            </td>
            <td><p>${itemTotal.toLocaleString()} <sup>đ</sup></p></td>
            <td><button onclick="removeItem(${index})">X</button></td>
        `;
        cartContentLeft.appendChild(row);
    });

    // Cập nhật tổng tiền giỏ hàng
    cartContentRight.innerHTML = `
        <tr>
            <th colspan="2">Tổng Tiền Giỏ Hàng</th>
        </tr>
        <tr>
            <td>Tổng sản phẩm</td>
            <td>${totalItems}</td>
        </tr>
        <tr>
            <td>Tổng tiền hàng</td>
            <td>${totalPrice.toLocaleString()} <sup>đ</sup></td>
        </tr>
        <tr>
            <td>Tạm tính</td>
            <td><p style="color: black; font-weight: bold;">${totalPrice.toLocaleString()} <sup>đ</sup></p></td>
        </tr>
    `;

    // Cập nhật thông báo miễn phí vận chuyển
    if (totalPrice >= 1500000) {
        cartRightText.innerHTML = `<p style="color: green; font-weight: bold;">Bạn đã được miễn phí vận chuyển!</p>`;
    } else {
        const needed = 1500000 - totalPrice;
        cartRightText.innerHTML = `
            <p>Bạn sẽ nhận miễn phí ship khi đơn hàng của bạn có tổng giá trị > 1.500.000 <sup>đ</sup></p>
            <p style="color: red; font-weight: bold;">Mua thêm <span style="font-size: 18px">${needed.toLocaleString()}</span> để có free ship</p>
        `;
    }
}

// Thêm sản phẩm vào giỏ hàng
function addToCart(product) {
    const existingItem = cart.find(item => item.id === product.id);
    if (existingItem) {
        existingItem.quantity += 1;
    } else {
        cart.push({ ...product, quantity: 1 });
    }
    updateCart();
}

// Cập nhật số lượng sản phẩm
function updateQuantity(index, quantity) {
    cart[index].quantity = parseInt(quantity);
    updateCart();
}

// Xóa sản phẩm khỏi giỏ hàng
function removeItem(index) {
    cart.splice(index, 1);
    updateCart();
}

// Ví dụ gọi hàm thêm sản phẩm
function handleAddToCart() {
    const product = {
        id: 1,
        name: 'Balo Unisex',
        image: './images/1165.jpg',
        color: 'Xanh',
        size: 'Free Size',
        price: 215000
    };
    addToCart(product);
}

// Chuyển hướng
function continueShopping() {
    window.location.href = 'TrangSanPham.html';
}

function proceedToCheckout() {
    window.location.href = 'GiaoHang.html';
}


