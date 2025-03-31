package bankManagementSystem.version_1_2;

public class Bank {
    private String name;
    private Accounts[] accounts;
    public static final int COPOSIY=5;
    private int startId=0;
    private double totalMoney;
    private MyList allAccounts;
    private MyList zeroAccounts;
    private MyList accountsByBalance;
    private MyList numberHigher;

    public Bank(String name) {
        this.name = name;
        accounts=new Accounts[COPOSIY];
        allAccounts=new MyList();
        zeroAccounts=new MyList();
        accountsByBalance=new MyList();
        numberHigher=new MyList();
    }

    public String getName(){
        return name;
    }

    public void transfer(int id ,int transferId,int date,double amount){
        if(close(id)||close(transferId)){
            System.err.println("This account closed");
        } else {
            if (id > startId || transferId > startId) {
                System.err.println("Error");
            }

            if (accounts[id - 1].getDeposite() < amount) {
                System.err.println("Error  transfer");
            }

            accounts[id - 1].setDate(date);
            accounts[transferId - 1].setDate(date);
            accounts[id - 1].setAmountWithdraw(amount);
            accounts[transferId - 1].setAmountDeposites(amount);
        }
    }
    public int createAccount(String ownerName,int date,double deposite){
        accounts[startId++]=new Accounts(startId,ownerName,date,deposite);
        allAccounts.add(accounts[startId-1]);
        setTotalMoney(deposite);
        return startId;
    }

    public Accounts getAccount(int id){
        if(close(id)){
            System.err.println("This account closed");
            System.err.println(STR."Closed date :\{accounts[id - 1].getDate()}");
        } else {
            if (id > startId) {
                System.err.println("Error id");
                return null;
            }
            return accounts[id - 1];
        }
        return null;
    }
    public void deposit(int id,int date,double amount){
        if(close(id)){
            System.err.print("This account closed");
        } else{
            if (id > startId) {
                System.err.print("Error id");
            }
            setTotalMoney(amount);
            accounts[id - 1].setDate(date);
            accounts[id - 1].setAmountDeposites(amount);
        }
    }

    public void withdraw(int id,int date,double amount){
        if(close(id)){
            System.err.print("This account closed");
        } else {
            if (id > startId) {
                System.err.print("Error id");
            }
            if (amount > accounts[id - 1].getDeposite()) {
                System.err.print("Error withdraw");
            }
            if (accounts[id - 1].getDate() > date) {
                date = accounts[id - 1].getDate();
            }
            accounts[id - 1].setDate(date);
            accounts[id - 1].setAmountWithdraw(amount);
        }

    }

    public Accounts deleteAccount(int id,int date){
        if(close(id)){
            System.err.println("This account closed");
        } else {
            if (id > startId) {
                System.err.println("Error delete");
            }
            accounts[id - 1].setDate(date);
            accounts[id - 1].setAmountWithdraw(accounts[id - 1].getDeposite());
            zeroAccounts.add(accounts[id - 1]);
        }
        return accounts[id-1];
    }
    public double getTotalDeposit(){
        return totalMoney;
    }

    public void setTotalMoney(double amount){
        this.totalMoney+=amount;
    }

    public boolean close(int id){
        if(accounts[id-1].getDeposite()==0){
            return true;
        }
        return false;
    }

    public MyList getAccounts(){
        return allAccounts;
    }
    public MyList getZeroAccounts(){
        return zeroAccounts;
    }
    public MyList getAccountsByBalance(double lower,double upper){
        for (int i = 0; i < startId; i++) {
            if(accounts[i].getDeposite()>lower&&accounts[i].getDeposite()<upper){
                accountsByBalance.add(accounts[i]);
            }
        }
        return accountsByBalance;
    }

    public MyList getNumberHigher(double amount){
        for (int i = 0; i <startId ; i++) {
            if(accounts[i].getDeposite()>=amount){
                numberHigher.add(accounts[i]);
            }
        }
        return numberHigher;
    }
}
