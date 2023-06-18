import java.math.BigDecimal;

public class LimitedBankAccount extends BankAccount{
    private BigDecimal balanceLimited;

    public LimitedBankAccount(String ownerName, BigDecimal balance, BigDecimal balanceLimit) {
        super(ownerName, balance);
        this.balanceLimited = balanceLimit;
    }

    @Override
    public BigDecimal deposit(BigDecimal amount) {
        if (this.balance.add(amount).compareTo(this.balanceLimited) == 1) {
            System.out.println("balance limit exceeded");
            return this.balance;
        } else {
            return this.balance.add(amount);
        }
    }

    public BigDecimal getBalanceLimit() {
        return this.balanceLimited;
    }
    
    
}
