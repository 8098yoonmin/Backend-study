import java.math.BigDecimal;

public class BankAccount implements IAccount {
    protected String accountNumber;
    protected String ownerName;
    protected BigDecimal balance;

    public BankAccount(String ownerName, BigDecimal balance) {
        this.accountNumber = CreateAccount.createAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public boolean withDraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) == 1 || amount.compareTo(this.balance) == 0) {
            return false;
        } else {
            balance = balance.subtract(amount);
            return true;
        }
    }

    @Override
    public String getAccountNo() {
        return this.accountNumber;
    }
    @Override
    public String getAccountOwner(){
        return this.ownerName;
    };
    @Override
    public BigDecimal getBalance(){
        return this.balance;
    }

    public void printAccount() {
    };
}
