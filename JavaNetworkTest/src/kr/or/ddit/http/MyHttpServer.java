package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.util.StringTokenizer;

public class MyHttpServer {

	private final int port = 80;
	private final String encoding = "UTF-8";
	
	public void start() {
		
		ServerSocket serverSocket = null;
		
		try {
			
			serverSocket = new ServerSocket(this.port);
			
			while(true) {
				
				System.out.println("브라우저 요청 대기중...");
				Socket socket = serverSocket.accept();
				
				// Http 요청 처리 스레드 생성 및 구동
				HttpHandler handler = new HttpHandler(socket);
				handler.start();
				
				
			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Http 요청 처리를 위한 스레드 클래스
	 * @author PC-10
	 *
	 */
	class HttpHandler extends Thread{
		private Socket socket;
		
		public HttpHandler (Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {

			System.out.println("요청 처리 시작..");
			
			OutputStream out = null;
			BufferedReader br = null;
			
			try {
				
				out = new BufferedOutputStream(socket.getOutputStream());
				br = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				
				// 요청메시지 헤더 정보 파싱하기 
				StringBuilder sb = new StringBuilder();
				
				// Requset Line
				String reqLine = br.readLine();
				
//				System.out.println("Requset Line : " + reqLine);
				
				while(true) {
					String str = br.readLine();
					
					if(str.equals("")) break; // EmptyLine 체크
					
					sb.append(str + "\n");
				}
				
				// 헤더 정보
				String reqHeader = sb.toString();
				System.out.println("=== 요청 헤더 정보 ===");
				System.out.println(reqHeader);
				System.out.println("-------------------------------");
				
				// 요청 메시지의 경로 정보 가져오기
				String reqPath = "";
				
				StringTokenizer st = new StringTokenizer(reqLine);
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					
					if(token.startsWith("/")){
						reqPath = token;
						break;
					}
				}
				
				String filePath = "./WebContent" + reqPath;
				
				// 해당 파일 이름을 이용하여  Content-Type 정보 추출하기
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(filePath);
				
				File file = new File(filePath);
				if(!file.exists()) {
					makeErrorPage(out, 404, "Not Found");
					return;
				}
				
				byte[] body = makeResponseBody(filePath);
				byte[] header = makeRespanseHeader(body.length, contentType);
				
				out.write(header);
				
				// 응답 내용을 보내기 전에 반드시 Enpty Line 보내기
				out.write("\r\n\r\n".getBytes());
				
				out.write(body);
				
				out.flush(); // 강제 데이터 방출
				
			}catch(IOException ex) {
				ex.printStackTrace();
			}finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private byte[] makeResponseBody(String filePath) {
		
		byte[] data = null;
		
		FileInputStream fis = null;
		
		try {
			
			File file = new File(filePath);
			data = new byte[(int) file.length()];
			
			fis = new FileInputStream(file);
			fis.read(data);
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	/**
	 * 응답 헤더 생성하기
	 * @param contentLength 응답내용 크기
	 * @param mimeype 응답 내용 컨텐츠 타입 정보
	 * @return 헤더정보를 담은 바이트 배열
	 */
	private byte[] makeRespanseHeader(int contentLength, String mimeType) {
		
		String header = "HTTP/1.1 200 OK\r\n" 
					+ "Server: MyHttpServer 1.0\r\n"
					+ "Content-length : " + contentLength + "\r\n"
					+ "Content-type : " + mimeType + " charset = " +  this.encoding;
		
		return header.getBytes();
	}
	
	/**
	 * 에러페이지(응답) 생성
	 * @param out 
	 * @param statueCode
	 * @param errMsg
	 */
	private void makeErrorPage(OutputStream out, int statueCode, String errMsg) {
		
		String statusLine = "HTTP/1.1" + " " + statueCode + " " + errMsg;
		
		try {
			
			out.write(statusLine.getBytes());
			out.flush();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new MyHttpServer().start();
	}
}
