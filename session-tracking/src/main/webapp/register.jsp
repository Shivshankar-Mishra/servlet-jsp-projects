<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            max-width: 400px;
            width: 400px;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        h2 {
            text-align: center;
        }

        .form-group {
        	margin-right: 20px;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        select {
            appearance: none;
        }

        .icon {
            position: absolute;
            padding: 12px;
            pointer-events: none;
        }

        .icon-user::before {
            content: "\f007";
            font-family: FontAwesome;
        }

        .icon-envelope::before {
            content: "\f0e0";
            font-family: FontAwesome;
        }

        .icon-phone::before {
            content: "\f095";
            font-family: FontAwesome;
        }

        .icon-location::before {
            content: "\f041";
            font-family: FontAwesome;
        }

        .submit-btn {
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            display: block;
            margin: 0 auto;
        }

        .submit-btn:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: #ff0000;
        }
    </style>
</head>
<body>
<div class="container">
        <h2>Registration Form</h2>
        <form id="registration-form" action="registration" method="post">
        	
            <div class="form-group">
                <label for="name"><span class="fa-solid fa-user"></span> Name</label>
                <input type="text" id="name" name="name" required>
                <div class="error-message" id="name-error"></div>
            </div>
            <div class="form-group">
                <label for="email"><span class="icon-envelope"></span> Email</label>
                <input type="email" id="email" name="email" required>
                <div class="error-message" id="email-error"></div>
            </div>
            <div class="form-group">
                <label for="phone"><span class="icon-phone"></span> Phone</label>
                <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required>
                <div class="error-message" id="phone-error"></div>
            </div>
            <div class="form-group">
                <label for="gender"><span class="fa-solid fa-venus-mars"></span> Gender</label>
                <input type="radio" id="gender" name="gen" value="male">Male
                <input type="radio" id="gender" name="gen" value="female">Female
                <div class="error-message" id="phone-error"></div>
            </div>
            <div class="form-group">
                <label for="city"><span class="icon-location"></span> City</label>
                <select id="city" name="address" required>
                    <option value="" disabled selected>Select your city</option>
                    <option value="Uttar Pradesh">Uttar Pradesh</option>
                    <option value="Noida">Hariyana</option>
                    <option value="Delhi">Delhi</option>
                    <option value="Bihar">Bihar</option>
                    <option value="Jammu Kashmir">Jammu Kashmir</option>
                </select>
                <div class="error-message" id="city-error"></div>
            </div>
            <div class="form-group">
                <label for="pass"><span class="fa-solid fa-key"></span> Password</label>
                <input type="password" id="pass" name="pass" required>
                <div class="error-message" id="email-error"></div>
            </div>
            <div class="form-group">
                <input type="submit" class="submit-btn" value="Submit">
            </div>
        </form>
    </div>

    <script>
        const form = document.getElementById("registration-form");
        form.addEventListener("submit", function (e) {
            let isValid = true;

            // Validation for Name
            const name = document.getElementById("name");
            const nameError = document.getElementById("name-error");
            if (!name.value.trim()) {
                nameError.textContent = "Name is required.";
                isValid = false;
            } else {
                nameError.textContent = "";
            }

            // Validation for Email
            const email = document.getElementById("email");
            const emailError = document.getElementById("email-error");
            const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            if (!email.value.match(emailPattern)) {
                emailError.textContent = "Enter a valid email address.";
                isValid = false;
            } else {
                emailError.textContent = "";
            }

            // Validation for Phone
            const phone = document.getElementById("phone");
            const phoneError = document.getElementById("phone-error");
            if (!phone.value.match(/^\d{10}$/)) {
                phoneError.textContent = "Enter a 10-digit phone number.";
                isValid = false;
            } else {
                phoneError.textContent = "";
            }

            // Validation for City
            const city = document.getElementById("city");
            const cityError = document.getElementById("city-error");
            if (city.value === "") {
                cityError.textContent = "Select your city.";
                isValid = false;
            } else {
                cityError.textContent = "";
            }

            if (!isValid) {
                e.preventDefault(); // Prevent form submission if validation fails
            }
        });
    </script>
</body>
</html>