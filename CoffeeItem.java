package ch19.posBackup2;

public class CoffeeItem extends MenuItem{	
	
	public String type = "커피";
	
	public CoffeeItem(String type, int itemNumber, String name, int price) {
		super(type, itemNumber, name, price);
	}	
	
	
	
	@Override
	public String toString() {
		return "커피메뉴: (" + getItemNumber() + ") " + getName() + " / 가격 : " + getPrice();
	}	

}
