package service;

import java.util.List;

import board.vo.BoardVO;

public interface IBoardService {
	
	/**
	 * 전체 목록을 가져오기위한 메서드
	 * @return
	 */
	public List<BoardVO> displayAllBoard();
	
	/**
	 * 게시글을 등록하기 위한 메서드
	 * @param bv 등록할 데이터를 담은 BoardVO 객체
	 * @return 작업이 성공하면 1이상의 값이 반환되고, 실패하면 0을 반환한다.
	 */
	public int registerBoard(BoardVO bv);

	/**
	 * 게시글을 수정하기 위한 메서드 , BoardVO에 담겨진 데이터를 udpate하기위한 메서드
	 * @param bv 수정할 데이터를 담은 BoardVO
	 * @return 작업이 성공하면 1이상의 값이 반환되고, 실패하면 0을 반환한다.
	 */
	public int modifyBoard(BoardVO bv);
	
	/**
	 * 게시글을 삭제하기 위한 메서드 , 입력한 게시글 번호와 작성자이름과 DB에 저장된 게시글번호와 작성자 이름이 같아야됨
	 * @param bdNum 삭제할 게시글 번호
	 * @param bdWriter 삭제하라 게시글 작성자  
	 * @return
	 */
	public int removeBoard(int bdNum, String bdWriter);
}
