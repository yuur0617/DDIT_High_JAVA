package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		
		// URL 클래스 => 인터넷에  존재하는 서버들의 자원에 접근하기 위한 주소 정보를 
		//             관리하기 위한 클래스
		URL url = new URL(
				"http", "ddit.or.kr", 80, "/main/index.html?ttt=123#kkk");

		System.out.println("전체 URL 주소 : " + url.toString());
		
		System.out.println("protocol : " + url.getProtocol());
		System.out.println("host : " + url.getHost());
		System.out.println("query : " + url.getQuery());
		System.out.println("file : " + url.getFile()); // 쿼리정보 포함
		System.out.println("path : " + url.getPath()); // 쿼리정보 미포함
		System.out.println("port : " + url.getPort());
		System.out.println("ref : " + url.getRef());
		
		System.out.println(url.toExternalForm());
		System.out.println(url.toString());
		System.out.println(url.toURI().toString());
	}
}
