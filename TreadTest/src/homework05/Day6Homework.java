package homework05;

/*
	경마 프로그램
	
	10마리의 말들이 경주하는 경마 프로그램 작성하기

	말은 Horse라는 이름의 클래스로 구성하고, 
	이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
	그리고, 이 클래스에는 등수를 오름차순으로 처리할수있는 기능이있다.
		(Comparable 인터페이스 구현)
	
	경기 구간은 1~50구간으로 되어있다.

	경기 중 주간중간에 말 각 말들의 위치를 >로 나타내시오.

	경기가 끝나면 등수를 기준으로 정렬하여 출력한다.

	//하나의 스레드를 더 작성하여 말이 고정되게 함.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day6Homework {

	static int HORSE_RANK = 1;

	public static void main(String[] args) {

		Track track = new Track();

		List<Horse> horseList = new ArrayList<Horse>();
		for (int num = 1; num <= 10; num++) {

			if (num < 10) {
				horseList.add(new Horse(" " + num + "번말"));
				System.out.println(" " + num + "번말 " + track.trackPrint());
			} else {
				horseList.add(new Horse(num + "번말"));
				System.out.println(num + "번말 " + track.trackPrint());

			}

		}

		for (Horse hl : horseList) {
			hl.start();
		}
		for(Horse hl : horseList) {
			try {
				hl.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 끝...");
		System.out.println("----------------------------");
		System.out.println("경기 결과 ");
		System.out.println("============================");
		System.out.println("순위\t:\t  이름");
		
		Collections.sort(horseList);
		
		for(Horse hl : horseList) {
			System.out.println(hl.getRank() + "\t:\t" + hl.getName());
		}
	}
}

class Track {

	int trackarrSize = 50;
	char[] trackarr = new char[50];
	String trackString = "";

	public String trackPrint() {

		for (int j = 0; j < trackarr.length; j++) {

			trackarr[0] = '>';
			trackarr[j] = '-';
		}

		trackString = new String(trackarr);
		return trackString;
	}
}

class Race extends Thread{	//경주마 고정하는 스레드
	
	Track track = new Track();
	
	
	
}

class Horse extends Thread implements Comparable<Horse>{

	Track track = new Track();

	private String horseName; // 말이름 멤버변수

	private int rank; // 등수 멤버변수

	// 생성자
	public Horse(String horseName) {
		super(horseName);
		this.horseName = horseName;
	}

	// rank getter,setter
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {
		track.trackPrint();
		for (int sec = 1; sec <= track.trackarr.length; sec++) {

			if (sec == 50) break;
			track.trackarr[sec] = '>';
			track.trackarr[sec - 1] = '-';
			track.trackString = new String(track.trackarr);
			System.out.println(horseName + track.trackString);
			

			try {
				Thread.sleep((int) (Math.random() * 301 + 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		setRank(Day6Homework.HORSE_RANK++); // 순위정보 설정
	}

	@Override
	public int compareTo(Horse hl) {
		
		return new Integer(this.getRank()).compareTo(hl.getRank());
	}
}
