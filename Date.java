
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class DataOfSmartphone implements Serializable{
	private int id;
	private int numOfProduct;
	private String name;
	private String manufacturedCompany;
	private String processor;
	private int ram;
	private int hdd;
	private boolean wifi;
	private String battery;
	private boolean camera;
	private int numOfSIM;

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

class DataOfLaptop implements Serializable{
	private int id;
	private int numOfProduct;
	private String name;
	private String manufacturedCompany;
	private String processor;
	private int ram;
	private int hdd;
	private boolean wifi;
	private String battery;
	private boolean opticalDrive;
	private String graphicCard;

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

class Creator extends SmartphoneGenerator {
	LaptopGenerator gen = new LaptopGenerator();

	public DataOfSmartphone createSmartphone() {
		DataOfSmartphone obj = new DataOfSmartphone();
		for (int i=0; i < 1;i++) {
			obj.setId(generateId());
			obj.setNumOfProduct(generateNumOfProduct());
			obj.setName(generateName());
			obj.setManufacturedCompany(generateManufacturedCompany());
			obj.setProcessor(generateProcessor());
			obj.setRam(generateRam());
			obj.setHdd(generateHdd());
			obj.setWifi(generateWifi());
			obj.setBattery(generateBattery());
			obj.setCamera(generateCamera());
			obj.setNumOfSIM(generateNumOfSIM());
			
			System.out.println(obj.toString());
		}
		return obj;
	}
	
	public DataOfLaptop createLaptop() {
		DataOfLaptop obj1 = new DataOfLaptop();
		for (int i=0; i < 1;i++) {
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
			
			System.out.println(obj1.toString());
		}
		return obj1;
	}
	
	public String getStringInformation() {
		DataOfSmartphone obj = new DataOfSmartphone();
		
		obj.setId(generateId());
		obj.setNumOfProduct(generateNumOfProduct());
		obj.setName(generateName());
		obj.setManufacturedCompany(generateManufacturedCompany());
		obj.setProcessor(generateProcessor());
		obj.setRam(generateRam());
		obj.setHdd(generateHdd());
		obj.setWifi(generateWifi());
		obj.setBattery(generateBattery());
		obj.setCamera(generateCamera());
		obj.setNumOfSIM(generateNumOfSIM());
		
		return obj.toString();
	}
	
	public void putInFile() throws IOException {
		String filePath = "/storage/emulated/0/AppProjects/CourseProject/src/File.txt";
		String smartphone = getStringInformation();
		File file = new File(filePath);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(smartphone);
		} catch (IOException e) {
			System.out.println("File write error");
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				System.out.println("Stream closed error");
			}
		}
		
		//System.out.println(smartphone);
	}
}

class Serializator {
	public boolean serialization(DataOfLaptop laptop, String filePath) {
		boolean flag = false;
		File f = new File(filePath);
		ObjectOutputStream ostream = null;
		try {
			FileOutputStream fos = new FileOutputStream(f);
			if (fos != null) {
				ostream = new ObjectOutputStream(fos);
				ostream.writeObject(laptop);
				flag = true;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File can't be create");
		} catch (NotSerializableException e) {
			System.out.println("Class doesn't support serialization");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (ostream != null) {
					ostream.close();
				}
			} catch (IOException e) {
				System.out.println("Stream closed error");
			}
		}
		return flag;
	}
	
	public DataOfLaptop desirealizator (String filePath) throws InvalidObjectException {
		File f = new File(filePath);
		ObjectInputStream istream = null;
		try {
			FileInputStream fis = new FileInputStream(f);
			istream = new ObjectInputStream(fis);
			DataOfLaptop obj = (DataOfLaptop) istream.readObject();
			System.out.println("object restore");
			return obj;
		} catch (ClassNotFoundException e) {
			System.out.println("Class doesn't exist"+e);
		} catch (FileNotFoundException e) {
			System.out.println("File for serialization not found");
		} catch (InvalidClassException e) {
			System.out.println("The discrepancy between the versions of the classes");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (istream != null) {
					istream.close();
				}
			} catch (IOException e) {
				System.out.println("Stream closed error");
			}
		}
		throw new InvalidObjectException("Object doesn't restore");
	}
}

public class Date {
	public static void main(String[] args) throws IOException {
		LaptopGenerator gen = new LaptopGenerator();
		List<DataOfLaptop> list = new ArrayList<>();
		for (int i=0; i < 10; i++) {
			DataOfLaptop laptop = new DataOfLaptop();
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
			list.add(laptop);
		}


		String filePath = "C:\\Users\\Gwindblaid\\IdeaProjects\\untitled1\\src\\File.data";
		File file = new File(filePath);
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			if (fos != null) {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (NotSerializableException e) {
			System.out.println("Class doesn't be serializable");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				System.out.println("Can't closed stream");
			}
		}

		System.out.println("/////////////////////////////////////////////////////////");

		String filePath1 = "C:\\Users\\Gwindblaid\\IdeaProjects\\untitled1\\src\\File.data";
		File file1 = new File(filePath1);
		ObjectInputStream ois = null;
		try {
			FileInputStream fis1 = new FileInputStream(file1);
			ois = new ObjectInputStream(fis1);
			List<DataOfLaptop> laptop1 = (List<DataOfLaptop>) ois.readObject();
			for (DataOfLaptop a :
					laptop1) {
				System.out.println(a.toString());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (InvalidClassException e) {
			System.out.println("The discrepancy between the versions of the classes");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				System.out.println("Stream can't be closed");
			}
		}
	}
}
