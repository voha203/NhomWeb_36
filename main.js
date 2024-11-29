
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
function toggleSidebar() {
    const sidebar = document.querySelector('.sidebar'); // Lấy phần tử sidebar
    sidebar.classList.toggle('active'); // Thêm hoặc xóa class "active"
}



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

 function toggleSidebar() {
            const sidebar = document.querySelector('.sidebar');
            const adminContainer = document.getElementById('admin-container');
            const isSidebarVisible = sidebar.style.transform === 'translateX(0%)';

            if (isSidebarVisible) {
                sidebar.style.transform = 'translateX(-100%)';
                adminContainer.style.marginLeft = '0';
            } else {
                sidebar.style.transform = 'translateX(0%)';
                adminContainer.style.marginLeft = '250px';
            }
        }