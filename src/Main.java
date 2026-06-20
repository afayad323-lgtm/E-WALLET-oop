import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();

        users.add(new User("Ahmed"));
        users.add(new User("Ali"));
        users.add(new User("Eman"));
        users.add(new User("Malika"));
        users.add(new User("Mostafa"));

        WalletService service = new WalletService();

        while (true) {

            System.out.println("\n====== E-WALLET ======");
            System.out.println("1- Deposit");
            System.out.println("2- Withdraw");
            System.out.println("3- Show Balance");
            System.out.println("4- Show all users");
            System.out.println("5- Balance more than zero");
            System.out.println("6- Transfer");
            System.out.println("7- Show Transactions");
            System.out.println("8- Total balance for all users");
            System.out.println("9- Show Richest");
            System.out.println("10- Exit");

            System.out.print("Choice: ");
            int choice = reader.nextInt();

            switch (choice) {

                case 1: {
                    System.out.println("Enter Your name: ");
                    String name = reader.next();
                    User user = service.findUser(users , name);
                    if (user != null) {
                        System.out.print("Enter your amount: ");
                        double dep = reader.nextDouble();
                        user.deposit(dep);
                    }
                    break;
                }

                case 2: {
                    System.out.println("Enter Your name: ");
                    String name = reader.next();
                    User user = service.findUser(users , name);
                    if (user != null) {
                        System.out.print("Enter your amount: ");
                        double wd = reader.nextDouble();
                        user.withdraw(wd);
                    }
                    break;
                }

                case 3: {
                    System.out.println("Enter Your name: ");
                    String name = reader.next();
                    User user = service.findUser(users , name);
                    if (user != null) {
                        user.showBalance();
                    }
                    break;
                }

                case 4: {
                   users.forEach(User::showBalance);
                   System.out.println("----------------");
                    break;
                }
                case 5: {
                    users.stream()
                            .filter(u -> u.getBalance() > 0)
                            .forEach(User::showBalance);
                    break;
                }
                case 6:
                {
                    System.out.print("Sender: ");
                    String senderName = reader.next();
                     User sender = service.findUser(users , senderName);
                    System.out.print("Receiver: ");
                    String receiverName = reader.next();
                    User receiver = service.findUser(users , receiverName);
                    if (sender != null && receiver != null){
                        System.out.print("Amount: ");
                        double amount = reader.nextDouble();
                        sender.transfer(receiver , amount);
                    }
                    break;
                }
                case 7:
                {
                    System.out.println("Enter Your Name: ");
                    String name = reader.next();
                    User user = service.findUser(users , name);
                    if (user != null){
                        user.showTransactions();
                    }
                    break;
                }
                case 8: {
                   double total = users.stream()
                            .mapToDouble(User::getBalance)
                            .sum();
                    System.out.println("total balance is: "+ total);
                    break;
                }
                case 9: {
                    User richest = users.stream()
                            .max((u1 , u2) -> Double.compare(u1.getBalance(), u2.getBalance()))
                            .orElse(null);
                    if (richest != null){
                        System.out.println("Richest user is: ");
                        richest.showBalance();
                    }
                    break;
                }
                case 10:
                    System.out.println("GOODBYE");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}