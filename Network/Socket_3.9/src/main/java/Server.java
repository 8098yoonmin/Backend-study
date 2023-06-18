import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(10005)) {

            //연결이 여러개인 경우 하나의 연결이 끝나면 다음 연결을 받도록 함
            while (!Thread.interrupted()) {
                System.out.println("연결을 기다립니다.");
                Handler handler = new Handler(serverSocket.accept()).start();
                System.out.println("연결 되었습니다.");
                handler.start();
                handler.join();
                System.out.println("연결을 끊었습니다.");
            }
        } catch (IOException ignore) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}