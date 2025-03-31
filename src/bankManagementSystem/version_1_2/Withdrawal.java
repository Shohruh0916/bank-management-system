package bankManagementSystem.version_1_2;

public class Withdrawal extends Operations{
    public Withdrawal(double amount, double date){
        super(amount,date);
    }

    @Override
    public String toString() {
        return STR."withdrawal{date=\{date}, amount=\{amount}}";
    }
}
