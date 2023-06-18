import java.math.BigDecimal;

public class LimitedBankAccount extends BankAccount {
    private BigDecimal balanceLimit;
    private String accountNumber;

    public LimitedBankAccount(String ownerName, BigDecimal balance, BigDecimal balanceLimit) {
        super(ownerName, balance);
        this.accountNumber = createAccountNumber();
        this.balanceLimit = balanceLimit;
    }

    private static String nextAccountNum = "0";

    public BigDecimal deposit(BigDecimal amount) {
        if (this.balance.add(amount).compareTo(this.balanceLimit) == 1) {
            System.out.println("balance limit exceeded");
            return this.balance;
        }
        else {
            return this.balance = this.balance.add(amount);
        }
    }

    public BigDecimal getBalanceLimit() {
            return this.balanceLimit;
    }

    private static String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNum);
        nextAccountNum = Integer.toString(++accountNumber);
        return "0001-" + nextAccountNum;
    }
    
    public void printAccount() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("Balance: " + this.balance.toString());
    }
}
