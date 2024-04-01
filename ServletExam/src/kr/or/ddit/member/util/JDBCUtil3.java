package kr.or.ddit.member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
/**
 * db.properties 파일의 내용으로 DB설정정보를 설정하는 방법
 * 방법 2) ResourceBundle객체 이용하기
 * @author PC-24
 *
 */
public class JDBCUtil3 {
	static ResourceBundle bundle;
	static {
		bundle=ResourceBundle.getBundle("db");
		try {
			Class.forName(bundle.getString("driver"));
			System.out.println("드라이버 로딩 완료!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		} 
	}
	/**
	 * Connection 객체 생성 메서드
	 * @return Connection객체 , 예외 발생 시 null
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(bundle.getString("url"),
					bundle.getString("username"),bundle.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 자원반납을 위한 메서드
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn,Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
		if(stmt!=null)try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(pstmt!=null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(conn!=null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}
}
