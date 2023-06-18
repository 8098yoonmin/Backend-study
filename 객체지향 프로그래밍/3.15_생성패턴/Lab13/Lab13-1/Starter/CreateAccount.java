public class CreateAccount {

    private static CreateAccount createAccount;

    private static String nextAccountNumber = "0";

    private CreateAccount() {}

    public CreateAccount getCreateAccount() {
        if(createAccount == null) {
            createAccount = new CreateAccount();
        }
        return createAccount;
    }

    public static String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return "0000-" + nextAccountNumber;
    }
}


class CreateLimited {
    private static CreateLimited createLimited;

    private static String nextAccountNumber = "0";

    private CreateLimited() {}

    public CreateLimited getCreateLimited() {
        if(createLimited == null) {
            createLimited = new CreateLimited();
        }
        return createLimited;
    }

    public static String createLimitedNumber() {
        int accountNum = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNum);
        return "0001-" + nextAccountNumber;
    }
}
