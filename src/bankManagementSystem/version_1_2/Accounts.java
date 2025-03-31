package bankManagementSystem.version_1_2;

public class Accounts {
    private int accountNumber;
    private String ownerName;
    private int date;
    private double deposite;
    private MyList deposits;
    private MyList withdrawals;
    private MyList operations;


    public Accounts(int accountNumber, String ownerName, int date, double deposite) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.date = date;
        this.deposite = deposite;
        this.deposits=new MyList();
        this.withdrawals=new MyList();
        operations.add(new Deposit(deposite,date));
        deposits.add(new Deposit(deposite,date));

    }

    public int getDate(){
        return date;
    }

     public void setDate(int date){
        if(this.date<date){
            this.date=date;
        }
     }

    public double getDeposite() {
        return deposite;
    }

    public MyList getDeposits() {
        return deposits;
    }

    public MyList getWithdrawals() {
        return withdrawals;
    }
    public MyList getMovements(){
        return operations;
    }

    public void setAmountDeposites(double amount){
        operations.add(new Deposit(amount,this.date));
        deposits.add(new Deposit(amount,this.date));
        this.deposite+=amount;
    }

    public void setAmountWithdraw(double amount){
        operations.add(new Withdrawal(amount,this.date));
        withdrawals.add(new Withdrawal(amount,this.date));
        this.deposite-=amount;
    }



}
