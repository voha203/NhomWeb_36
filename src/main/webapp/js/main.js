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

console.log('main.js loaded successfully')


    document.addEventListener("DOMContentLoaded", function () {
    const deleteButtons = document.querySelectorAll(".delete-button");

    deleteButtons.forEach(button => {
    button.addEventListener("click", function () {
    const row = this.closest("tr");
    const userId = row.querySelector("td:first-child").innerText;

    if (confirm(`Bạn có chắc muốn xóa nhân viên với ID: ${userId}?`)) {
    // Gửi yêu cầu xóa đến server
    fetch(`/Admin?user_id=${userId}`, {
    method: "DELETE"
})
    .then(response => {
    if (response.ok) {
    alert("Xóa thành công!");
    row.remove(); // Xóa dòng khỏi bảng
} else {
    alert("Xóa thất bại. Vui lòng thử lại.");
}
})
    .catch(error => {
    console.error("Lỗi:", error);
    alert("Đã xảy ra lỗi khi xóa.");
});
}
});
});
});

