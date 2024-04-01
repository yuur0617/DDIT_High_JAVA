package kr.or.ddit.udp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpFileReceiver {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private byte[] buffer;
	
	public UdpFileReceiver(int port) {
		try {
			
			ds = new DatagramSocket(port); // 데이터 수신을 위한 포트번호 설정
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void start() throws IOException {
		
		long fileSize = 0;
		long totalReadBytes = 0;
		
		int readBytes = 0;
		
		System.out.println("파일 수신 대기중..");
		
		String str = new String(receiverData()).trim();
		
		if(str.equals("start")) {
			// 전송 파일명 받기
			str = new String(receiverData()).trim();
			
			FileOutputStream fos = new FileOutputStream(
							"d:/D_Other/" +  str);
		
			// 전송 파일 그키(bytes) 받기
			str = new String(receiverData()).trim();
			fileSize = Long.parseLong(str);
			
			long startTime = System.currentTimeMillis();
			
			while(true) {
				byte[] data = receiverData();
				readBytes = dp.getLength(); // 받은 바이트 배열 크기
				
				fos.write(data, 0, readBytes); // 파일 저장
				
				totalReadBytes += readBytes;
				
				System.out.println("진행 상태  : " + totalReadBytes + "/" + fileSize 
						+ " Byte(s) (" + (totalReadBytes * 100 / fileSize) + " %)");
				
				if(totalReadBytes >= fileSize) {
					break;
				}
			}
			
			long endTime = System.currentTimeMillis();
			long diffTime = endTime = startTime;
			double transferSpeed = fileSize / diffTime;
			
			System.out.println("걸린시간 : " + diffTime + " (ms)");
			System.out.println("평균 전송 속도 : " +transferSpeed + " Bytes/ms");
			
			System.out.println("전송 완료 ...");
		}
	}
	
	/**
	 * 데이터 수신하기
	 * @return 수신한 바이트 배열 데이터
	 */
	public byte[] receiverData() throws IOException{
		buffer = new byte[1000];
		dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);
		
		return dp.getData();
	}
	
	public static void main(String[] args) throws Exception {
		
		new UdpFileReceiver(8888).start();
	}
}
