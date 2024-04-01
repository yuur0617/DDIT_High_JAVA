package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	
	// 클라이언트 시작...
	public void startClient() {
		
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.141.27", 8888);
			
			System.out.println("멀티챗 서버에 연결되었습니다.");
			
			// 송신용 스레드 생성 및 실행
			ClientSender sender = new ClientSender(socket);
			sender.start();
			
			// 수신용 스레드 생성 및 실행
			ClientReceiver receiver = new ClientReceiver(socket);
			receiver.start();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	// 메시지 전송을  처리하는 스레드
	class ClientSender extends Thread {
		private DataOutputStream dos;
		private Scanner scan;
		
		public ClientSender(Socket socket) {
			
			scan = new Scanner(System.in);
			
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				if(dos != null) {
					// 시작하자 마자 자신의 대화명을 서버로 전송한다.
					System.out.print("대화명 >>> ");
					dos.writeUTF(scan.nextLine());
				}
				
				while(dos != null) {
					// 키보드로 입력받은 메시지를 서버로 전송한다.
					dos.writeUTF(scan.nextLine());
				}
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	// 메시지 수신을 처리하는 스레드
	class ClientReceiver extends Thread {
		private DataInputStream dis;
		
		public ClientReceiver(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(dis != null) {
				try {
					// 서버로부터 받은 메시지를 콘솔에 출력한다.
					System.out.println(dis.readUTF());
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new MultiChatClient().startClient();
	}
	
}
