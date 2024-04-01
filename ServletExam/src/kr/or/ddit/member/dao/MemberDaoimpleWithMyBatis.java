package kr.or.ddit.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.util.MyBatisUtil;
import kr.or.ddit.member.vo.MemberVO;

public class MemberDaoimpleWithMyBatis implements IMemberDao{
	private static MemberDaoimpleWithMyBatis instance=null;
	private MemberDaoimpleWithMyBatis() {};
	
	public static MemberDaoimpleWithMyBatis getInstance() {
		if(instance==null) instance=new MemberDaoimpleWithMyBatis();
		return instance;
	}
	@Override
	public int insertMember(MemberVO mv) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt=0;
		try {
			cnt = session.insert("member.insertMember",mv);
			session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = false;
		SqlSession session = MyBatisUtil.getInstance(true);
		try {
			int cnt = session.selectOne("member.checkMember",memId);
			if(cnt>0) {
				isExist=true;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isExist;
	}

	@Override
	public int updateMeber(MemberVO mv) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt=0;
		try {
			cnt = session.update("member.updateMember",mv);
			session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt=0;
		try {
			cnt = session.delete("member.deleteMember",memId);
			session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession session = MyBatisUtil.getInstance();
		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			memList = session.selectList("member.selectAllMember");
			session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		SqlSession session=MyBatisUtil.getInstance(true);
		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			memList=session.selectList("member.searchMember",mv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return memList;
	}

}
