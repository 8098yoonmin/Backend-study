import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Handler extends Thread {
    Socket socket;
    static ArrayList<Socket> handlers = new ArrayList<Socket>();

    public Handler(Socket socket) {
        super("Handler");
        this.socket = socket;
    }

//    public void addSocket(Socket socket) {
//        socketList.add(socket);
//    }

    //id지정
//    public void directMessage() { }


    //시작
    public void start() {

    }

    //전체 클라이언트에 뿌리기
    public void broadcast() {
        for( handler : handlers ) {
            output.write(line);
            output

        }
    }



    @Override
    public void run() {

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter writer = new PrintWriter(output, true);

            while(!Thread.interrupted()) {
                String line = input.readLine();
                output.write(line);
                output.newLine();
                output.flush();

            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

//    public void broadcast()

}
