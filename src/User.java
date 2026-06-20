import java.util.ArrayList;

public class User {
    private String name;
    private double balance;

    public User(){}

    public User (String name){
        this.name = name;
        this.balance = 0;
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            System.out.println("Done, your balance is: " + balance);
            transactions.add(new Transaction("Deposit: ", amount));
        }

    }

    public void withdraw (double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Done, your balance is: " + balance);
            transactions.add(new Transaction("Withdraw: " ,amount ));
        }else {
            System.out.println("InSufficient balance, your balance is: " + balance);
        }

    }

    public void showBalance(){
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    public String getName() {
        return name;
    }

    public boolean transfer(User receiver , double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            receiver.balance += amount;
            System.out.println("Transfer Completed");
            transactions.add(new Transaction("Transfer: " , amount));
            receiver.transactions.add(new Transaction("Recieved Transfer: " , amount));
            return true;
        }
        System.out.println("Transfer Failed, amount must be more than 0 or less than your balancs");
        return false;
    }

    private ArrayList<Transaction> transactions =
            new ArrayList<>();

    public void showTransactions(){
        if (transactions.isEmpty()){
            System.out.println("No transactions found");
            return;
        }

        for (Transaction t : transactions){
            System.out.println(t);
        }
    }

    public  double getBalance(){
        return balance;
    }
}
