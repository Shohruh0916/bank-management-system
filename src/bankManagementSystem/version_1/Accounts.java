package bankManagementSystem.version_1;

public class Accounts {
    private int accountNumber;
    private String ownerName;
    private int date;


    @Override
    public String toString() {
        return "Accounts{" +
                "accountNumber=" + accountNumber +
                ", ownerName='" + ownerName + '\'' +
                ", date=" + date +
                '}';
    }
}
