package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import board.vo.BoardVO;
import util.JDBCUtil;

public class BoardDaoImpl implements IBoardDao{

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public List<BoardVO> selectAllBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			String sql = " INSERT INTO jdbc_board "
					+ " (board_no, board_title, board_writer, board_date, board_content) " 
					+ "VALUES (, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBdNum());
			pstmt.setString(2, bv.getBdTitle());
			pstmt.setString(3, bv.getBdWriter());
			pstmt.setString(4, bv.getBdContent());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int bdNum, String bdWriter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
