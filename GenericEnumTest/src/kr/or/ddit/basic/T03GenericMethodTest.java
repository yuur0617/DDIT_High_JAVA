package kr.or.ddit.basic;

class Util{
	
	/*
	 	제너릭 메서드 <T, R> R method (T t)
	 	
	 	파라미터 타입과 리턴타입으로 타입글자를 가지는 메서드
	 	
	 	선언 방법 : 리턴타입 앞에 <> 기호를 추가하고 타입글자를 기술 후 사용함.
	 */
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		
		boolean keyCompare = p1.getKet().equals(p2.getKet());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

/*
	멀티타입 <K, V>을 가지는 제너릭 클래스
*/

class Pair<K, V> {
	private K ket;
	private V value;
	
	//생성자
	public Pair(K ket, V value) {
		super();
		this.ket = ket;
		this.value = value;
	}
	
	//ket getter,setter
	public K getKet() {
		return ket;
	}
	public void setKet(K ket) {
		this.ket = ket;
	}
	
	//value getter,setter
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public <K, V> void displayAll(K key, V value) {
		System.out.println(key + " : " + value);
	}
}


public class T03GenericMethodTest {

	public static void main(String[] args) {
		
		Pair<Integer, String > p1 = new Pair<Integer, String> (1, "홍길동");
		Pair<Integer, String > p2 = new Pair<Integer, String> (1, "홍길동");
		
		// 구체적인 타입을 명시적으로 지정 (생략가능)
		boolean result1 = Util.<Integer, String> compare (p1, p2);
		
		System.out.println("result1 결과");
		if(result1) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체아님.");
		}
		
		Pair<String, String> p3 = new Pair<String, String> ("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String> ("002", "홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		
		System.out.println();
		System.out.println("result2 결과");
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체아님.");
		}
		
		p1.displayAll("키", 180);
	}

}
