package borad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.vo.BoardVO;
import service.BoardServiceImpl;
import service.IBoardService;
import util.JDBCUtil;
import util.PrintUtil;

/*
	위의 테이블을 작성하고 게시판을 관리하는
	다음 기능들을 구현하시오.

	기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 */
public class BoardMain {

	private PrintUtil print;
	private Scanner scan;
	private IBoardService bdService;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardMain() {

		print = new PrintUtil();
		scan = new Scanner(System.in);
		bdService = new BoardServiceImpl();
	}
	
	public static void main(String[] args) {
		
		BoardMain boardObj = new BoardMain();
		boardObj.start();

	}
	
	/**
	 * 프로그램 시작 메서드
	 */
	public void start() {
		int choice = 0;
		do {
			print.printMenu();
			choice = scan.nextInt();
			switch(choice) {
			case 1: //전체 목록 출력
				displayAllBoard();
				break;
			case 2: //새 글작성
				insertBoard();
				break;
			case 3: //글 수정
				updateBoard();
				break;
			case 4: //글 삭제
				deleteBoard();
				break;
			case 5: //글 검색
				searchBoard();
				break;
			case 6: //작업 끝
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
					
			}
		}while(choice != 5);
	}

	/**
	 * 전체 목록 출력을 위한 메서드
	 */
	private void displayAllBoard() {
		print.printDpaBoard();
		
//		List<BoardVO> bdList = bdService.displayAllBoard();
		
		List<BoardVO> bdList = new ArrayList<BoardVO>();
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from fdbc_board");
			
			while(rs.next()) {
				String bdNum = rs.getNString("board_no");
				String bdTitle = rs.getNString("board_title");
				String bdWriter = rs.getNString("board_writer");
				
				BoardVO bv = new BoardVO();
				bv.setBdNum(bdNum);
				bv.setBdTitle(bdTitle);
				bv.setBdWriter(bdWriter);
				
				bdList.add(bv);
			}
		
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
	}

	/**
	 * 새 글을 작성하기 위한 메서드
	 */
	private void insertBoard() {
		
		boolean isExist = true;
		
		while(isExist) {
			
			System.out.print("제목 >>");
			String bdTitle = scan.next();
			
			System.out.print("작성자 >>");
			String bdWriter = scan.next();
			
			scan.nextLine();
			
			System.out.print("내용 >>");
			String bdContent = scan.nextLine();
			
			BoardVO bv = new BoardVO(bdTitle, bdWriter, bdContent);
			
			int cnt = bdService.registerBoard(bv);
			
			if(cnt > 0) {
				System.out.println("게시글 작성 성공");
			}else {
				System.out.println("게시글 작성 실패");
			}
			
			isExist = false;
		}
	}

	/**
	 * 글을 수정하기 위한 메서드
	 */
	private void updateBoard() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 글을 삭제하기 위한 메서드
	 */
	private void deleteBoard() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 글을 검색하기 위한 메서드
	 */
	private void searchBoard() {
		// TODO Auto-generated method stub
		
	}
}
