import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your user ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String userPIN = scanner.nextLine();

        if (atm.authenticateUser(userID, userPIN)) {
            System.out.println("Authentication successful.");
            try {
				System.out.println("\n Type 1 - checkBalance");
				System.out.println(" Type 2 - withdraw");
				System.out.println(" Type 3 - deposit");
				System.out.print("\nChoice: ");
				int choice=scanner.nextInt();
				switch (choice) {
				case 1:
					atm.checkBalance(String.valueOf(userID));
					break;
				case 2:
					System.out.println("Enter Amount: ");
					double amount=scanner.nextDouble();
					atm.withdraw(String.valueOf(userID),amount);
					break;
				case 3:
					System.out.println("Enter Amount:");
					double amountToDeposit=scanner.nextDouble();
					atm.deposit(String.valueOf(userID),amountToDeposit);
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				scanner.next();
			}
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
}
