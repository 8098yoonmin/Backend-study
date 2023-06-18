import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex2 {

    public static class Handler extends Thread {
        Socket socket;

        //이게 지금 클라이언트 역할을 하는 것 같은데..?
        public Handler(Socket socket) {
            super("Handler");
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

                while(!Thread.interrupted()) {
                    String line = input.readLine();
                    if(line.equals("끝")) {
                        break;
                    }
                    output.write(line);
                    output.newLine();
                    output.flush();
                    log.write(line);
                    log.newLine();
                    log.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(10001)){

            //연결이 여러개인 경우 하나의 연결이 끝나면 다음 연결을 받도록 함
            while(!Thread.interrupted()) {
                System.out.println("연결을 기다립니다.");
                Handler handler = new Handler(serverSocket.accept());
                System.out.println("연결 되었습니다.");
                handler.start();
                handler.join();
                System.out.println("연결을 끊었습니다.");
            }
        } catch(IOException ignore) {

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
