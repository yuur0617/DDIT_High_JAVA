package homework01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	- 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student 클래스 생성
	- 생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리
	- Student객체들은 List에 저장하여 관리
	- List에 저장된 데이터들은 학번의 오름차순으로 정렬하여 출력하는 부분과
	   총점의 역순으로 정렬하는 부분을 작성해라
	- 총점이 같으면 학번의 내림차순으로 정렬
	- 학번 정렬기준은 Student클래스 자체에서 제공
	- 총점 정렬기준은 외부클래스에서 제공

*/
public class Day1Homework {

	public static void main(String[] args) {
		
		Day1Homework homework = new Day1Homework();	 //Day1Homework 객체 생성 -> setRanking메서드 호출하기 위해
		
		List<Student> stdList = new ArrayList<Student>();  //List<Studnet> 객체 리스트 생성? 
		
		stdList.add(new Student("00000001","홍길동", 90, 80, 70));
		stdList.add(new Student("00000033","이순신", 70, 70, 80));
		stdList.add(new Student("00000025","강감찬", 80, 90, 60));
		stdList.add(new Student("00000020","변학도", 50, 70, 70));
		stdList.add(new Student("00000051","일지매", 50, 80, 90));
		
		homework.setRanking(stdList);	//등수 메기는 메서드 호출
		
		System.out.println("정렬 전 : ");
		for(Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("==================================================");
		
		System.out.println();
		
		Collections.sort(stdList);
		System.out.println("학번의 오름차순 정렬 후 : ");
		for(Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("==================================================");
		
		System.out.println();
		
		Collections.sort(stdList, new sumSortDesc());
		System.out.println("총점의 내림차순 정렬 후 : ");
		for(Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("==================================================");
	}
	
	//등수를 매길 메서드
	public void setRanking(List<Student> stdList){
		for(Student std : stdList){  // 등수를 구할 자료(기준 자료)
			int rank = 1;
			for(Student std2 : stdList){ // 비교할 자료
				if(std.getSum() < std2.getSum() ){
					rank++;
				}
			}
			std.setRank(rank);
		}
	}
}


// 총점의 역순(내림차순)으로 정렬하는 외부 클래스
class sumSortDesc implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getSum() > std2.getSum()) {
			return -1;  //std1이 std2보다 크다면, std1을 std2보다 앞에 위치하도록 정렬
		}else if (std1.getSum() == std2.getSum()) {
			return std1.getNum().compareTo(std2.getNum()) * -1;	//총점이 같을경우 학번의 내림차순
		}else {
			return 1;  //std1이 std2보다 작다면, std1을 std2보다 뒤에 위치하도록 정렬
		}
	}
	
}

// 학번의 오름차순으로 정렬하는 클래스
class Student implements Comparable<Student>{
	private String num;		//학번
	private String name;	//이름
	private int korScore;	//국어점수
	private int engScore;	//영어점수
	private int mathScore;	//수학점수
	private int sum;		//총점
	private int rank;		//등수
	
	@Override
	public int compareTo(Student std) {
		
		return this.getNum().compareTo(std.getNum()); /* compareTo 메서드는 객체를 다른 객체와 비교할 때 사용 */
	}
	
	public Student(String num, String name, int korScore, int engScore, int mathScore) {  //생성자
		super();
		this.num = num;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.sum = korScore + engScore + mathScore;
	}

	//toString()
	@Override
	public String toString() {	//출력문

		return "Student [학번=" + num + ", 이름=" + name + ", 국어점수=" + korScore + ", 영어점수=" + engScore
				+ ", 수학점수=" + mathScore+ ", 총점="+ sum + ", 등수 =" + rank +"]";
	}
	
	//num getter, setter
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	//name getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//korScore getter, setter
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	
	//engScore getter, setter
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	
	//mathScore getter, setter
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	//sum getter,setter
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = korScore + engScore + mathScore;
	}
	
	//rank getter, setter
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

}
