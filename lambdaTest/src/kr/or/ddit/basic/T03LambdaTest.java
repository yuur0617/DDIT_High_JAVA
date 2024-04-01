package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class T03LambdaTest {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		list.add("홍길동1");
		list.add("홍길동2");
		list.add("홍길동3");
	
		for(String name : list) {
			
			System.out.println(name);
		}
		
		System.out.println("--------------------------------");
		
		list.forEach(new Consumer<String >() {

			@Override
			public void accept(String name) {
				System.out.println(name);
			}
		});
		
		System.out.println("--------------------------------");
		
		list.forEach((name) -> System.out.println(name));
		
		/*
			메서드 참조에 대하여..
			
			참조변수 :: 인스턴스메서드
			클래스명 :: 정적메서드
			클래스명 :: 인스턴스메서드
			생성자명 :: new
		*/
		System.out.println();
		list.forEach(System.out::println);
		
		System.out.println("--------------------------------");
		
	//	메서드에 static이 있으면 에러발생
//		MyPrint mp = new MyPrint();
//
//		list.forEach(mp::printName);	//참조변수::인스턴스메서드
		
		System.out.println("--------------------------------");
		
		list.forEach(MyPrint::printName);	//클래스명::정적메서드
		System.out.println("--------------------------------");
		
		list.forEach(MyPrint::new);
			
	}
}

class MyPrint{
	
	public MyPrint() {};
	
	public MyPrint(String name) {
		System.out.println("생성자 안에서 name : " + name);
	}
	
	public static void printName(String name) {
		System.out.println("name : " + name);
	} 
}
