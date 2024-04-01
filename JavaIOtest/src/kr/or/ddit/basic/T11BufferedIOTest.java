package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11BufferedIOTest {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192(8KB)로 설정된다.
			bos = new BufferedOutputStream(fos, 5);
			
			for(char ch = '1'; ch <= '9'; ch++) {
				fos.write(ch);
			}
			
			bos.flush(); // 작업을 종료 하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.(close()시 자동으로 호출됨)
						 // flush : 비우다
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
