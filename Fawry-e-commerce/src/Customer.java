public class Customer {
    protected String name;
    protected double balance;


    public Customer(String name, double balance){
        this.name = name;
        this.balance = balance;

    }
    public double getBalance(){
        return this.balance;
    }

    public boolean balanceiswithin(double amount){
        return balance >= amount;
    }

    public void reduceBalance(double amount){
        balance -= amount;
    }

    
}
