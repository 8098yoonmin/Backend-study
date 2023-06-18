import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.64.2", 1234)) {

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter terminal = new BufferedWriter(new OutputStreamWriter(System.out));

            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread inputThread = new Thread(() -> {
                try {
                    while(!Thread.interrupted()) {
                        terminal.write(input.readLine()); //받은 걸 화면에 찍음
                        terminal.newLine();
                        terminal.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });

            inputThread.start();

            while(!Thread.interrupted()) {
                String line = console.readLine();
                output.write(line);
                output.newLine();
                output.flush();
            }

        } catch (IOException e) {
            System.err.println(e);
            System.err.println("연결에 실패했습니다.");
        }
    }

}
