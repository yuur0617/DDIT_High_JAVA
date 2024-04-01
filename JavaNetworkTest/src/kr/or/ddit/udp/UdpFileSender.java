package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpFileSender {
	
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private InetAddress receiverAddr;
	private int port;
	private File file;
	
	public UdpFileSender(String receiverIp, int port) {
		try {
			
			ds = new DatagramSocket();
			this.port = port;
			receiverAddr = InetAddress.getByName(receiverIp);
			file = new File("D:\\A_TeachingMaterial\\web\\vsYurim\\images\\ogu.jpg");
			
			if(!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				System.exit(0);
			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void start() throws Exception{
		
		long fileSize = file.length();
		long totalReadBytes = 0;
		
		long startTime = System.currentTimeMillis();
		
		sendData("start".getBytes()); // 전송 시작을 알려주기 위한 문자열 전송
		
		sendData(file.getName().getBytes()); // 파일명을 전송
		
		sendData(String.valueOf(fileSize).getBytes()); // 총 파일크기 전송
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1000];
		
		while(true) {
			Thread.sleep(10); // 패킷 전송간의 간격을 주기위한 코드
			
			int readBytes = fis.read(buffer, 0, buffer.length);
			
			if(readBytes == -1) { // 파일을 다 읽은 경우
				break;
			}
			
			sendData(buffer, readBytes); // 읽어온 파일 내용 전송하기
			
			totalReadBytes += readBytes;
			
			System.out.println("진행 상태  : " + totalReadBytes + "/" + fileSize 
						+ " Byte(s) (" + (totalReadBytes * 100 / fileSize) + " %)");
		}
		
		long endTime = System.currentTimeMillis();
		long diffTime = endTime = startTime;
		double transferSpeed = fileSize / diffTime;
		
		System.out.println("걸린시간 : " + diffTime + " (ms)");
		System.out.println("평균 전송 속도 : " +transferSpeed + " Bytes/ms");
		
		System.out.println("전송 완료 ...");
	}
	
	/**
	 * 바이트 배열 데이터 전송하기
	 * @param data 전송할 바이트 배열
	 */
	public void sendData(byte[] data) {
		sendData(data, data.length);
	}

	/**
	 * 바이트 배열 데이터 전송하기
	 * @param data 전송할 바이트 배열
	 * @param length 전송할 바이트 배열 크기
	 */
	private void sendData(byte[] data, int length) {
		
		try {
			
			dp = new DatagramPacket(data, length, receiverAddr, port);
			ds.send(dp);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new UdpFileSender("192.168.141.6", 8888).start();
	}
}
