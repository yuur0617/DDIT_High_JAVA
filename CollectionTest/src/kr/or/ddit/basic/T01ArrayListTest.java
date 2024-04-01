package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {
		
		// 기본용량 : 10
		List list1 = new ArrayList();
		
		// add() 메서드를 사용해서 데이터를 추가한다.
		
		/* 형에 상관없이 모든걸 객체(Object)화 시킨다. => Wrapper
		   int, long, double, ... 는   Wrapper Class */ 
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		// size() => 데이터 개수
		System.out.println("size() => " + list1.size());
		System.out.println("list1() => " + list1);
		
		// get() 을 이용하여 데이터 꺼내오기
		System.out.println("1번째 자료 : " + list1.get(0)); /* 0 : index 값 => 순서가 있다.*/
		
		// 데이터 끼워넣기
		list1.add(0, "zzz");
		System.out.println("list1(끼워넣기 후) => " + list1);
		
		// 데이터 변경하기
		String temp = (String) list1.set(0, "yyy");
		System.out.println("temp => " + temp);
		System.out.println("list1(데이터 변경 후) => " + list1);
		
		// 데이터 삭제하기
		list1.remove(0);
		System.out.println("데이터 삭제 후 => " + list1);
		
		list1.remove("bbb");
		System.out.println("bbb 삭제 후 => " + list1);
		System.out.println("=========================================================");
		
		list1.remove(1);	/* index 값을 이용*/
		System.out.println("111 삭제 후 => " + list1);
		
		list1.remove(new Integer(111)); /* 111을 index로 인식하기때문에  Object 선언을 해줘야함*/	
		System.out.println("111 삭제 후 => " + list1);
		System.out.println("=========================================================");
		
		
		// 제너릭을 지정하여 선언할수있다.
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for(String s : list2) {
			System.out.println(s);
		}
		
		System.out.println("=========================================================");
		
		// Contains (비교 객체) => 리스트에 '비교객체'가 있으면 true, 없으면 false
		/* COntains : 포함하다 */
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		
		// indexOf (비교객체) => 리스트에서 '비교객체'를 찾아 '비교객체'가 존재하는 index값을 반환한다.
		//					    없으면 -1을 반환한다.
		System.out.println("DDD의  index값 : " + list2.indexOf("DDD")); /* => 3 */
		System.out.println("ZZZ의  index값 : " + list2.indexOf("ZZZ"));
		System.out.println("=========================================================");
		
//		for(int i=0; i<list2.size(); i++) {	/* BBB, DDD는 remove되지 않음. */
//			list2.remove(i);
//		}
//		System.out.println(list2);
//		System.out.println("list2 size() => " + list2.size());
		
		for(int i=list2.size()-1; i>=0; i--) {
			list2.remove(i);
		}
		System.out.println(list2);
		System.out.println("list2 size() => " + list2.size());
	}
}
