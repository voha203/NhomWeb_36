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
if (document.querySelector('.register-form')) {
    document.querySelector('.register-form').addEventListener('submit', function (event) {
        event.preventDefault();
        const email = document.getElementById('email').value.trim();
        const username = document.getElementById('username').value.trim();
        const phone = document.getElementById('phone').value.trim();
        const password = document.getElementById('password').value.trim();
        const confirmPassword = document.getElementById('confirm-password').value.trim();

        if (!email || !username || !phone || !password || !confirmPassword) {
            showMessage('Vui lòng nhập đầy đủ thông tin!', 'error');
            return;
        }

        if (password !== confirmPassword) {
            showMessage('Mật khẩu xác nhận không khớp!', 'error');
            return;
        }

        // Perform registration logic (e.g., API call)
        showMessage('Đăng ký thành công!', 'success');
    });
}