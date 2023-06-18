public class PrintAccount {
// single responsibilityy ~~ 하려면 계층구조에서 떼어 내야 됨 
// 위임을 이용해서 해결하지 상속은 별로 좋은 아이디어가 아니다고 함. 

    public static void printAccount(BankAccount account) {
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Owner Name: " + account.ownerName);
        System.out.println("Balance: " + account.balance.toString());
    }
}
