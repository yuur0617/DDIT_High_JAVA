package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MyBatisTest {
	public static void main(String[] args) {
		
		// myBatis를 이용하여 DB데이터를 처리하는 작업 순서
		// 1. myBatis의 환경설정파일을 읽어와 필요한 객체를 생성한다.
		SqlSessionFactory sessionFactory = null;
		
		try {
			// 1-1. 설정파일 읽기(xml문서)
			// 설정파일의 인코딩정보 설정(한글처리를 위해서...)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader(
					"config/mybatis-config.xml");
			
			// 1-2. 위에서 생성한 Reader객체 이용하여 필요한 객체 생성
			sessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			rd.close(); // 스트림 닫기
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		// 2. 실행할 SQL문에 맞는 쿼리문을 호출하여 원하는 작업을 수행한다.
		
		// 2-1. insert작업 연습
		System.out.println("insert 작업 시작...");
		
		MemberVO mv = new MemberVO("d001", "강감찬", "010-1111-1111", "경남 진해시");
	
		
		// SqlSession객체를 이용하여 해당 쿼리문을 실행한다.
		// ex) sqlSesson.insert("namespace값.id값", 파라미터 객체)
		//   반환값 : 성공한 레코드 수
		
		// 세션 열기 (오토커밋 여부 설정)
		SqlSession sqlSession = sessionFactory.openSession(false); 
		
		try {
			int cnt = sqlSession.insert("memberTest.insertMember", mv);
			
			if(cnt > 0) {
				System.out.println("insert 작업 성공 : " + cnt);
				sqlSession.commit();
			}else {
				System.out.println("insert 작업 실패!!!");
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close(); // 세션 닫기
		}
		
		//----------------------------------------------
		
		// 2-2. update작업 연습
		System.out.println("update 작업 시작...");
		
		MemberVO mv2 = new MemberVO("d001", "강감찬", "010-2222-2222", "대전시 중구 오류동");

		
		SqlSession session = sessionFactory.openSession();
		
		try {
			// update()메서드의 반환값도 성공한 레코드 수 이다.
			int cnt = session.update("memberTest.updateMember", mv2);
			
			if(cnt > 0) {
				System.out.println("update작업 성공!");
				session.commit();
			}else {
				System.out.println("update작업 실패!!!");
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		System.out.println("-----------------------------------");
		
		/*// 2-3. delete 연습
		System.out.println("delete 작업 시작...");
		
		SqlSession session2 = sessionFactory.openSession();
		
		try {
			int cnt = session2.delete("memberTest.deleteMember", "d001");
			
			if(cnt > 0) {
				System.out.println("delelte 작업 성공!");
				session2.commit();
			}else {
				System.out.println("delete 작업 실패!!!");
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session2.close();
		} */
		
		
		// 2-4. select 연습
		// 1) 응답의 결과가 여러개 일 경우
		
		System.out.println("select 연습 시작(결과가 여러개일 경우)...");
		
		// 응답결과가 여러개일 경우에는 selectList()를 사용한다.
		// 이 메서드는 여러개의 레코드를 VO에 담은 후 이 VO데이터를 List에 추가해 주는
		// 작업을 자동으로 수행한다.
		SqlSession session3 = sessionFactory.openSession(true);
		
		try {
			List<MemberVO> memList = session3
					.selectList("memberTest.selectAllMember");
			for(MemberVO mv3 : memList) {
				System.out.println("ID : " + mv3.getMemId());
				System.out.println("이름 : " + mv3.getMemName());
				System.out.println("전화번호 : " + mv3.getMemTel());
				System.out.println("주소 : " + mv3.getMemAddr());
				System.out.println("==============================");
			}
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session3.close();
		}
		
		// 2) 응답결과가 1개인 경우...
		System.out.println("select 연습 시작(응답결과가 1개일 경우...");
		
		SqlSession session4 = sessionFactory.openSession(true);
		
		try {
			MemberVO mv4 = session4.selectOne("memberTest.getMember", "d001");
			
			System.out.println("ID : " + mv4.getMemId());
			System.out.println("이름 : " + mv4.getMemName());
			System.out.println("전화번호 : " + mv4.getMemTel());
			System.out.println("주소 : " + mv4.getMemAddr());
			System.out.println("==============================");
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session4.close();
		}
		
		
		
		
	}
}
