package dao;
/**
 *	실제 DB에 연결해서 SQL문을 수행하여 결과를 받아 Service에 전달하는 DAO인터페이스 
 */

import java.util.List;

import board.vo.BoardVO;

public interface IBoardDao {

	/**
	 * DB 테이블에 존재하는 모든 게시글을 가져오기 위한 메서드
	 * @return 게시글을 담은 List객체
	 */
	public List<BoardVO> selectAllBoard();

	/**
	 * BoardVO 에 담겨진 데이터를 DB에 insert하기 위한 메서드
	 * @param bv DB에 등록할 데이터를 담은 BoardVO 객체
	 * @return 작업이 성공하면 1이상의 값이 반환되고, 실패하면 0을 반환한다.
	 */
	public int insertBoard(BoardVO bv);

	/**
	 * BoardVO에 담겨진 데이터를 DB에 update하기 위한 메서드
	 * @param bv DB에 수정할 데이터를 담은 BoardBVO 객체
	 * @return 작업이 성공하면 1이상의 값이 반환되고, 실패하면 0을 반환한다.
 	 */
	public int updateBoard(BoardVO bv);

	/**
	 * 게시글을 삭제하기위한 메서드
	 * @param bdNum 삭제할 게시글의 번호
	 * @param bdWriter 삭제할 게시글의 작성자 이름
	 * @return 작업이 성공하면 1이상의 값이 반환되고, 실패하면 0을 반환한다.
	 */
	public int deleteBoard(int bdNum, String bdWriter);
	
}

