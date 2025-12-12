package ApplicationBank_HashMapped;

public class Validation_HM {

    public static boolean isValidPhone(String phoneNumber) {
        if (phoneNumber.length() != 11) {return false;}
        if (!phoneNumber.startsWith("09")) {return false;}
        for (char s : phoneNumber.toCharArray()) {
            if (!Character.isDigit(s)) {return false;}
        }

        return true;
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {return false;}

        boolean hasUpper = false;
        boolean hasLower = true;
        for (char s : password.toCharArray()) {
            if (Character.isUpperCase(s)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(s)) {
                hasLower = true;
            }
        }
        if (!hasUpper || !hasLower) {return false;}

        boolean hasDigit = false;
        for (char s : password.toCharArray()) {
            if (Character.isDigit(s)) {
                hasDigit = true;
            }
        }
        if (!hasDigit) {return false;}

        boolean hasSpecial = false;
        for (char s : password.toCharArray()) {
            if (s == '@' || s == '?' || s == '$' || s == '!' || s == '&') {
                hasSpecial = true;}
            }
        if (!hasSpecial) {return false;}


        return true;
    }

    public static boolean isValidEmail(String email) {
        if (email.length() < 9) {return false;}

        if (!email.endsWith("@aut.com")) {return false;}

        if (email.startsWith(".") || email.startsWith("@")) {return false;}

        return true;
    }
}
