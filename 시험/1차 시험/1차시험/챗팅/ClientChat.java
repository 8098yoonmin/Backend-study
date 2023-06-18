import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

	Socket cSocket;
	BufferedReader br;
	PrintWriter out;
	Scanner scv;

	public ClientChat() { 
		System.out.println("서버에 접속하는 중입니다.");
		try {
			InetAddress localAddress = InetAddress.getLocalHost();

			cSocket = new Socket(localAddress, 10000);
			SocketThread st = new SocketThread(); 
			st.start(); 
			out = new PrintWriter(cSocket.getOutputStream(), true);
			scv = new Scanner(System.in);

			String UserID = "";
			System.out.println("#서버에 연결됨!");
			System.out.println("#사용할 ID를 입력해주세요.");
			out.print(UserID);

			while (true) {
				String inputLine = scv.nextLine(); 
				out.println(inputLine); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class SocketThread extends Thread { 
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(cSocket.getInputStream())); 
				String response = null; 
				while ((response = br.readLine()) != null) { 
					System.out.println(response); 
				}
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		new ClientChat(); 
	}
}
