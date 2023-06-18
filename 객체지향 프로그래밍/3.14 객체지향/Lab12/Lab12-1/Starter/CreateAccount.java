public class CreateAccount{
    private static String nextAccountNumber = "0";

    static String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return "0000-" + nextAccountNumber;
    }

}