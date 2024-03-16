/**
 * 
 */
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