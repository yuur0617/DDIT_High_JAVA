package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {
		
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번스레드", sObj);
		WorkerThread th2 = new WorkerThread("2번스레드", sObj);
		
		th1.start();
		th2.start();
	}
}

class ShareObject {
	
	private int sum;
	// 동기화 하는 방법 1: 메서드 자체에 동기화 설정하기
	//synchronized public void add() {
	public void add() {
		
		// 동기화 하는 방법2 : 동기화 블럭으로 설정하기
		// mutex : Mutual Exclusion Object (상호 배제: 동시접근 차단)
		//synchronized (this) {
			for(int i=0; i<=1000000000; i++) {}  // 동기화 처리 전까지 시간벌기용
			
			int n = sum;
			
			n += 10;
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName()
					+ " => 합계: " + sum);
		//}
		
		
	}
}

// 작업 수행을 위한 스레드
class WorkerThread extends Thread {
	private ShareObject sObj;
	
	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			
			synchronized (sObj) {
				sObj.add();
			}
			
		}
	}
}


