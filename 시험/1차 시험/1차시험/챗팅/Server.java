import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
	private static Socket clientSocket;
	static PrintWriter out = null;
	static ArrayList<Socket> list = new ArrayList<Socket>(); 
	static int UserNum = 0; 

	public Server(Socket clientSocket) {
		this.clientSocket = clientSocket;
		list.add(clientSocket); 
	}

	public static void main(String[] args) {

		System.out.println("#서버 시작");

		try (ServerSocket serverSocket = new ServerSocket(10000)) 
        {
			while (true) { 
				System.out.println("#연결 대기 중 ......");
				clientSocket = serverSocket.accept();
				Server tes = new Server(clientSocket);
				
				new Thread(tes).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("#서버 종료");
	}

	public void run() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			OutputStream out = clientSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);

			UserNum++;
			System.out.println("#클라이언트 : " + UserNum + "(" + Thread.currentThread() + ")" + " 연결됨!");

			String UserID = br.readLine(); 
			String inputLine; 

			writer.println("#[" + UserID + "]님이 접속하셨습니다.");
			System.out.println("#[" + UserID + "]님이 접속하셨습니다.");

			while ((inputLine = br.readLine()) != null) {
				
                if(inputLine.startsWith("@all")){
                    for (int i = 0; i < list.size(); i++) {
                        out = list.get(i).getOutputStream();
                        writer = new PrintWriter(out, true);
                        writer.println("[" + UserID + "] " + inputLine);
                        }
                }
                else {
                    for (int i = 0; i < list.size(); i++) {
                        out = list.get(i).getOutputStream();
                        writer = new PrintWriter(out, true);
                        writer.println("[" + UserID + "] " + inputLine);
                        }
                }

			}
			out.close();
			System.out.println("#클라이언트 : " + Thread.currentThread() + " 종료됨!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}

