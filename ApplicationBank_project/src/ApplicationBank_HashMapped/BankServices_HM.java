package ApplicationBank_HashMapped;

public class BankServices_HM {
    private UserData_HM userData;

    public BankServices_HM(UserData_HM userData) {
        this.userData = userData;
    }

    public String[] login(String username, String password) {
        String[] account = userData.getAccountByUsername(username);
        if (account == null) { System.out.println("Username not found"); return null; }

        if (!account[1].equals(password)) {
            System.out.println("Wrong password");
            return null;
        }

        System.out.println("Login successful.");
        return account;
    }

    public void deposit(String username, String amount) {
        String[] account = userData.getAccountByUsername(username);
        if (account == null) { System.out.println("Account not found"); return; }
        double newBalance = Double.parseDouble(account[6]) + Double.parseDouble(amount);
        String newBalanceStr = newBalance + "";
        userData.updateBalance(username, newBalanceStr);
    }

    public boolean withdraw(String username, String amount) {
        String[] account = userData.getAccountByUsername(username);
        if (account == null) { System.out.println("Account not found"); return false; }
        double newBalance = Double.parseDouble(account[6]) - Double.parseDouble(amount);
        if  (newBalance < 0) {
            System.out.println("Insufficient balance");
            return false;
        }
        String newBalanceStr = newBalance + "";
        userData.updateBalance(username, newBalanceStr);
        return true;
    }

    public boolean transfer(String senderUsername, String receiverCardNo, String amount) {
        String[] receiver = userData.getAccountByCardNumber(receiverCardNo);
        if (receiver == null) { System.out.println("Receiver card invalid"); return false; }

        if (!withdraw(senderUsername, amount)) {
            System.out.println("Insufficient balance");
            return false;
        }

        String receiverName = receiver[0];
        deposit(receiverName, amount);
        return true;
    }

    public void showBalance(String username) {
        String[] account = userData.getAccountByUsername(username);
        if (account == null) { System.out.println("Account not found"); return; }
        System.out.println("Current balance: " + account[6]);
    }
}
