import java.math.BigDecimal;

class Test {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Jason", new BigDecimal(100));
        account.printAccount();
        BankAccount account2 = new BankAccount("James", new BigDecimal(1000));
        account2.printAccount();
        BankAccount account5 = new BankAccount("Kim", new BigDecimal(400));
        account5.printAccount();
        LimitedBankAccount account3 = new LimitedBankAccount("yoom",new BigDecimal(1000), new BigDecimal(10000));
        account3.printAccount();
        LimitedBankAccount account4 = new LimitedBankAccount("min",new BigDecimal(1000), new BigDecimal(10000));
        account4.printAccount();
        LimitedBankAccount account6 = new LimitedBankAccount("min",new BigDecimal(1000), new BigDecimal(10000));
        account6.printAccount();


        BankAccount account7 = new BankAccount("Kim", new BigDecimal(400));
        account7.printAccount();
    }
}
