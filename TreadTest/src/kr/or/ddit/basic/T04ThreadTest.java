package kr.or.ddit.basic;

/*
 	1~20억까지의 합계를 구하는데 걸린 시간 체크해 보기
 	전체합계를 구하는 작업을 단독으로 처리했을때 (1개의 스레드를 이동했을때)와
 	여러 스레드로 분할해서 작업할때의 시간을 확인해 보자.
 */

public class T04ThreadTest {

	public static void main(String[] args) {
		
		// 단일 스레드로 처리하는 경우..
		SumThread sm = new SumThread(1L, 2000000000L);
		
		long startTime = System.currentTimeMillis();
		
		sm.start();

		try {
			sm.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리할때의 처리시간(ms) : " + 
						(endTime - startTime));
		System.out.println("\n\n");
		
		// 여러 스레드가 협력해서 치리했을때
		SumThread[] sumThs = new SumThread[] {
				new SumThread(		  1L,  500000000L),
				new SumThread( 50000000L, 1000000000L),
				new SumThread(100000000L, 1500000000L),
				new SumThread(150000000L, 2000000000L)
		};
		
		startTime = System.currentTimeMillis();
		
		for(SumThread sth : sumThs) {
			sth.start();
		}
		
		for(SumThread sth : sumThs) {
			try {
				sth.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("4개 스레드로 협력해서 처리할때의 처리시간(ms) : "+
						(endTime - startTime));		
	}

}

class SumThread extends Thread{
	
	private long min, max;
	
	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
		public void run() {
			
			long sum = 0L;
			for(long i= min; i<=max; i++) {
				sum += i;				
			}
			System.out.println(min + "~" + max + "까지의 합 : " + sum);
		}
}