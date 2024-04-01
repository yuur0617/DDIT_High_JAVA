/*
 * package homework03;
 * 
 * import java.util.HashMap; import java.util.Iterator; import java.util.Map;
 * import java.util.Scanner; import java.util.Set;
 * 
 * public class Service {
 * 
 * Scanner scan; private Map<String, HotelVO> hotelRoomMap;
 * 
 * 
 * public Service() { scan= new Scanner(System.in); hotelRoomMap = new
 * HashMap<String, HotelVO>(); }
 * 
 * Printutil printtuil = new Printutil();
 * 
 * public void checkin(){
 * 
 * printtuil.checkinRoom(); String roomNum = scan.nextLine();
 * 
 * HotelVO hv = hotelRoomMap.get(roomNum);
 * 
 * if(hv != null) { System.out.println("\n" + roomNum + "방은 이미 체크인된 방입니다.\n");
 * return; }
 * 
 * printtuil.checkinName(); String name = scan.nextLine();
 * 
 * hv = new HotelVO(roomNum, name);
 * 
 * hotelRoomMap.put(roomNum, hv);
 * 
 * System.out.println("\n체크인 되었습니다.\n");
 * 
 * }
 * 
 * public void checkoutRoom() {
 * 
 * printtuil.checkoutRomm(); String roomNum = scan.nextLine();
 * 
 * if(hotelRoomMap.remove(roomNum) == null) { System.out.println("\n" + roomNum
 * + "방은 체크인된 방이 없습니다.\n"); return; }else {
 * System.out.println("\n체크아웃되었습니다.\n"); } }
 * 
 * public void roomStatus() {
 * 
 * Set<String> keySet = hotelRoomMap.keySet();
 * 
 * if(keySet.size() == 0) { System.out.println("\n체크인한 객실이 없습니다.\n"); }else {
 * Iterator<String> it = keySet.iterator(); System.out.println();
 * while(it.hasNext()) { String roomNum = it.next(); HotelVO pv =
 * hotelRoomMap.get(roomNum);
 * 
 * System.out.println("방번호 : " + pv.getRoomNum() + ", 투숙객 : " + pv.getName());
 * 
 * } System.out.println(); } } }
 */