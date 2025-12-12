package ApplicationBank_HashMapped;

// command, String userName, String password, String fullName, String phoneNumber, String email, String cardNumber, 6 balance , 7 idx


import java.util.Arrays;
import java.util.Scanner;

public class MainApp_HM {
    public static Scanner scn = new Scanner(System.in);
    private static String[] currentAcc = null;
    private BankServices_HM bank;
    private UserData_HM userData;

    public MainApp_HM() {
        userData = new UserData_HM();
        bank = new BankServices_HM(userData);
    }

    public void execute(String query) {

        String[] queryList = query.split(" ");
        switch (queryList[0]) {
            case "logout":
                logout();
                break;
            case "login":
                currentAcc = bank.login(queryList[1], queryList[2]);
                break;
            case "register":
                String[] rawData = new String[5];
                int j = 0;
                for (int i = 1; i < queryList.length; i++) {
                    if (i == 3) {continue;}
                    rawData[j] = queryList[i];
                    j++;
                }
                userData.addAccount(rawData);
                break;
            case "show":
                if (!isLoggedIn()) {return;}
                bank.showBalance(currentAcc[0]);
                break;
            case "deposit":
                if (!isLoggedIn()) {return;}
                bank.deposit(currentAcc[0], queryList[1]);
                break;
            case "withdraw":
                if (!isLoggedIn()) {return;}
                bank.withdraw(currentAcc[0], queryList[1]);
                break;
            case "transfer":
                if (!isLoggedIn()) {return;}
                bank.transfer(currentAcc[0], queryList[1], queryList[2]);
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    public boolean isLoggedIn() {
        if(currentAcc == null) {
        System.out.println("Please login first.");
        return false;
        }
        return true;
    }

    public void logout() {
        if (currentAcc != null) {
            currentAcc = null;
            System.out.println("Logout successful.");
            return;
        }
        System.out.println("You're already logged out.");
    }

    public static void main(String[] args) {
        MainApp_HM mainApp = new MainApp_HM();

        while (true) {
            String query = scn.nextLine();

            if (query.equals("exit")) {
                break;
            }
            mainApp.execute(query);
        }
    }
}