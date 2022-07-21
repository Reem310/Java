
public class Gorilla extends Mammal {
	
	public void throwSomething() {
		super.energyLevel -= 5;
		System.out.println("The gorilla has thrown something, so the energy level decreased by 5");
	}
	public void eatBananas() {
		super.energyLevel += 10;
		System.out.println("The gorilla is satisfied, so the energy level increased by 10");
	}
	public void climb() {
		super.energyLevel -= 10;
		System.out.println("The gorilla has climbed a tree, so the energy level decreased by 10");
	}
	
}
