//package ArtemPavluchenko.DataBase;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.LinkedList;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.NotSerializableException;
import java.io.InvalidObjectException;
import java.util.*;

abstract class Product implements Serializable{
	private static final long serialVersionUID = 1234567890L;
	protected ID id;
	protected int price;
}

abstract class ComputerEquipment extends Product {
	protected String manufacturedCompany;
	protected String processor;
	protected String OS;
	protected int ram;
	protected int hdd;
	
}

abstract class PortableEquipment extends ComputerEquipment {
	protected int battery;
}

class Smartphone extends PortableEquipment {
	protected boolean camera;
	protected int numOfSIM;
	
	public void setId(ID id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setOS(String OS) {
		this.OS = OS;
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

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public void setNumOfSIM(int numOfSim) {
		this.numOfSIM = numOfSim;
	}
	
	public ID getID() {
		return id;
	}
	
	public String getManufacturedCompany() {
		return manufacturedCompany;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getProcessor() {
		return processor;
	}
	
	public String gerOS() {
		return OS;
	}
	
	public int getRam() {
		return ram;
	}
	
	public int getHdd() {
		return hdd;
	}
	
	public int getBarrety() {
		return battery;
	}
	
	public boolean getCamera() {
		return camera;
	}
	
	public int getNumOfSIM() {
		return numOfSIM;
	}

	@Override
	public String toString() {
		return "Id "+id+"\n"+
			"Price: "+price+" UAH\n"+
			"Manufactured company: "+manufacturedCompany+"\n"+
			"OS: "+OS+"\n"+
			"Processor inside: "+processor+"\n"+
			"RAM: "+ram+"\n"+
			"HDD: "+hdd+"\n"+
			"Battery: "+battery+" mAh"+"\n"+
			"Camera: "+camera+"\n"+
			"Number of SIMcard: "+numOfSIM+"\n";
	}
}

class Laptop extends PortableEquipment {
	protected boolean opticalDrive;
	protected String graphicCard;
	
	public void setId(ID id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setOS(String OS) {
		this.OS = OS;
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


	public void setBattery(int battery) {
		this.battery = battery;
	}

	public void setOpticalDrive(boolean opticalDrive) {
		this.opticalDrive = opticalDrive;
	}

	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}
	
	public ID getID() {
		return id;
	}

	public String getManufacturedCompany() {
		return manufacturedCompany;
	}

	public int getPrice() {
		return price;
	}

	public String getProcessor() {
		return processor;
	}

	public String getOS() {
		return OS;
	}

	public int getRam() {
		return ram;
	}

	public int getHdd() {
		return hdd;
	}

	public int getBarrety() {
		return battery;
	}
	
	public boolean getOpticalDrive() {
		return opticalDrive;
	}
	
	public String getGraphicCard() {
		return graphicCard;
	}

	@Override
	public String toString() {
		return "Id "+id+"\n"+
			"Price: "+price+" UAH\n"+
			"Manufactured company: "+manufacturedCompany+"\n"+
			"OS: "+OS+"\n"+
			"Processor inside: "+processor+"\n"+
			"RAM: "+ram+"\n"+
			"HDD: "+hdd+"\n"+
			"Battery: "+battery+" mAh"+"\n"+
			"Optical drive: "+opticalDrive+"\n"+
			"Graphic card: "+graphicCard+"\n";
	}
}
////////////////////////////////////////////////////////////////////////////
class DataBaseCreater {

	public List<Laptop> createLaptopsDB(int numOfLaptops) {
		List<Laptop> data = new ArrayList<>();
		LaptopGenerator gen = new LaptopGenerator();
		
		for (int i=0; i < numOfLaptops; i++) {
			Laptop obj1 = new Laptop();
			obj1.setId(ID.LAPTOP);
			obj1.setPrice(gen.generatePrice());
			obj1.setManufacturedCompany(gen.generateManufacturedCompany());
			obj1.setOS(gen.generateOS());
			obj1.setProcessor(gen.generateProcessor());
			obj1.setRam(gen.generateRam());
			obj1.setHdd(gen.generateHdd());
			obj1.setBattery(gen.generateBattery());
			obj1.setOpticalDrive(gen.generateOpticalDrive());
			obj1.setGraphicCard(gen.generateGraphicCard());

			data.add(obj1);
		}
		return data;
	}
	
	public List<Smartphone> greateSmartphonesDB(int numOfSmartphones) {
		List<Smartphone> data = new ArrayList<>();
		SmartphoneGenerator gen1 = new SmartphoneGenerator();
		
		for (int i=0; i < numOfSmartphones; i++) {
			Smartphone obj1 = new Smartphone();
			obj1.setId(ID.SMARTPHONE);
			obj1.setPrice(gen1.generatePrice());
			obj1.setManufacturedCompany(gen1.generateManufacturedCompany());
			obj1.setOS(gen1.generateOS());
			obj1.setProcessor(gen1.generateProcessor());
			obj1.setRam(gen1.generateRam());
			obj1.setHdd(gen1.generateHdd());
			obj1.setBattery(gen1.generateBattery());
			obj1.setCamera(gen1.generateCamera());
			obj1.setNumOfSIM(gen1.generateNumOfSIM());

			data.add(obj1);
		}
		return data;
	}

	public List<Product> createProductsDB(int numOfLaptops,int numOfSmartphones) {
		List<Product> data = new ArrayList<>();
		data.addAll(greateSmartphonesDB(numOfSmartphones));
		data.addAll(createLaptopsDB(numOfLaptops));

		return data;
	}
	
	public void serializator(List data) {
		String filePath = "/storage/emulated/0/AppProjects/CourseProject/src/File.data";
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
		String filePath = "/storage/emulated/0/AppProjects/CourseProject/src/File.data";
		File file = new File(filePath);
		ObjectInputStream objectInputStream = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			List<Laptop>  data = (List<Laptop>) objectInputStream.readObject();
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
}
////////////////////////////////////////////////////////////////////////////
enum ID {
	LAPTOP("Laptop"),
	SMARTPHONE("Smartphone");
	
	private final String idName;
	
	ID(String idName) {
		this.idName = idName;
	}
	
	public String getIdName() {
		return idName;
	}
	
	public static ID byIdName(String idName) {
		for (ID id: ID.values()) {
			if (Objects.equals(id.getIdName(), idName)) {
				return id;
			}
		}
		throw new IllegalArgumentException("no such id with name: "+idName);
	}

	@Override
	public String toString() {
		return idName;
	}
}

enum Criterions {
	COMPANY,
	PRICE,
	CPU,
	OS,
	RAM,
	HDD,
	BATTERY,
	CAMERA,
	NUM_OF_SIM,
	OPTICAL_DRIVE,
	GRAPHIC_CARD;
}

class CriterionsSorted {

	private static Comparator<Laptop> lComparatorByCompany = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			return o1.getManufacturedCompany().compareTo(o2.getManufacturedCompany());
		}
	};

	private static Comparator<Laptop> lComparatorByCPU = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			return o1.getProcessor().compareTo(o2.getProcessor());
		}
	};

	private static Comparator<Laptop> lComparatorByOS = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			return o1.getOS().compareTo(o2.getOS());
		}
	};

	private static Comparator<Laptop> lComparatorByGraphicCard = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			return o1.getGraphicCard().compareTo(o2.getGraphicCard());
		}
	};

	private static Comparator<Laptop> lComparatorByPrice = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			if (o1.getPrice() > o2.getPrice()) {
				return 1;
			} else if (o1.getPrice() < o2.getPrice()) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	private static Comparator<Laptop> lComparatorByRAM = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			if (o1.getRam() > o2.getRam()) {
				return 1;
			} else if (o1.getRam() < o2.getRam()) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	private static Comparator<Laptop> lComparatorByHDD = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			if (o1.getHdd() > o2.getHdd()) {
				return 1;
			} else if (o1.getHdd() < o2.getHdd()) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	private static Comparator<Laptop> lComparatorByBattery = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			if (o1.getBarrety() > o2.getBarrety()) {
				return 1;
			} else if (o1.getBarrety() < o2.getBarrety()) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	private static Comparator<Laptop> lComparatorByOpticalDrive = new Comparator<Laptop>() {
		@Override
		public int compare(Laptop o1, Laptop o2) {
			if (o1.getOpticalDrive() == false && o2.getOpticalDrive() == true) {
				return 1;
			} else if (o1.getOpticalDrive() == true && o2.getOpticalDrive() == false) {
				return -1;
			} else {
				return 0;
			}
		}
	};



	public static void LaptopSorted(List dataBase, Criterions criterion) {



		if (criterion == Criterions.COMPANY) {
			Collections.sort(dataBase, lComparatorByCompany);
		} else if (criterion == Criterions.CPU) {
			Collections.sort(dataBase, lComparatorByCPU);
		} else if (criterion == Criterions.PRICE) {
			Collections.sort(dataBase, lComparatorByPrice);
		} else  if (criterion == Criterions.RAM) {
			Collections.sort(dataBase, lComparatorByRAM);
		} else if (criterion == Criterions.HDD) {
			Collections.sort(dataBase,lComparatorByHDD);
		} else if (criterion == Criterions.OS) {
			Collections.sort(dataBase, lComparatorByOS);
		} else if (criterion == Criterions.BATTERY) {
			Collections.sort(dataBase, lComparatorByBattery);
		} else  if (criterion == Criterions.OPTICAL_DRIVE) {
			Collections.sort(dataBase, lComparatorByOpticalDrive);
		} else if (criterion == Criterions.GRAPHIC_CARD) {
			Collections.sort(dataBase, lComparatorByGraphicCard);
		}
	}

	public static void LaptopSorted(List<Laptop> dataBase, Criterions firstCriterion, Criterions secondCriterion) {
		LaptopSorted(dataBase, firstCriterion);
		LaptopSorted(dataBase, secondCriterion);
	}
}


////////////////////////////////////////////////////////////////////////////
public class Base {
	
	public static void printList(List<Laptop> data) {
		for (Laptop a : data) {
			System.out.println(a.toString());
		}
	}
	
	public static void main(String[] args) throws InvalidObjectException {
		DataBaseCreater obj = new DataBaseCreater();
		List<Laptop> data = obj.createLaptopsDB(5);
		System.out.println(data.get(0).getClass());
		Laptop oble = new Laptop();

		if (data.get(0).getClass() == oble.getClass()) {
			System.out.println(1);
		}
//		obj.serializator(data);
//		printList(data);
//
//		System.out.println("//////////////////////////////////////");
//
//		List<Laptop> deserializableData = obj.deserializator();
//		printList(deserializableData);
//
//		CriterionsSorted.LaptopSorted(deserializableData, Criterions.OPTICAL_DRIVE);
//		System.out.println("//////////////////////////////////////");
//		printList(deserializableData);
	}
}
