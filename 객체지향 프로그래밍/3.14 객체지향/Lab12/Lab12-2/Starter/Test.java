import java.math.BigDecimal;

class Test {
    public static void main(String[] args) {
        //PrintAccount printAccount = new PrintAccount();

        BankAccount account = new BankAccount("Jason", new BigDecimal(100));
        PrintAccount.printAccount(account);
        BankAccount account2 = new LimitedBankAccount("James", new BigDecimal(2000), new BigDecimal(10000));
        PrintAccount.printAccount(account2);
        BankAccount account3 = new SavingAccount("yoom", new BigDecimal(1000));
        PrintAccount.printAccount(account3);
    }
}
