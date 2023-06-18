public class PrintAccount implements IPrint{

    public void printAccount(IAccount printAccount) {
        // BankAccount account = (BankAccount)printAccount;
        System.out.println("Account Number: " + printAccount.getAccountNo());
        System.out.println("Owner Name: " + printAccount.getAccountOwner());
        System.out.println("Balance: " + printAccount.getBalance());
    }
}
