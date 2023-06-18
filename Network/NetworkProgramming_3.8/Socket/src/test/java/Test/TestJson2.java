package Test;

import org.json.JSONObject;

import java.io.*;

public class TestJson2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./info.json")));
        String line;
        StringBuilder info = new StringBuilder();
        while((line = reader.readLine()) != null) {
            info.append(line);
            info.append('\n'); //안쓰면 한줄로 나옴

        }

        System.out.println(info.toString());

        JSONObject object = new JSONObject(info.toString());
        System.out.println(object.toString(4));

        //원하는 자료 뽑아오기
        Object field = object.get("주소");
        System.out.println(field.toString());
        System.out.println(field.getClass().getName());

        Object field2 = object.get("나이");
        System.out.println(field2.getClass().getName());



    }
}
