import java.math.BigDecimal;

public class SavingAccount extends BankAccount{

    public SavingAccount(String ownerName, BigDecimal balance) {
        super(ownerName, balance);
    }

    @Override
    public boolean withDraw(BigDecimal amount) {
        System.out.println("출금이 불가능 합니다.");
        return false;
    }


    
}
