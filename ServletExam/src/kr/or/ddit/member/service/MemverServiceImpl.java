package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dao.MemberDaoimpleWithMyBatis;
import kr.or.ddit.member.vo.MemberVO;

public class MemverServiceImpl implements IMemberService{
	private static IMemberService memberService=null;
	private IMemberDao memDao;
	
	private MemverServiceImpl() {
		memDao=MemberDaoimpleWithMyBatis.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memberService==null) memberService=new MemverServiceImpl();
		return memberService;
	}
	@Override
	public int registerMember(MemberVO mv) {
		//회원정보 DB 등록
		int cnt = memDao.insertMember(mv);
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		
		return memDao.checkMember(memId);
	}

	@Override
	public int modifyMeber(MemberVO mv) {
		int cnt = memDao.updateMeber(mv);
		return cnt;
	}

	@Override
	public int removeMember(String memId) {
		int cnt = memDao.deleteMember(memId);
		return cnt;
	}

	@Override
	public List<MemberVO> displayAllMember() {
		List<MemberVO> memList=memDao.selectAllMember();
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList=memDao.searchMember(mv);
		return memList;
	}

}
