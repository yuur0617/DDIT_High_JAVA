package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemverServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/member/insert.do")
public class InsertMemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/member/insertForm.jsp").forward(req, resp);;
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId=req.getParameter("memId");
		String memName=req.getParameter("memName");
		String memTel=req.getParameter("memTel");
		String memAddr=req.getParameter("memAddr");
		
		IMemberService memService =  MemverServiceImpl.getInstance();
		MemberVO mv = new MemberVO(memId,memName,memTel,memAddr);
		int cnt = memService.registerMember(mv);
		String msg="";
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		req.getRequestDispatcher("/member/list.do").forward(req, resp);
	}
}
