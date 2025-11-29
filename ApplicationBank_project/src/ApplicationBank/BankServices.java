package ApplicationBank;

public class BankServices {
    private UserData userData;

    public BankServices(UserData userData) {
        this.userData = userData;
    }

    public String[] login(String username, String password) {
        if (userData.findByUsername(username) == -1) {
            System.out.println("Username not found");
            return null;
        }

        int idx = userData.findByUsername(username);
        String[] account = userData.getAccount(idx);
        if (!account[1].equals(password)) {
            System.out.println("Wrong password");
            return null;
        }

        System.out.println("Login successful.");
        return account;
    }

    public void deposit(String username, String amount) {
        int idx = userData.findByUsername(username);
        String[] account = userData.getAccount(idx);
        double newBalance = Double.parseDouble(account[6]) + Double.parseDouble(amount);
        String newBalanceStr = newBalance + "";
        userData.updateBalance(idx, newBalanceStr);
    }

    public boolean withdraw(String username, String amount) {
        int idx = userData.findByUsername(username);
        String[] account = userData.getAccount(idx);
        double newBalance = Double.parseDouble(account[6]) - Double.parseDouble(amount);
        if  (newBalance < 0) {
            System.out.println("Insufficient balance");
            return false;
        }
        String newBalanceStr = newBalance + "";
        userData.updateBalance(idx, newBalanceStr);
        return true;
    }

    public boolean transfer(String senderUsername, String receiverCardNo, String amount) {
        int idxReceiver = userData.findByCardNumber(receiverCardNo);
        if (!withdraw(senderUsername, amount)) {
            System.out.println("Insufficient balance");
            return false;
        }
        String[] receiver = userData.getAccount(idxReceiver);
        String receiverName = receiver[0];
        deposit(receiverName, amount);
        return true;
    }

    public void showBalance(String username) {
        int idx = userData.findByUsername(username);
        String[] account = userData.getAccount(idx);
        System.out.println("Current balance: " + account[6]);
    }
}
