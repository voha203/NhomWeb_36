function showMessage(message, type = 'success') {
    alert(`${type.toUpperCase()}: ${message}`);
}

// Login Page
if (document.querySelector('.login-form')) {
    document.querySelector('.login-form').addEventListener('submit', function (event) {
        event.preventDefault();
        const username = document.getElementById('username').value.trim();
        const password = document.getElementById('password').value.trim();

        if (username && password) {
            // Perform login logic (e.g., API call)
            showMessage('Đăng nhập thành công!', 'success');
        } else {
            showMessage('Vui lòng nhập đầy đủ thông tin!', 'error');
        }
    });
}