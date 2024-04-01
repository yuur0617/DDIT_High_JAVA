package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06wildCardTest {
	
	// 장바구니 항목조회를 위한 메서드(모든 가능한 항목)
	public static void displayCartItemInfo1(Cart<?> cart) {
		System.out.println("==== 음식류 장바구니 항목 리스트 ====");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		
		System.out.println("-----------------------------------------");
	}
	
	// 장바구니 항목조회를 위한 메서드(음료나 그 하위 항목)
	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {
		System.out.println("==== 음료류 장바구니 항목 리스트 ====");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
			
		System.out.println("-----------------------------------------");
	}
	
	// 장바구니 항목조회를 위한 메서드(고기나 그 상위 항목)
	public static void displayCartItemInfo3(Cart<? super Meat> cart) {
		System.out.println("==== 고기나 그 상위  장바구니 항목 리스트 ====");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
			
		System.out.println("-----------------------------------------");
	}
	
	public static void main(String[] args) {
		
		Cart<Food> foodCart = new Cart<>();
		foodCart.add(new Meat("돼지 고기", 5000));
		foodCart.add(new Meat("소 고기", 25000));
		foodCart.add(new Juice("오렌지 쥬스", 2000));
		foodCart.add(new Coffee("아메리카노", 1500));
		
		Cart<Meat> meatCart = new Cart<>();
		meatCart.add(new Meat("돼지 고기", 5000));
		meatCart.add(new Meat("소 고기", 25000));
//		meatCart.add(new Juice("오렌지 쥬스", 2000));
//		meatCart.add(new Coffee("아메리카노", 1500));
		
		Cart<Drink> drinkCart = new Cart<>();
//		drinkCart.add(new Meat("돼지 고기", 5000));
//		drinkCart.add(new Meat("소 고기", 25000));
		drinkCart.add(new Juice("오렌지 쥬스", 2000));
		drinkCart.add(new Coffee("아메리카노", 1500));
		
		displayCartItemInfo1(foodCart);
		displayCartItemInfo1(meatCart);
		displayCartItemInfo1(drinkCart);
		
		System.out.println();
		System.out.println("-----------------------------------------");
//		displayCartItemInfo2(foodCart);
//		displayCartItemInfo2(meatCart);
		displayCartItemInfo2(drinkCart);
		
		System.out.println();
		System.out.println("-----------------------------------------");
		displayCartItemInfo3(foodCart);
		displayCartItemInfo3(meatCart);
//		displayCartItemInfo3(drinkCart);
		
	}

}

class Food{
	
	private String name;
	private int price;
	
	//생성자
	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	//toString
	@Override
	public String toString() {
		return this.name + "(" + this.price + "원)";
	}
}

// 고기 클래스
class Meat extends Food{

	public Meat(String name, int price) {
		super(name, price);
	}
}

//음료 클래스
class Drink extends Food{

	public Drink(String name, int price) {
		super(name, price);
	}
}

//쥬스 클래스
class Juice extends Drink{

	public Juice(String name, int price) {
		super(name, price);
	}
}

//커피 클래스
class Coffee extends Drink{

	public Coffee(String name, int price) {
		super(name, price);
	}
}

//카트 클래스
class Cart<T> {
	private List<T> list;

	//생성자
	public Cart() {
		list = new ArrayList<T>();
	}
	
	//getter
	public List<T> getList(){
		return list;
	}
	
	//add 메서드
	public void add(T item) {
		list.add(item);
	}
}