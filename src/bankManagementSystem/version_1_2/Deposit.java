package bankManagementSystem.version_1_2;

public class Deposit extends  Operations {
    public Deposit(double amount,int date){
        super(amount,date);
    }


    @Override
    public String toString() {
        return STR."Deposit{date=\{date}, amount=\{amount}}";
    }
}
