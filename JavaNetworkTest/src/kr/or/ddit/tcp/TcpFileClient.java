package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;


public class TcpFileClient {
	
	private Socket socket;
	private FileOutputStream fos;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	public void startClient() {
		
		File file = new File("d:/D_Other/bara2.jpg"); // 저장할 파일 설정
		
		try {
			socket = new Socket("localhost", 7777);
			
			// 소켓접속이 성공하면 받고싶은 파일명을 보낸다.
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(file.getName());
			
			dis = new DataInputStream(socket.getInputStream());
			
			String resultMsg = dis.readUTF();
			
			if(resultMsg.equals("OK")) {
				
				fos = new FileOutputStream(file);
				
				BufferedInputStream bis = 
						new BufferedInputStream(socket.getInputStream());
				BufferedOutputStream bos =
						new BufferedOutputStream(fos);
				
				int data = 0;
				while((data = bis.read()) != -1) {
					bos.write(data);
				}
				
				bis.close();
				bos.close();
				
				System.out.println("파일 다운로드 완료...");
			}else {
				System.out.println(resultMsg);
			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpFileClient().startClient();
	}
	
}
