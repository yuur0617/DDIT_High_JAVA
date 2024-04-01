package homework07_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Service {
	
	Scanner scan; 
	private Map<String, HotelVO> hotelRoomMap;

		
	public Service() {
		scan= new Scanner(System.in);
		hotelRoomMap = new HashMap<String, HotelVO>();
	}

	Printutil printtuil = new Printutil();
	
	public void checkin(){
		
		printtuil.checkinRoom();
		String roomNum = scan.nextLine();
		
		HotelVO hv = hotelRoomMap.get(roomNum);
		
		if(hv != null) {
			System.out.println("\n" + roomNum + "방은 이미 체크인된 방입니다.\n");
			return;
		}
		
		printtuil.checkinName();
		String name = scan.nextLine();
		
		hv = new HotelVO(roomNum, name);
		
		hotelRoomMap.put(roomNum, hv);
		
		System.out.println("\n체크인 되었습니다.\n");
		
	}
	
	public void checkoutRoom() {
		
		printtuil.checkoutRomm();
		String roomNum = scan.nextLine();
		
		if(hotelRoomMap.remove(roomNum) == null) {
			System.out.println("\n" + roomNum + "방은 체크인된 방이 없습니다.\n");
			return;
		}else {
			System.out.println("\n체크아웃되었습니다.\n");
		}
	}
	
	public void roomStatus() {
		
		Set<String> keySet = hotelRoomMap.keySet();
		
		if(keySet.size() == 0) {
			System.out.println("\n체크인한 객실이 없습니다.\n");
		}else {
			Iterator<String> it = keySet.iterator();
			System.out.println();
			while(it.hasNext()) {
				String roomNum = it.next();
				HotelVO pv = hotelRoomMap.get(roomNum);
				
				System.out.println("방번호 : " + pv.getRoomNum() + ", 투숙객 : " + pv.getName());
				
			}
			System.out.println();
		}
	}
	
	// 데이터를 저장할 파일 생성하는 메서드
	public void newFile() {
		File hotel = new File("d:/D_Other/hotel/roomState.bin");
		
		if(hotel.exists()) {	// roomState.bin 파일이있으면 return 
			return;
		}else {					// 없을경우 roomState.bin 파일 생성
			try {
				ObjectOutputStream room = 
						new ObjectOutputStream(
								new BufferedOutputStream(
										new FileOutputStream("d:/D_Other/hotel/roomState.bin")));
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// 파일에서 데이터 받아오는 메서드
	public void receive() {
		try {
			
			ObjectInputStream ois;
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("d:/D_Other/hotel/roomState.bin")));
			
			Object obj;
			
			while((obj = ois.readObject()) != null) {
				hotelRoomMap = (Map<String, HotelVO>)obj;
			}
			
			ois.close();
			
		}catch(IOException ex) {
//			ex.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 업무 종료시 파일에 정보를 저장하는 메서드
	public void close() {
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("d:/D_Other/hotel/roomState.bin")));
			
			oos.writeObject(hotelRoomMap);
			oos.close();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
}
