package Test;

import org.json.JSONObject;

public class TestJson3 {
    public static class Info {
        String address;
        int age;
        boolean male;

        public Info() {
            address = "IT 2211";
            age = 20;
            male = true;
        }
        public String getAddress() {
            return address;
        }

        public int getAge() {
            return age;
        }

        public boolean isMale() {
            return male;
        }
    }
    public static void main(String[] args) {
        Info info = new Info();
        JSONObject object = new JSONObject(info);

        System.out.println(object.toString(4));
    }
}
