package kr.or.ddit.basic;

public class T03ThreadTest {

	public static void main(String[] args) {
		/* 스레드의 수행시간 체크해 보기*/
		Thread th = new Thread(new MyRunner());
		
		/*
		 	UTC(Universal Time Coodinated, 협정 세계 표준시)를 사용하여 
			1970-01-01 0시 0분 0초를 기준으로 경과한 시간을 밀리세컨드(1/1000초) 단위로 나타낸다
		*/
		long startTime = System.currentTimeMillis();
		th.start(); 
		
		try {
			th.join();	// 실제 실행중인 스레드에서 작업중인 스레드(지금은 th스레드)가 종료될떄까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (endTime - startTime));
		
	}

}

class MyRunner implements Runnable{

	@Override
	public void run() {
		long sum = 0;
		for(int i=1; i<=1000000000; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
}
