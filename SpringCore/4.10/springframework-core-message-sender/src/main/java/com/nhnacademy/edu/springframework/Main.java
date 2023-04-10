package com.nhnacademy.edu.springframework;

public class Main {

    public static void main(String[] args) {
        User user = new User("ksw08130@naver.com", "01085166226");

        Main main = new Main();
        main.sendEmailMessage(user, "hello");
        main.sendSmsMessage(user, "hello");
    }

    private void sendSmsMessage(User user, String message) {
        System.out.println("SMS Message Sent to "+ user.getPhoneNumber() + ":" + message  );
    }

    private void sendEmailMessage(User user, String message) {
        System.out.println("Email Message Sent " + user.getEmail() + ":"  + message );
    }
}
