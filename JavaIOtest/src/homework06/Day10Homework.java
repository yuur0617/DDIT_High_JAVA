package homework06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	파일 복사 프로그램 
	
	'd:/D_Other/'에 있는 'Tulips.jpg'파일을
	'복사본_Tulips.jpg'로 복사하는 프로그램을 작성하시오.
*/

public class Day10Homework {
	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(new File("d:/D_Other/Tulips.jpg"));
			fos = new FileOutputStream(new File("d:/D_Other/복사본_Tulips.jpg"));

			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			File copyFile = new File("d:/D_Other/복사본_Tulips.jpg");
			if (copyFile.exists()) {
				System.out.println("복사 성공...!");
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
