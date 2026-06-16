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
        }
    }

    public void withdraw (double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Done, your balance is: " + balance);
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
}
