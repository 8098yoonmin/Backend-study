package Test;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class json {
    public static void main(String[] args) throws IOException {
        JSONObject object = new JSONObject();

        object.put("name", "xtar");
        object.put("주소", "it융합대학 2211");
        object.put("detail", new JSONObject());


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //파일을 만드는 stream (info.json파일)
        BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./info.json")));

        writer.write(object.toString(4));
        writer.flush();
        fileWriter.write(object.toString(4));
        fileWriter.flush();
    }
}
