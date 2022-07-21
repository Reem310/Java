package ZooKeeper;

public class Bat extends Mammal{
	public Bat() {
		this.energyLevel = 300;
		super.displayEnergy();

	}
	public void fly() {
		energyLevel -= 50;
		System.out.println("The the sound a bat taking off , so the energy level decreased by 50");
		super.displayEnergy();
	}
	public void eatHumans() {
		energyLevel += 25;
		System.out.println("so- well, a human was eated, so the energy level just increased by 25");
		super.displayEnergy();
	}
	public void attackTown() {
		energyLevel -= 100;
		System.out.println("The sound of a town on fire, the energy level just decreased by 100");
		super.displayEnergy();
	}
	
}
