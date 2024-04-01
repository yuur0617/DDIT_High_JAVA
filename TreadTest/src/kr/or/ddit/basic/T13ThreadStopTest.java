package kr.or.ddit.basic;

public class T13ThreadStopTest {

	public static void main(String[] args) {

//		ThreadStopEx1 th1 = new ThreadStopEx1();
//		th1.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		

		/*
			stop()메서드를 호출하면 스레드가 바로 중지된다.
			이때 지원을 정리하지 못하고 종료되어서 프로그램에 나쁜영향을 줄수있다.
			그래서 현재는 비추천(Deprecated)으로 되어 있다.
		*/
		
//		th1.stop();
//		th1.setStopped(true);
		
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		th2.interrupt(); //인터럽트 걸기
	}
}

class ThreadStopEx1 extends Thread{
	
	private boolean isStopped;	//default = false

	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}
	
	@Override
	public void run() {
		while(!isStopped) {
			System.out.println("스레드 작업 중...");
		}
		
		System.out.println("자원 정리중...");
		System.out.println("실행 종료!");
	}
}

// interrupt() 메서드를 이용하여 스레드 멈추기
class ThreadStopEx2 extends Thread{
	
	@Override
	public void run() {
		
		/*
			방법 1 =>	sleep()메서드나 join()메서드 등을 사용했을때
					interrupt()를 호출하면  InterruptedException이 발생한다.
					이 예외를 이용하는 방법
		*/
	/*
		try {
			while(true) {
				System.out.println("스레드 처리 중...");
				Thread.sleep(1);
			}
		} catch (InterruptedException ex) {}
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료");
	*/
		/*
			방법 2 =>	interrupt()가 호출되었는지 검사하기
		*/
		while(true) {
			System.out.println("스레드 작업 중...");
			
		/*
			//검사방법1 =>	스레드의 인스턴스 메서드를 이용하는 방법
			if(this.isInterrupted()) {	//interrupt()가 호출되면 true...
				System.out.println("인스턴스 메서드 isInterrupted() 호출됨");
				break;
			}
		*/
			//검사방법2 =>	스레드의 static메서드를 이용하는 방법, 1회용
			if(Thread.interrupted()) {	//interrupt()가 호출되면 true...
				System.out.println("정적 메서드 interrupted() 호출됨 : " + Thread.interrupted());
				break;
			}
		}
		
		System.out.println("자원 정리중...");
		System.out.println("실행 종료!");
	}
}
