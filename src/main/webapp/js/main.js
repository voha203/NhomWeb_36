
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
console.log('main.js loaded successfully');
