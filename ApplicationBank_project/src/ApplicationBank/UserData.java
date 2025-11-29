package ApplicationBank;


import java.util.ArrayList;


public class UserData {
    private ArrayList<String[]> accounts;
    private static int counter = 0;

    public UserData() {
        accounts = new ArrayList<>();
    }

    public String[] getAccount(int index) {
        return accounts.get(index);
    }

    public void addAccount(String[] rawData) {
        if (!dataCheck(rawData)) {return;}

        String cardNumber = generateCardNumber();

        String balance = "0";
        String idx = String.valueOf(counter-1);

        accounts.add(new String[]{rawData[0], rawData[1], rawData[2], rawData[3],  rawData[4], cardNumber, balance, idx});
        System.out.println("Registered successfully.");
        System.out.println("Assigned card number: " + cardNumber);
    }

    private boolean dataCheck(String[] rawData) {
        // information validation
        if (!Validation.isValidPhone(rawData[3])) {System.out.println("phone invalid"); return false;}
        if (!Validation.isValidPassword(rawData[1])) {System.out.println("password invalid"); return false;}
        if (!Validation.isValidEmail(rawData[4])) {System.out.println("email invalid"); return false;}

        // unique username
        for (String[] acc : accounts) {
            if (rawData[0].equals(acc[0])) {
                System.out.println("Error: username already exists");
                return false;
            }
        }
        return true;
    }

    private String generateCardNumber() {
        return "6037123456789" + String.format("%03d", counter++);
    }

    public int findByUsername(String username) {
        for (int index = 0; index < accounts.size(); index++) {
            if (accounts.get(index)[0].equals(username)) {
                return index;
            }
        }
        return -1;
    }

    public int findByCardNumber(String cardNumber) {
        for (int index = 0; index < accounts.size(); index++) {
            if (accounts.get(index)[5].equals(cardNumber)) {
                return index;
            }
        }
        return -1;
    }

    public boolean updateBalance(int index, String newBalance) {
        if (index != -1) {
        accounts.get(index)[6] = newBalance;
        } else {
            return false;
        }
        return true;
    }


}


// String userName, String password, String fullName, String phoneNumber, String email, String cardNumber, 6 balance