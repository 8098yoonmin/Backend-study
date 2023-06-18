import java.math.BigDecimal;

class Test {
    //클라이언트 코드는 수정하지 않고 리팩토링하기 
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Jason", new BigDecimal(100));
        PrintAccount.printAccount(account);
        BankAccount account2 = new BankAccount("James", new BigDecimal(1000));
        PrintAccount.printAccount(account2);
    }
}
