import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;

abstract class Product {
	protected int id;
	protected int numOfProduct;
	
	public final void buy(int numOfBuyEquipment) {

		if (numOfBuyEquipment > numOfProduct) {
			System.out.println("In stock enough products");
		} else if (numOfBuyEquipment < 0) {
			System.out.println("Number of by equipment can't be less then zero");
		} else if (numOfBuyEquipment == 0) {
			System.out.println("Number of by equipment can't be is zero");
		} else {
			numOfProduct = numOfBuyEquipment - numOfBuyEquipment;
		}
	}

	public final void addStock() {
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

abstract class PortableEquipment extends ComputerEquipment implements Serializable {
	protected String battery;
}

class Smartphone extends PortableEquipment {
	protected boolean camera;
	protected int numOfSIM;
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNumOfProduct(int numOfProduct) {
		this.numOfProduct = numOfProduct;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturedCompany(String manufacturedCompany) {
		this.manufacturedCompany = manufacturedCompany;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public void setNumOfSIM(int numOfSim) {
		this.numOfSIM = numOfSim;
	}

	@Override
	public String toString() {
		return "Id "+id+"\n"+
			"Number of product: "+numOfProduct+"\n"+
			"Manufactured company: "+manufacturedCompany+"\n"+
			"Sireal No(name): "+name+"\n"+
			"Processor inside: "+processor+"\n"+
			"RAM: "+ram+"\n"+
			"HDD: "+hdd+"\n"+
			"Wi-Fi: "+wifi+"\n"+
			"Battery: "+battery+"\n"+
			"Camera: "+camera+"\n"+
			"Number of SIMcard: "+numOfSIM+"\n";
	}
}

class Laptop extends PortableEquipment {
	protected boolean opticalDrive;
	protected String graphicCard;
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNumOfProduct(int numOfProduct) {
		this.numOfProduct = numOfProduct;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturedCompany(String manufacturedCompany) {
		this.manufacturedCompany = manufacturedCompany;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public void setOpticalDrive(boolean opticalDrive) {
		this.opticalDrive = opticalDrive;
	}

	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}

	@Override
	public String toString() {
		return "Id "+id+"\n"+
			"Number of product: "+numOfProduct+"\n"+
			"Manufactured company: "+manufacturedCompany+"\n"+
			"Sireal No(name): "+name+"\n"+
			"Processor inside: "+processor+"\n"+
			"RAM: "+ram+"\n"+
			"HDD: "+hdd+"\n"+
			"Wi-Fi: "+wifi+"\n"+
			"Battery: "+battery+"\n"+
			"Optical drive: "+opticalDrive+"\n"+
			"Graphic card: "+graphicCard+"\n";
	}
}

class DataBaseCreater implements Serializable{
	
	public List<Laptop> createLaptops(int numOfLaptops) {
		LaptopGenerator gen = new LaptopGenerator();
		Laptop obj1 = new Laptop();
		List<Laptop> laptops = new ArrayList<>();
		
		for (int i=0; i < numOfLaptops; i++) {
			obj1.setId(gen.generateId());
			obj1.setNumOfProduct(gen.generateNumOfProduct());
			obj1.setName(gen.generateName());
			obj1.setManufacturedCompany(gen.generateManufacturedCompany());
			obj1.setProcessor(gen.generateProcessor());
			obj1.setRam(gen.generateRam());
			obj1.setHdd(gen.generateHdd());
			obj1.setWifi(gen.generateWifi());
			obj1.setBattery(gen.generateBattery());
			obj1.setOpticalDrive(gen.generateOpticalDrive());
			obj1.setGraphicCard(gen.generateGraphicCard());
			
			laptops.add(obj1);
		}
		return laptops;
	}
	
	public void serializator(List<Laptop>data) {
		String filePath = "C:\\Users\\Gwindblaid\\IdeaProjects\\untitled1\\src\\File.data";
		File file = new File(filePath);
		ObjectOutputStream outstream = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			if (fos != null) {
				outstream = new ObjectOutputStream(fos);
				outstream.writeObject(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (NotSerializableException e) {
			System.out.println("Class doesn't support serialization");
		} catch (IOException e) {
			System.err.println("e");
		} finally {
			try {
				if (outstream != null) {
					outstream.close();
				}
			} catch (IOException e) {
				System.err.println("Stream closer error");
			}
		}
	}

	public List<Laptop> deserializator() throws InvalidObjectException {
		String filePath = "C:\\Users\\Gwindblaid\\IdeaProjects\\untitled1\\src\\File.data";
		File file = new File(filePath);
		ObjectInputStream objectInputStream = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			List<Laptop> data = (List<Laptop>) objectInputStream.readObject();
			return data;
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found");
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (objectInputStream != null) {
					objectInputStream.close();
				}
			} catch (IOException e) {
				System.err.println("Stream closed error");
			}
		}
		throw new InvalidObjectException("Object doesn't be restore");
	}

	public void test() {
		LaptopGenerator gen = new LaptopGenerator();
		Laptop laptop = new Laptop();

		laptop.setId(gen.generateId());
		laptop.setNumOfProduct(gen.generateNumOfProduct());
		laptop.setName(gen.generateName());
		laptop.setManufacturedCompany(gen.generateManufacturedCompany());
		laptop.setProcessor(gen.generateProcessor());
		laptop.setRam(gen.generateRam());
		laptop.setHdd(gen.generateHdd());
		laptop.setWifi(gen.generateWifi());
		laptop.setBattery(gen.generateBattery());
		laptop.setOpticalDrive(gen.generateOpticalDrive());
		laptop.setGraphicCard(gen.generateGraphicCard());

		System.out.println(laptop.toString());
		String filePath = "C:\\Users\\Gwindblaid\\IdeaProjects\\untitled1\\src\\File.data";
		File file = new File(filePath);
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(laptop);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (NotSerializableException e) {
			System.out.println("Class can't be serializable!");
		} catch (IOException e) {
			System.out.println(e);
		}

		File file1 = new File(filePath);
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(file1);
			ois = new ObjectInputStream(fis);
			Laptop laptop1 = (Laptop) ois.readObject();
			System.out.println(laptop1.toString());
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found");
		} catch (IOException e) {
			System.err.println("e");
		}
	}
}

enum ID {
	LAPTOP,
	SMARTPHONE;
}

public class Base {

	public static void printList(List<Laptop> data) {
		for (Laptop a : data) {
			System.out.println(a.toString());
		}
	}

	public static void main(String[] args) throws InvalidObjectException {
		DataBaseCreater obj = new DataBaseCreater();
		List<Laptop> data = obj.createLaptops(5);

		obj.serializator(data);
		printList(data);
		System.out.println("//////////////////////////////////////");
		List<Laptop> deserializableData = obj.deserializator();
		printList(deserializableData);
		//obj.test();




	}
}
