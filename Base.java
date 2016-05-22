import java.util.List;
import java.util.ArrayList;

interface DataBase {
	
	void buy(int numOfBuyEquipment);
	void addStock();
}

abstract class Product implements DataBase {
	protected int id;
	protected int numOfProduct;
	
	@Override
	public void buy(int numOfBuyEquipment) {

		if (numOfBuyEquipment > numOfProduct) {
			System.out.println("Нет необходимого количества товара на складе");
		} else if (numOfBuyEquipment < 0) {
			System.out.println("Количество преобретаемого товара не может быть меньше нуля"); 
		} else if (numOfBuyEquipment == 0) {
			System.out.println("Количество преобретаемого товара не может быть равно нулю");
		} else {
			numOfProduct = numOfBuyEquipment - numOfBuyEquipment;
		}
	}

	@Override
	public void addStock() {
		numOfProduct++;
	}
}

abstract class ComputerEquipment extends Product {
	protected String name;
	protected String manufacturedCompany;
	protected String processor;
	protected int ram;
	protected int hdd;
	protected boolean wifi;
}

abstract class PortableEquipment extends ComputerEquipment {
	protected String battery;
}

class Smartphone extends PortableEquipment{
	protected String camera;
	protected int numOfSIM;
}

class Laptop extends PortableEquipment {
	protected boolean opticalDrive;
	protected String graphicCard;

}

enum ID {
	LAPTOP,
	SMARTPHONE;
}

public class Base {
	public static void main(String[] args) {
		Laptop obj = new Laptop();
		List<DataBase> data = new ArrayList<>();
		int i  = (int)(Math.random()*2)+1;
		System.out.println(i);
	}
}
