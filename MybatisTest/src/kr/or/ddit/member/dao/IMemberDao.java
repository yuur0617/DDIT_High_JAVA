package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 실제 DB에 연결해서 SQL문을 수행하여 결과를 받아 
 * Service에 전달하는 DAO 인터페이스
 * @author sem
 *
 */
public interface IMemberDao {
	
	/**
	 * MemberVO 에 담겨진 데이터를 DB에 insert하기 위한 메서드
	 * @param mv DB에 등록할 데이터를 담은 MemberVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0을 반환한다.
	 */
	public int insertMember(MemberVO mv);
	
	/**
	 * DB에 해당 회원이 존재하는지 체크하기 위한 메서드
	 * @param memId 존재여부 체크할 회원ID
	 * @return 해당 회원이 존재하면 true, 존재하지 않으면 false 리턴함.
	 */
	public boolean checkMember(String memId);
	
	/**
	 * MemberVO 에 담겨진 데이터를 DB에 update 하기 위한 메서드
	 * @param mv DB에 수정할 데이터를 담은 MemberVO객체
	 * @return DB작업이 성공하면 1 반환되고, 실패하면 0을 반환한다.
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 회원정보를 삭제하기 위한 메서드
	 * @param memId 회원정보를 삭제할 회원ID
	 * @return 삭제성공 : 1, 삭제실패 : 0 반환함.
	 */
	public int deleteMember(String memId);
	
	/**
	 * DB 테이블에 존재하는 모든 회원정보를 가져오기 위한 메서드
	 * @return 회원정보를 담은 List 객체
	 */
	public List<MemberVO> selectAllMember();
	
	/**
	 * DB 테이블에 존재하는 회원정보중에서 검색조건에 해당하는 회원정보를 가져오기 위한 메서드
	 * @param mv 검색조건을 담은 MemberVO객체
	 * @return 검색된 회원정보를 담은 List객체
	 */
	public List<MemberVO> searchMember(MemberVO mv);
	
	
	
	
	
	
}
