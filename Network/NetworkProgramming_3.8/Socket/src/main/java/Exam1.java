import java.io.*;
import java.net.Socket;

public class Exam1 {
    public static void main(String[] args) {
        //클라이언트 소켓
        try (Socket socket = new Socket("192.168.64.2", 1234)) {

            //bufferedreader : scanner과 유사(문자열을 처리할 수 있음) Inputstreamreader은 2byte도 처리 가능 == 한글 처리 가능
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            //bufferedwriter : system.out.println과 유사
            BufferedWriter terminal = new BufferedWriter(new OutputStreamWriter(System.out));

            //socket쪽으로
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Thread가 runnable인터페이스를 이용해 구현
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
