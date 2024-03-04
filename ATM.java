import java.util.HashMap;
import java.util.Map;
public class ATM {
	private Map<String, User> users;

    public ATM() {
        users = new HashMap<>();
        // Initialize some dummy users
        users.put("123456", new User("123456", "1234", 1000.0));
        users.put("789012", new User("789012", "5678", 500.0));
        // Add more users as needed
    }

    public boolean authenticateUser(String userID, String userPIN) {
        if (users.containsKey(userID)) {
            User user = users.get(userID);
            return user.getUserPIN().equals(userPIN);
        }
        return false;
    }

    public double checkBalance(String userID) {
        if (users.containsKey(userID)) {
            return users.get(userID).getAccountBalance();
        }
        return -1; // User not found
    }

    public boolean withdraw(String userID, double amount) {
        if (users.containsKey(userID)) {
            User user = users.get(userID);
            if (user.getAccountBalance() >= amount) {
                user.setAccountBalance(user.getAccountBalance() - amount);
                return true; // Withdrawal successful
            } else {
                return false; // Insufficient funds
            }
        }
        return false; // User not found
    }

    public void deposit(String userID, double amount) {
        if (users.containsKey(userID)) {
            User user = users.get(userID);
            user.setAccountBalance(user.getAccountBalance() + amount);
        }
    }
}
