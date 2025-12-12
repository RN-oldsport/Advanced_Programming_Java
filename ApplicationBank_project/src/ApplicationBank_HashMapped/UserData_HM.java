package ApplicationBank_HashMapped;

import java.util.HashMap;

public class UserData_HM {
    private HashMap<String, String[]> usersByUsername;
    private HashMap<String, String[]> usersByCardNumber;
    private static int counter = 0;

    public UserData_HM() {
        usersByUsername = new HashMap<>();
        usersByCardNumber = new HashMap<>();
    }

    public String[] getAccount(int index) {
        return null;
    }

    public String[] getAccountByUsername(String username) {
        return usersByUsername.get(username);
    }

    public void addAccount(String[] rawData) {
        if (!dataCheck(rawData)) {return;}

        String cardNumber = generateCardNumber();

        String balance = "0";
        String idx = String.valueOf(counter);

        String[] accountData = new String[]{rawData[0], rawData[1], rawData[2], rawData[3], rawData[4], cardNumber, balance, idx};

        usersByUsername.put(rawData[0], accountData);
        usersByCardNumber.put(cardNumber, accountData);

        counter++;
        System.out.println("Registered successfully.");
        System.out.println("Assigned card number: " + cardNumber);
    }

    private boolean dataCheck(String[] rawData) {
        if (!Validation_HM.isValidPhone(rawData[3])) {System.out.println("phone invalid"); return false;}
        if (!Validation_HM.isValidPassword(rawData[1])) {System.out.println("password invalid"); return false;}
        if (!Validation_HM.isValidEmail(rawData[4])) {System.out.println("email invalid"); return false;}

        if (usersByUsername.containsKey(rawData[0])) { // CHANGED
            System.out.println("Error: username already exists");
            return false;
        }
        return true;
    }

    private String generateCardNumber() {
        String card;
        do {
            StringBuilder sb = new StringBuilder("6037");
            for (int i = 0; i < 12; i++) {
                int digit = (int)(Math.random() * 10);
                sb.append(digit);
            }
            card = sb.toString();

        } while (usersByCardNumber.containsKey(card));

        return card;
    }


    public int findByUsername(String username) {
        // OLD loop removed
        return usersByUsername.containsKey(username) ? 0 : -1;
    }

    public int findByCardNumber(String cardNumber) {
        return usersByCardNumber.containsKey(cardNumber) ? 0 : -1;
    }

    public boolean updateBalance(String username, String newBalance) {
        String[] account = usersByUsername.get(username);
        if (account == null) return false;
        account[6] = newBalance;
        return true;
    }

    public String[] getAccountByCardNumber(String cardNumber) {
        return usersByCardNumber.get(cardNumber);
    }
}
