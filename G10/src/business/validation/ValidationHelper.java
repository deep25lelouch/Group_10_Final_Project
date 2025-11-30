/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.validation;
//Rijurik_Saha_002525961
import java.util.regex.Pattern;

/**
 *
 * @author RIO
 */
public class ValidationHelper {
//Rijurik_Saha_002525961
    // Email validation regex
    private static final String EMAIL_PATTERN
            = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // Phone validation regex (US format)
    private static final String PHONE_PATTERN
            = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";

    // Password must contain: 1 uppercase, 1 lowercase, 1 digit, 1 special char, min 8 chars
    private static final String PASSWORD_PATTERN
            = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        return Pattern.matches(PHONE_PATTERN, phone);
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return name.matches("[a-zA-Z\\s]+") && name.length() >= 2;
    }

    public static boolean isValidZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty()) {
            return false;
        }
        return zipCode.matches("\\d{5}(-\\d{4})?");
    }

    public static String getPasswordStrength(String password) {
        if (password == null || password.isEmpty()) {
            return "No password";
        }

        int strength = 0;
        if (password.length() >= 8) {
            strength++;
        }
        if (password.length() >= 12) {
            strength++;
        }
        if (password.matches(".*[A-Z].*")) {
            strength++;
        }
        if (password.matches(".*[a-z].*")) {
            strength++;
        }
        if (password.matches(".*[0-9].*")) {
            strength++;
        }
        if (password.matches(".*[@#$%^&+=!].*")) {
            strength++;
        }

        if (strength <= 2) {
            return "Weak";
        } else if (strength <= 4) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}
