package service;

import java.util.List;

import board.vo.BoardVO;
import dao.BoardDaoImpl;
import dao.IBoardDao;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao bdDao;
	
	public BoardServiceImpl() {
		bdDao = new BoardDaoImpl();
	}
	
	@Override
	public List<BoardVO> displayAllBoard() {
		
		List<BoardVO> bdList = bdDao.selectAllBoard();
		
		return bdList;
	}

	@Override
	public int registerBoard(BoardVO bv) {
		
		int cnt = bdDao.insertBoard(bv);
		
		return 0;
	}

	@Override
	public int modifyBoard(BoardVO bv) {

		int cnt = bdDao.updateBoard(bv);
		
		return 0;
	}

	@Override
	public int removeBoard(int bdNum, String bdWriter) {

		int cnt = bdDao.deleteBoard(bdNum, bdWriter);
		
		return 0;
	}

}
