package ZooKeeper;

public class Mammal {
	protected int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println("The gorilla energy level --> " + energyLevel);
		return energyLevel;
	}
	
}
