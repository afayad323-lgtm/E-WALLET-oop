import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();

        users.add(new User("Ahmed"));
        users.add(new User("Ali"));

        while (true) {

            System.out.println("\n====== E-WALLET ======");
            System.out.println("1- Deposit");
            System.out.println("2- Withdraw");
            System.out.println("3- Show Balance");
            System.out.println("4- Show all users");
            System.out.println("5- Transfer");
            System.out.println("6- Show Transactions");
            System.out.println("7- Exit");

            System.out.print("Choice: ");
            int choice = reader.nextInt();

            switch (choice) {

                case 1: {
                    User user = findUser(users, reader);
                    if (user != null) {
                        System.out.print("Enter your amount: ");
                        double dep = reader.nextDouble();
                        user.deposit(dep);
                    }
                    break;
                }

                case 2: {
                    User user = findUser(users, reader);
                    if (user != null) {
                        System.out.print("Enter your amount: ");
                        double wd = reader.nextDouble();
                        user.withdraw(wd);
                    }
                    break;
                }

                case 3: {
                    User user = findUser(users, reader);
                    if (user != null) {
                        user.showBalance();
                    }
                    break;
                }

                case 4: {
                    for (User u : users) {
                        u.showBalance();
                        System.out.println("--------------");
                    }
                    break;
                }
                case 5:
                {
                    System.out.print("Sender: ");
                    User sender = findUser(users , reader);
                    System.out.print("Receiver: ");
                    User receiver = findUser(users , reader);
                    if (sender != null && receiver != null){
                        System.out.print("Amount: ");
                        double amount = reader.nextDouble();
                        sender.transfer(receiver , amount);
                    }
                    break;
                }
                case 6:
                {
                    User user = findUser(users , reader);
                    if (user != null){
                        user.showTransactions();
                    }
                    break;
                }
                case 7:
                    System.out.println("GOODBYE");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static User findUser(ArrayList<User> users, Scanner reader) {

        System.out.print("Enter your name: ");
        String name = reader.next();

        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }

        System.out.println("User not found");
        return null;
    }
}