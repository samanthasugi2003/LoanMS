package src.util;

/**
 * InputValidator class handles all input validation for the Loan Management System.
 * Validates various types of user inputs including numbers, formats, and ranges.
 */
public class InputValidator {

    /**
     * Checks if a string input is empty or null
     */
    public static boolean isEmptyString(String input) {
        return input == null || input.trim().isEmpty();
    }

    /**
     * Validates if a string is a valid number (double)
     */
    public static boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates if a string is a valid integer
     */
    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates that a number is positive (greater than 0)
     */
    public static boolean isPositiveNumber(double number) {
        return number > 0;
    }

    /**
     * Validates that a number is not negative (greater than or equal to 0)
     */
    public static boolean isNonNegative(double number) {
        return number >= 0;
    }

    /**
     * Validates if the interest rate is within reasonable range (0-50%)
     */
    public static boolean isValidInterestRate(double rate) {
        return rate >= 0 && rate <= 50;
    }

    /**
     * Validates phone number format (Rwandan format: 10 digits)
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (isEmptyString(phoneNumber)) {
            return false;
        }
        // Rwandan phone format: 10 digits, can start with +250 or 0
        String cleaned = phoneNumber.replaceAll("[^0-9+]", "");
        return cleaned.matches("^(\\+250|0)?[1-9]\\d{8}$");
    }

    /**
     * Validates National ID format (16-digit Rwandan ID or 16 character format)
     */
    public static boolean isValidNationalId(String nationalId) {
        if (isEmptyString(nationalId)) {
            return false;
        }
        // Rwandan National ID is typically 16 characters
        return nationalId.length() == 16 && nationalId.matches("[0-9A-Z]+");
    }

    /**
     * Validates loan type against allowed types
     */
    public static boolean isValidLoanType(String loanType) {
        if (isEmptyString(loanType)) {
            return false;
        }
        String[] validTypes = {"PERSONAL", "HOME", "CAR", "BUSINESS", "STUDENT", "AGRICULTURAL"};
        String upperType = loanType.toUpperCase();
        for (String type : validTypes) {
            if (type.equals(upperType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates that loan amount is within reasonable range
     */
    public static boolean isValidLoanAmount(double amount) {
        return amount > 0 && amount <= 100000000; // Max 100 million
    }

    /**
     * Validates loan duration in months (between 1 and 360 months / 30 years)
     */
    public static boolean isValidLoanDuration(int duration) {
        return duration > 0 && duration <= 360;
    }
}
