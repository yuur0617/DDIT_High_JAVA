package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T06ServletContextTest extends HttpServlet{
	/*
	 	서블릿 컨텍스트 객체에 대하여..
	 	
	 	  1. 서블릿이 컨테이너와 정보를 주고 받기 위한 메서드를 제공한다.
	 	    ex) 파일의 MIME TYPE정보 가져오기, 요청정보 forwarding, 로깅처리 등..
	 	    
	 	  2. 웹 애플리케이션 당 1개씩 생성된다.
	 	  
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = req.getServletContext();
		
		System.out.println("서블릿 컨텍스트의 기본 경로 : " + ctx.getContextPath());
		System.out.println("서버 정보 : " + ctx.getServerInfo());
		System.out.println("서블릿 API의 메이저 버전 정보 : " + ctx.getMajorVersion());
		System.out.println("서블릿 API의 마이너 버전 정보 : " + ctx.getMinorVersion());
		System.out.println("파일에 대한 MIME타입 정보 : " + ctx.getMimeType("abc.mp3"));
		System.out.println("파일시스템 상의 실제 경로 : " + ctx.getRealPath("/"));
		
		// 속성값 설정
		ctx.setAttribute("attr1", "속성1");
		// 속성값 변경
		ctx.setAttribute("attr1", "속성2");
		System.out.println("att1의 속성값 : " + ctx.getAttribute("attr1"));
		//속성값 제거하기
		ctx.removeAttribute("attr1");
		
		// 로깅작업하기(로그파일)
		ctx.log("서블릿 컨텍스트를 이용한 로깅 작업 중입니다.!!!");

		// 포워딩(forwarding)처리
//		ctx.getRequestDispatcher(" 포워딩할 경로정보 ").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
