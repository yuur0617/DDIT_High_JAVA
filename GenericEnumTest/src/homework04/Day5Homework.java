package homework04;

/*
	행성의 면적 구하기 
	
	태양계 행성을 나타내는 enum Planet을 이용하여구하시오.
	태양계 행성의 반지름을 이용하여 면적 구하기.
	(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.)
	(구의 겉넓이는 4πr² )
*/
public class Day5Homework {

	public static void main(String[] args) {
		
		//열거형 상수를 가져오기위한 배열 생성
		
		float pi = 3.141592F;	//π = 3.141592...
		
		for(Planet pl : Planet.values() ) {
			
			//면적을 계산후 변수에 저장
			double area = 4 * pi * pl.getData() * pl.getData(); 
			
			System.out.println("[" + pl + "]");	//행성이름 
			System.out.println("반지름 : \t" + pl.getData() + " Km");	//반지름값
			System.out.println("면  적 : \t" + area + " Km");	//면적값	//ex)E7 = 10^7
			System.out.println("------------------------");
		}	
	}
	
	public enum Planet {
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 
		목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
		
		//괄호속 값이 저장될 변수 선언
		private int data;
		
		//생성자 선언
		Planet(int data){
			this.data = data;
		}
		
		//getter메서드 
		public int getData() {
			return data;
		}
	};
	
}
