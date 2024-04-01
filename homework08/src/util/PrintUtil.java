package util;

public class PrintUtil {
	
	public void printMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새 글 작성");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 글 삭제");
		System.out.println("  5. 글 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	public void printDpaBoard() {
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성날짜");
		System.out.println("-------------------------------------------");
		
	}
}
