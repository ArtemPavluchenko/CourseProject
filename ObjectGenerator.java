
interface Generator {

	int generateId();
}
interface GenetatorHumans extends Generator {

	String generateName();

	String generateSecondName();

	String generateSurname();

	String generateAdress();
}
interface GeneratorStudents extends GenetatorHumans {

	String generatePhoneNumber();

	String generateDateOfBirth();

	String generateInstitute();

	String generateDepartments();

	int generateCourse();
}
interface GeneratorCustomers extends GenetatorHumans {

	String generateCreditCardNum();

	String generateBancAccountNum();
}

interface GeneratorPatients extends GenetatorHumans {

	String generateMedicalCardNum();

	String generatePhoneNumber();

	String generateDiagnosis();
}

interface GneratorAbiturient extends GenetatorHumans {

	String generateMarks();

	String generatePhoneNumber();

}

interface GeneratorBooks extends Generator {
	
	String generateName();
	
	String generateAutor();
	
	String generatePublishing();
	
	int generatePublishingYear();
	
	int generateNumOfPages();
	
	int generatePrice();
	
	String generateTypeOfBinding();
	
}

interface GeneratorProduct extends Generator {
	int generateNumOfProduct();
}

interface GeneratorComputerEquipment extends GeneratorProduct {
	String generateName();
	String generateManufacturedCompany();
	String generateProcessor();
	int generateRam();
	int generateHdd();
	boolean generateWifi();
}

interface GeneratorPortableEquipment extends GeneratorComputerEquipment {
	String generateBattery();
}

interface GeneratorSmartphone extends GeneratorPortableEquipment {
	boolean generateCamera();
	int generateNumOfSIM();
}

interface GeneratorLaptop extends  GeneratorPortableEquipment {
	boolean generateOpticalDrive();
	String generateGraphicCard();
}

class LaptopGenerator implements GeneratorLaptop {
	private String[] videoCards = {"GeForce GTX Titan 8068", "GeForce GTX 780 7960", "Radeon R9 290X 7494",
			"GeForce GTX 770 6263", "GeForce GTX 680 5711", "Radeon HD 7990 5515", "GeForce GTX 670 5376",
			"Radeon HD 7970 / R9 280X 5210", "GeForce GTX 690 5154", "Radeon HD 7970 / R9 280 5091",
			"GeForce GTX 760 5006", "GeForce GTX 580 4944", "GeForce GTX 660 Ti 4697", "Radeon HD 7950 4631",
			"Radeon R9 270X 4533", "FirePro W8000 4533", "GeForce GTX 570 4393"};
	private String[] batares = {"0B20-00KC0AS", "70-NTS1B2000Z", "90-NLF1B2000Z	A32-T12J", "CL1338B.806", "11-1108",
			"70-NUS1B1000Z", "90-NQK1B1000Y", "A32-T13", "11-1132", "70-NV32B1000Z", "90-NVD1B1000Y", "A32-UL20",
			"CL1823B.806", "11-1145", "70-NWF1B1000Z", "90-NWF1B2000Y", "A32-X50", "CL1936B.806", "11-1151",
			"70-NX01B1000Z"};
	private String[] manufacturedCompany = {
			"Acer", "Apple", "ASUS", "Dell", "Fujitsu", "Gateway", "HCL", "Hewlett-Packard", "Lenovo", "LG", "MSI",
			"Panasonic", "Samsung", "Sony", "Toshiba"};
	private String[] laptopsName = {"qI7O4semQ3", "PjRjgm133U", "Fs3dCnK9Y7", "5BKKTFV0yn", "b0RDDC5RKA", "y6y7xkzmkt",
			"cp8yKJAqq1", "RhClVxE7lz", "93d84SFuqi", "Fk5sQrwdRO", "FzuAvuz2WJ", "OfqLulamKZ", "P1kS0AIUUw",
			"8HpcEX8k7B", "AMi4Vpdu79", "89hQC4o6R4", "xnxC62tUpA", "k2JHjjX99N", "vithOyV5tY", "GEueBOQwrn",
			"AmgMGa9Aeo", "lF1p93Gzty", "G1Q3UxMG1r", "kT2DxnuXyo", "2bzflHslwU", "sV88pYRaLd", "bckxafPt8m",
			"zmOvUActIg", "zKGW6Pm4qp", "rOpYWtzQNM", "b35IBjePbs", "u75UEQF396", "lm3KIbbz9f", "4JkWSjde6h",
			"uU9R9FGrye", "JKhbzMqM6B", "ABeJtQIENd", "YpgtqVnkRy", "liPWly8OGe", "wyIZA0DCbo", "j1BMfFlAo",
			"Q9m7wAvWwb", "ai7IqBeL9n", "2ar2TJr1V3", "F00TYbyrGl", "LEBNqIfOQn", "Xw86iyzpIA"};
	private String[] cpuNames = {"Intel® Core™ i7 Extreme Edition", "Intel® Core™ i7", "Intel® Core™2 Extreme",
			"Intel® Core™2 Quad", "Intel® Core™2 Duo", "Intel® Pentium®", "Intel® Celeron®", "Intel® Atom™",
			"Intel® Xeon® 7000", "Intel® Xeon® 5000", "Intel® Xeon® 3000"};

	@Override
	public boolean generateOpticalDrive() {
		int i  = (int)(Math.random()*2);
		if (i == 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String generateGraphicCard() {
		String videoCard = videoCards[(int)(Math.random()*videoCards.length)];
		return videoCard;
	}

	@Override
	public String generateBattery() {
		String battery = batares[(int)(Math.random()*batares.length)];
		int bat = (int)(Math.random()*20)+25;
		int capacity = bat*100;
		battery += " "+capacity+" mAh";
		return battery;
	}

	@Override
	public String generateName() {
		String laptopName = laptopsName[(int)(Math.random()*laptopsName.length)];
		return laptopName;
	}

	@Override
	public String generateManufacturedCompany() {
		String company = manufacturedCompany[(int)(Math.random()*manufacturedCompany.length)];
		return company;
	}

	@Override
	public String generateProcessor() {
		String cpu = cpuNames[(int)(Math.random()*cpuNames.length)];
		return cpu;
	}

	@Override
	public int generateRam() {
		int frequency = (int)(Math.random()*4)+2;
		return frequency;
	}

	@Override
	public int generateHdd() {
		int hdd = (int)(Math.random()*5)+4;
		int hDD = hdd * 100;
		return hDD;
	}

	@Override
	public boolean generateWifi() {
		return true;
	}

	@Override
	public int generateNumOfProduct() {
		int num = (int)(Math.random()*19)+10;
		return num;
	}

	@Override
	public int generateId() {
		return 1;
	}
}

class SmartphoneGenerator implements GeneratorSmartphone {
	private String[] batares = {"0B20-00KC0AS", "70-NTS1B2000Z", "90-NLF1B2000Z	A32-T12J", "CL1338B.806", "11-1108",
			"70-NUS1B1000Z", "90-NQK1B1000Y", "A32-T13", "11-1132", "70-NV32B1000Z", "90-NVD1B1000Y", "A32-UL20",
			"CL1823B.806", "11-1145", "70-NWF1B1000Z", "90-NWF1B2000Y", "A32-X50", "CL1936B.806", "11-1151",
			"70-NX01B1000Z"};
	private String[] smartphoneManufacturer = {"Samsung Electronics", "Apple", "Huawei", "Lenovo", "LG", "Xiaomi",
			"BBK", "TCL", "Oppo", "ZTE", "Sony", "Microsoft", "Meizu", "Coolpad"};

	private String[] cpuNames = {"Intel® Core™ i7 Extreme Edition", "Intel® Core™ i7", "Intel® Core™2 Extreme",
			"Intel® Core™2 Quad", "Intel® Core™2 Duo", "Intel® Pentium®", "Intel® Celeron®", "Intel® Atom™",
			"Intel® Xeon® 7000", "Intel® Xeon® 5000", "Intel® Xeon® 3000"};
	private String[] smartphonesName = {"qI7O4semQ3", "PjRjgm133U", "Fs3dCnK9Y7", "5BKKTFV0yn", "b0RDDC5RKA", "y6y7xkzmkt",
			"cp8yKJAqq1", "RhClVxE7lz", "93d84SFuqi", "Fk5sQrwdRO", "FzuAvuz2WJ", "OfqLulamKZ", "P1kS0AIUUw",
			"8HpcEX8k7B", "AMi4Vpdu79", "89hQC4o6R4", "xnxC62tUpA", "k2JHjjX99N", "vithOyV5tY", "GEueBOQwrn",
			"AmgMGa9Aeo", "lF1p93Gzty", "G1Q3UxMG1r", "kT2DxnuXyo", "2bzflHslwU", "sV88pYRaLd", "bckxafPt8m",
			"zmOvUActIg", "zKGW6Pm4qp", "rOpYWtzQNM", "b35IBjePbs", "u75UEQF396", "lm3KIbbz9f", "4JkWSjde6h",
			"uU9R9FGrye", "JKhbzMqM6B", "ABeJtQIENd", "YpgtqVnkRy", "liPWly8OGe", "wyIZA0DCbo", "j1BMfFlAo",
			"Q9m7wAvWwb", "ai7IqBeL9n", "2ar2TJr1V3", "F00TYbyrGl", "LEBNqIfOQn", "Xw86iyzpIA"};

	@Override
	public boolean generateCamera() {
		return true;
	}

	@Override
	public int generateNumOfSIM() {
		int sim = (int)(Math.random()*2)+1;
		return sim;
	}

	@Override
	public String generateBattery() {
		String battery = batares[(int)(Math.random()*batares.length)];
		int bat = (int)(Math.random()*13)+18;
		int capacity = bat*100;
		battery += " "+String.valueOf(capacity)+" mAh";
		return battery;
	}

	@Override
	public String generateName() {
		String laptopName = smartphonesName[(int)(Math.random()*smartphonesName.length)];
		return laptopName;
	}

	@Override
	public String generateManufacturedCompany() {
		String manufacturer = smartphoneManufacturer[(int)(Math.random()*smartphoneManufacturer.length)];
		return manufacturer;
	}

	@Override
	public String generateProcessor() {
		String cpu = cpuNames[(int)(Math.random()*cpuNames.length)];
		return cpu;
	}

	@Override
	public int generateRam() {
		int frequency = (int)(Math.random()*3)+1;
		return frequency;
	}

	@Override
	public int generateHdd() {
		int hdd = (int)(Math.random()*5)+4;
		int hDD = hdd * 10;
		return hDD;
	}

	@Override
	public boolean generateWifi() {
		return true;
	}

	@Override
	public int generateNumOfProduct() {
		int num = (int)(Math.random()*19)+10;
		return num;
	}

	@Override
	public int generateId() {
		return 2;
	}
}

interface GeneratorGems extends Generator {
	
	int generateWeight();
	
}
	class StudentGenerator implements GeneratorStudents {
		private String[] mansFirstName = {"Александр", "Максим", "Иван", "Артём", "Никита", "Дмитрий", "Егор", "Даниил",
				"Михаил", "Андрей", "Алексей", "Илья", "Кирилл", "Сергей", "Владислав", "Роман", "Владимир", "Тимофей",
				"Матвей", "Георгий", "Николай", "Павел", "Арсений", "Денис", "Степан", "Фёдор", "Данила", "Антон",
				"Константин", "Глеб", "Ярослав", "Григорий", "Игорь", "Евгений", "Тимур", "Руслан", "Пётр", "Олег",
				"Вадим", "Василий", "Вячеслав", "Виктор", "Юрий", "Артемий", "Леонид", "Давид", "Марк", "Лев", "Семён",
				"Артур"};
		private String[] surname = {"Иванов", "Васильев", "Петров",
				"Смирнов", "Михайлов", "Фёдоров", "Соколов", "Яковлев", "Попов", "Андреев", "Алексеев", "Александров",
				"Лебедев", "Григорьев", "Степанов", "Семёнов", "Павлов", "Богданов", "Николаев", "Дмитриев", "Егоров",
				"Волков", "Кузнецов", "Никитин", "Соловьёв", "Тимофеев", "Орлов", "Афанасьев", "Филиппов", "Сергеев",
				"Захаров", "Матвеев", "Виноградов", "Кузьмин", "Максимов", "Козлов", "Ильин", "Герасимов", "Марков",
				"Новиков", "Морозов"};
		private String[] secondName = {"Александрович", "Адамович", ",Анатольевич", "Аркадьевич", "Алексеевич",
				"Андреевич", "Артемович", "Альбертович", "Антонович", "Богданович", "Богуславович", "Борисович",
				"Вадимович", "Васильевич", "Владимирович", "Валентинович", "Вениаминович", "Вячеславович", "Валерьевич",
				"Викторович", "Геннадиевич", "Георгиевич", "Геннадьевич", "Григорьевич", "Давидович", "Денисович",
				"Данилович", "Дмитриевич", "Евгеньевич", "Егорович", "Ефимович", "Иванович", "Ильич", "Игоревич",
				"Иосифович", "Кириллович", "Константинович", "Леонидович", "Львович", "Макарович", "Максович",
				"Миронович", "Максимович", "Матвеевич", "Михайлович", "Натанович", "Наумович", "Николаевич", "Олегович",
				"Оскарович", "Павлович", "Петрович", "Платонович", "Робертович", "Ростиславович", "Рудольфович",
				"Романович", "Рубенович", "Русланович", "Святославович", "Сергеевич", "Степанович", "Семенович",
				"Станиславович", "Тарасович", "Тимофеевич", "Тимурович", "Федорович", "Феликсович", "Филиппович",
				"Харитонович", "Эдуардович", "Эмануилович", "Эльдарович", "Юрьевич", "Юхимович", "Яковлевич",
				"Ярославович"};
		private String[] mounth = {"Января", "Февраля", "Марта", "Мая", "Апреля", "Июня", "Июля", "Августа", "Сентября",
				"Октября", "Ноября", "Декабря"};
		private int code[] = {39, 50, 63, 66, 67, 68, 91, 92, 93, 94, 95, 96, 97, 98, 99};
		private String[] streets = {"Академика Курчатова", "Академика Павлова", "Академика Панкратовой",
				"Академика Филатова", "Албанская", "Александра Матросова", "Балашева", "Балковский", "Балтская дорога",
				"Балышевa", "Баранова", "Бассейная", "Глухая", "Гогелевская", "Гоголя", "Головковская", "Гончарова",
				"Днепропетровская", "Днестровская", "Добролюбова", "Довженко", "Доковая", "Долгая", "Долинская",
				"Донецкая"};
		private String[] institutes = {"Институт информационно-диагностических систем",
				"Аэрокосмический институт", "Институт аэрокосмических систем управления",
				"Институт экологической безопасности", "Институт экономики и менеджмента",
				"Юридический институт", "Институт доуниверситетской подготовки",
				"Гуманитарный Институт", "Институт ICAO", "Институт заочного и дистанционного обучения",
				"Институт новейших технологий", "Институт последипломного обучения",
				"Институт землеустройства и информационных технологий", "Институт международных отношений",
				"Житомирский военный институт им.С.П.Королева", "Институт аэронавигации", "Институт аэропортов"};
		private String[] departments = {"Факультет летательных аппаратов", "Факультет лингвистики",
				"Факультет психологии и социологии", "Факультет авиационных транспортных технологий",
				"Факультет экономики и предпринимательства", "Факультет менеджмента и логистики",
				"Факультет электроники", "Факультет аэрокосмических систем управления",
				"Факультет информационных технологий", "Факультет телекоммуникаций и защиты информации",
				"Факультет компьютерных наук", "Факультет компьютерных систем",
				"Факультет международных экономических отношений", "Факультет международной информации и права",
				"Факультет аэропортов", "Факультет архитектуры и дизайна", "Факультет экологической безопасности"};

		public String generateName() {
			String name = mansFirstName[(int) (Math.random() * mansFirstName.length)];
			return name;
		}

		public String generateSecondName() {
			String name = secondName[(int) (Math.random() * secondName.length)];
			return name;
		}

		public String generateSurname() {
			String name = surname[(int) (Math.random() * surname.length)];
			return name;
		}

		public String generateDateOfBirth() {
			String day;
			String mounths;
			int m = (int) (Math.random() * 11) + 1;
			if (m < 10) {
				mounths = "0" + String.valueOf(m);
			} else {
				mounths = String.valueOf(m);
			}
			int d;

			if (m == 2) {
				d = (int) (Math.random() * 28) + 1;
			} else {
				d = (int) (Math.random() * 30) + 1;
			}
			if (d < 10) {
				day = "0" + String.valueOf(d);
			} else {
				day = String.valueOf(d);
			}
			int y = (int) (Math.random() * 10) + 1988;
			String year = String.valueOf(y);
			String date = day + "." + mounths + "." + year;
			return date;
		}

		public String generatePhoneNumber() {
			String code = String.valueOf(this.code[(int) (Math.random() * this.code.length)]);
			String num = String.valueOf((int) (Math.random() * 9000000) + 1000000);
			String phoneNumber = "0" + code + " " + num;
			return phoneNumber;
		}

		public String generateAdress() {
			int apartment = (int) (Math.random() * 98) + 1;
			int streetNum = (int) (Math.random() * 38) + 1;
			String street = "Ул. " + streets[(int) (Math.random() * streets.length)] + " " + streetNum + " Кв. " + apartment;
			return street;
		}

		public String generateInstitute() {
			String institute = institutes[(int) (Math.random() * institutes.length)];
			return institute;
		}

		public String generateDepartments() {
			String department = departments[(int) (Math.random() * departments.length)];
			return department;
		}

		public int generateCourse() {
			int course = (int) (Math.random() * 6) + 1;
			return course;
		}

		public int generateId() {
			int id = (int) (Math.random() * 90000000) + 10000000;
			return id;
		}
	}

	class BookGernerator extends StudentGenerator implements GeneratorBooks {
		private String[] books = {"Властелин колец", "Гордость и предубеждение", "Тёмные начала",
			"Автостопом по галактике", "Гарри Поттер и Кубок огня", "Убить пересмешника", "Винни Пух", "1984",
			"Лев, колдунья и платяной шкаф", "Джейн Эйр", "Уловка-22", "Грозовой перевал", "Пение птиц", "Ребекка",
			"Над пропастью во ржи", "Ветер в ивах", "Большие надежды", "Маленькие женщины»",
			"Мандолина капитана Корелли", "Война и мир", "Унесённые ветром", "Гарри Поттер и философский камень",
			"Гарри Поттер и Тайная комната", "Гарри Поттер и узник Азкабана", "Поющие в терновнике",
			"Тэсс из рода д’Эрбервиллей", "Миддлмарч", "Гроздья гнева", "Алиса в Стране чудес", "Дневник Трейси Бикер"};
		private String[] publishings = {"Аванта +", "Азбука", "АКВИЛЕГИЯ-М", "Арка", "АСТ", "АСТ-ПРЕСС", "Белый Город",
				"Время"};
		private String[] typesOfBindings = {"цельнокартонный обрезной", "цельнокартонный с кантом",
		"цельнотканевый мягкий обрезной", "цельнобумажный жесткий с кантом",
		"составной с тканевым корешком и со сторонками, крытыми обложечной бумагой", "цельнотканевый мягкий с кантом",
		"цельнотканевый жесткий с кантом",
		"составной с кантом, со сторонками, крытыми одним видом ткани, и с корешком из др. вида ткани",
		"пластмассовый жёсткий из двух слоёв эластичного пластика, между которыми проложены картонные сторонки",
		"пластмассовый мягкий из одного слоя эластичного пластика"};
		private String[] autors = {"Дж. Р. Р. Толкин", "Джордж Р. Р. Мартин", "Патрик Ротфусс",
				"Аркадий и Борис Стругацкие", "Дэн Симмонс", "Жюль Верн", "Анджей Сапковский", "Брендон Сандерсон",
				"Владислав Крапивин", "Павел Бажов", "Лазарь Лагин", "Фрэнк Герберт", "Джо Аберкромби", "Джон Уиндэм",
				"Станислав Лем", "Нил Стивенсон", "Герберт Уэллс", "Рэй Брэдбери", "Дж. К. Ролинг", "Роджер Желязны",
				"Генри Каттнер", "Гай Гэвриел Кей", "Роберт Хайнлайн", "Кир Булычев", "Владимир Обручев", "Мэри Стюарт",
				"Орсон Скотт Кард", "Джонатан Страуд", "Клиффорд Саймак"};
		@Override
		public String generateAutor() {
			String autor = autors[(int)(Math.random()*autors.length)];
			return autor;
		}

		@Override
		public String generateName() {
			String name = books[(int)(Math.random()*books.length)];
			return name;
		}

		@Override
		public int generateNumOfPages() {
			int pages = (int)(Math.random()*500)+100;
			return pages;
		}

		@Override
		public int generatePrice() {
			int price = (int)(Math.random()*900)+100;
			return price;
		}

		@Override
		public String generatePublishing() {
			String publishing = publishings[(int)(Math.random()*publishings.length)];
			return publishing;
		}

		@Override
		public int generatePublishingYear() {
			int publishingYear = (int)(Math.random()*100)+1900;
			return publishingYear;
		}

		@Override
		public String generateTypeOfBinding() {
			String typeOfBinding = typesOfBindings[(int)(Math.random()*typesOfBindings.length)];
			return typeOfBinding;
		}
	}

class ObjectGenerator implements Generator{
	public int generateId() {
		int id = (int) (Math.random() * 90000000) + 10000000;
		return id;
	}
}

