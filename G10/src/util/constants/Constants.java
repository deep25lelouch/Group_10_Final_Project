/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.constants;

/**
 *
 * @author RIO
 */

//Rijurik_Saha_002525961
public class Constants {

    // System Constants
    public static final String SYSTEM_NAME = "Community Issue Reporting & Resolution Management System";
    public static final String SYSTEM_VERSION = "1.0.0";

    // Default Values
    public static final String DEFAULT_CITY = "Boston";
    public static final String DEFAULT_STATE = "MA";
    public static final String DEFAULT_COUNTRY = "USA";

    // Pagination
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 50;

    // Work Request
    public static final int WORK_REQUEST_ID_LENGTH = 8;
    public static final String WORK_REQUEST_PREFIX = "WR-";
    public static final String CITIZEN_ID_PREFIX = "CIT-";

    // Time Constants (in milliseconds)
    public static final long ONE_HOUR = 3600000;
    public static final long ONE_DAY = 86400000;
    public static final long ONE_WEEK = 604800000;

    // Validation Constants
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 20;
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 50;

    // UI Constants
    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 800;
    public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";

    // Messages
    public static final String LOGIN_SUCCESS = "Login successful!";
    public static final String LOGIN_FAILED = "Invalid username or password!";
    public static final String REGISTRATION_SUCCESS = "Registration successful!";
    public static final String WORK_REQUEST_CREATED = "Work request created successfully!";
    public static final String WORK_REQUEST_UPDATED = "Work request updated successfully!";

    // Error Messages
    public static final String ERROR_INVALID_EMAIL = "Please enter a valid email address!";
    public static final String ERROR_INVALID_PHONE = "Please enter a valid phone number!";
    public static final String ERROR_WEAK_PASSWORD = "Password must contain at least 8 characters, including uppercase, lowercase, digit and special character!";
    public static final String ERROR_PASSWORDS_DONT_MATCH = "Passwords do not match!";
    public static final String ERROR_REQUIRED_FIELD = "This field is required!";
}
