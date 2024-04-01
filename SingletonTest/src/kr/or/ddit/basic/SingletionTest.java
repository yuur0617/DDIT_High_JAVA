package kr.or.ddit.basic;

public class SingletionTest {

	public static void main(String[] args) {
//		MySingleton test1 = new MySingleton(); // new 명령 사용물가

		// getInstance() 이용하여 객체 생성
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		test2.displayText();
		test3.displayText();
		
		System.out.println("test2 =>" + test2);
		System.out.println("test3 =>" + test3);
		
		System.out.println(test2 == test3);
	}

}
