package bankManagementSystem.version_1_2;

public abstract  class Operations {
    double amount;
    double date;

    public Operations(double amount, double date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public abstract  String toString();
}
