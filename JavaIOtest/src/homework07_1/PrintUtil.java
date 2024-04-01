package homework07_1;

class Printutil {
	
	public void start() {
		System.out.println("***************************");
		System.out.println("호텔문을 열었습니다. ");
		System.out.println("***************************");
		System.out.println();
	}
	
	public void menu() {
		System.out.println("***************************");
		System.out.println("어떤 업무를 하기겠습니까?");
		System.out.println("1.체크인\t2.체크아웃\t3.객실상태\t4.업무종료");
		System.out.println("***************************");
		System.out.print("메뉴선택 => ");
		
	}
	
	public void checkinRoom() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
	}
	
	public void checkinName() {
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
	}
	
	public void checkoutRomm() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
	}
	
	public void end() {
		System.out.println();
		System.out.println("***************************");
		System.out.println("호텔문을 닫았습니다. ");
		System.out.println("***************************");
	}
}