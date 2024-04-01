/*
 * package homework03;
 * 
 * import java.util.Scanner;
 * 
 * 
 * 호텔 운영을 관리하는 프로그램 작성 (Map이용) - 키값은 방번호
 * 
 * ...실행 예시...
 **************************
 * 호텔 문을 열었습니다.
 **************************
 ******************************************* 
 * //반복 어떤 업무를 하시겠습니까? 1.체크인 2.체크아웃 3.객실상태 4.업무종료
 *******************************************
 * 메뉴선택 => 1 <-- 입력 어느방에 체크인 하시겠습니까? 방번호 입력 => 101 <-- 입력
 * 
 * 누구를 체크인 하시겠습니까? 이름 입력 => 홍길동 <-- 입력 체크인 되었습니다.
 * 
 * 메뉴선택 => 3 <-- 입력
 * 
 * 방번호 : 102, 투숙객 : 성춘향 방번호 : 101, 투숙객 : 홍길동
 * 
 * 메뉴선택 => 2 <-- 입력
 * 
 * 어느방을 체크아웃 하시겠습니까? 방번호 입력 => 101 <-- 입력 체크아웃 되었습니다.
 * 
 * 메뉴선택 => 4 <-- 입력
 **************************
 * 
 * 호텔 문을 닫았습니다.
 **************************
 * 
 * public class Controller {
 * 
 * private static Scanner scan; private static Printutil printutil; private
 * Service service;
 * 
 * public Controller() {
 * 
 * scan = new Scanner(System.in); printutil = new Printutil(); service = new
 * Service();
 * 
 * }
 * 
 * public static void main(String[] args) {
 * 
 * new Controller().hotelstart(); }
 * 
 * public void hotelstart() { printutil.start();
 * 
 * while(true) { printutil.menu(); int num = scan.nextInt();
 * 
 * switch (num) { case 1: service.checkin(); break; case 2:
 * service.checkoutRoom(); break; case 3: service.roomStatus(); break; case 4:
 * printutil.end(); return; default:
 * System.out.println("\n업무번호를 잘못입력하였습니다.\n "); break; } } } }
 * 
 * 
 * 
 */