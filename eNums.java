
import java.util.*;
import java.sql.*;

enum Criterions1 {
	COMPANY,
	CPU,
	OS,
	RAM,
	HDD,
	BATTERY,
	CAMERA,
	NUMOFSIM,
	OD,
	GC;
}

class Lap {

	
	
	private String simp;
	private int x;
	
	public void setSimple(String simp) {
		this.simp = simp;
	}
	
	public void setX (int x) {
		this.x = x;
	}
	
	public String getCpu() {
		return simp;
	}
	
	public int getX() {
		return x;
	}

	@Override
	public String toString() {
		return "Simple: "+simp+"\n"+
		"x = "+x;
	}
}

class LapCpuComparator implements Comparator<Lap>
{

	@Override
	public int compare(Lap p1, Lap p2)
	{
		// TODO: Implement this method
		return 0;
	}


}

class LapXComparator implements Comparator<Lap>
{

	@Override
	public int compare(Lap p1, Lap p2)
	{
		// TODO: Implement this method
		return 0;
	}
}

class Gener {
	public String randomCpu() {
			
		return null;
	}

	public int randomX() {
		
		return 0;
	}
	
}

public class eNums {
	
	public static void main(String[] args) {
		Comparator<Lap> comparatorCpu = new LapCpuComparator();
		Comparator<Lap> comparatorX = new LapXComparator();
		List<Lap> laps = new ArrayList<>();
		
		
	}
}

