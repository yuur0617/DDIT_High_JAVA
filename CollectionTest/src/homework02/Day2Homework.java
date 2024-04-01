package homework02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Day2Homework {
	/*
	 * 사용자는 로또를 구매할 때 구매할 금액을 입력한다. 입력한 금액에 맞게 로또번호를 출력한다. (단, 로또 한장의 금액은 1000원이고
	 * 거스름돈도 계산하여 출력한다.)
	 */
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean a = true;
		int num;	// 입력받을 숫자
		int price;	// 받은 금액
		int count;	// 로또 개수
		
		while (a) {
			System.out.println("================================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("================================");
			System.out.print("메뉴선택 : ");
			num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("Lotto 구입 시작");
				System.out.println("1000원에 로또번호 하나입니다.");
				System.out.print("금액입력 : ");
				price = sc.nextInt();
				count = (price / 1000);
				System.out.println();
				for(int i=1; i <= count; i++) {
					System.out.println("로또번호 " + i + ":" + lotto() );
				}
				System.out.println();
				System.out.println("받은 금액은" + price + "원 이고 거스름돈은 "+ 
									price%1000 + "원입니다.");
				System.out.println();
				break;
			case 2:
				a = false;
				System.out.println("감사합니다.");
				break;
			default: System.out.println("잘못입력하였습니다.");
			}

		}
	
	}

	 public static String lotto() {
		 
		 	String a = "";
		 
			Set<Integer> lottoRnd = new TreeSet<Integer>();	//TreeSet 자동 정렬
			while(lottoRnd.size() < 6) {
				int lottoNum = (int)(Math.random() * 45 +1);
				lottoRnd.add(lottoNum);
			}
			
			for(Integer lottoNum : lottoRnd) {
				a = a + lottoNum + ", ";
			}
			a = a.trim();
			a = a.replaceAll(",$", "");
			return a;
}



}

