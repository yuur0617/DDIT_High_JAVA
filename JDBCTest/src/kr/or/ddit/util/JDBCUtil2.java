package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * db.properties 파밍릐 내용으로 DB정보
 */
public class JDBCUtil2 {
	
	static Properties prop;	//객체 변수 언언
	
	
	static {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩완료!");
			
		}catch(ClassNotFoundException ex){
			System.out.println("드라이버로딩실패!!");
			ex.printStackTrace();
		}
	}
	
	// 객체 생성 메서드
	public static Connection getConnection() {
		try {
			
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc06", "java");
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	 /*
	  	자원반납을 위한 메서드
	  */

	public static void close(Connection conn,Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
	    if(stmt!=null)try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
	    if(pstmt!=null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
	    if(conn!=null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
}
