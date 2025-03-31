package bankManagementSystem.version_1_2;

public class Test {
    public static void main(String[] args) {
        Bank b1 = new Bank("Uncle-$crooge");
        int c1 = b1.createAccount("John", 5, 500.5);
        int c2 = b1.createAccount("Mary", 10,  1000.);
        int c3 = b1.createAccount("John", 20,  800.);
        int c4 = b1.createAccount("Paul", 30, 252.4);
        Accounts a1, a3;

        b1.deposit(c1, 7, 360.0);
        b1.deposit(c4, 35, 270.0);
        b1.withdraw(c3, 28, 350.0);
        b1.withdraw(c2, 19, 350.0);
        b1.withdraw(c3, 41, 158.0);
        b1.transfer(c1, c3, 8, 400.0);
        a1 = b1.getAccount(c1);
        a3 = b1.deleteAccount(c3,50);
        MyList accounts = b1.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            Accounts a = (Accounts) accounts.get(i);
            System.out.println(STR."account: \{a}");
            System.out.println(" movements:");

            MyList movements = a.getMovements();

            for (int j = 0; j < movements.size(); j++) {
                Operations o = (Operations) movements.get(j);
                System.out.println(o);
            }
            System.out.println();
        }

        System.out.println(STR."deleted account: \{a3}");
        System.out.println(" movements:");
        MyList movements = a3.getMovements();
        for (int i = 0; i < movements.size(); i++) {
            Operations o = (Operations) movements.get(i);
            System.out.println(o);
        }
        System.out.println();

        System.out.println(STR."account: \{a1}");
        System.out.println(" movements:");

        movements = a1.getMovements();
        for (int i = 0; i < movements.size(); i++) {
            Operations o = (Operations) movements.get(i);
            System.out.println(o);
        }

        System.out.println(" deposits:");

        MyList deposits = a1.getDeposits();
        for (int i = 0; i < deposits.size(); i++) {
            Deposit d = (Deposit) deposits.get(i);
            System.out.println(d);
        }

        System.out.println(" withdrawals:");

        MyList withdrawals = a1.getWithdrawals();
        for (int i = 0; i < withdrawals.size(); i++) {
            Withdrawal w = (Withdrawal) withdrawals.get(i);
            System.out.println(w);
        }
        System.out.println();


        System.out.println(STR."total deposit in the \{b1.getName()} bank: \{b1.getTotalDeposit()}");
        System.out.println();


        System.out.println("accounts with balance higher than 500: " );
        MyList numberHigher=b1.getNumberHigher(500);
        for (int i = 0; i < numberHigher.size(); i++) {
            Accounts a = (Accounts) numberHigher.get(i);
            System.out.println(a);
        }
        System.out.println();


        System.out.println("accounts with balance in range 500..700 :");
        MyList accountsByBalance = b1.getAccountsByBalance(500, 700);
        for (int i = 0; i < accountsByBalance.size(); i++) {
            Accounts a = (Accounts) accountsByBalance.get(i);
            System.out.println(a);
        }
        System.out.println();
    }
}
