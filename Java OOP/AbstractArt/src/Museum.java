
public class Museum {

	public static void main(String[] args) {
		
		//Create 3 instances of Painting
		Painting painting1 = new Painting();
		Painting painting2 = new Painting();
		Painting painting3 = new Painting();
		System.out.println("The Paintings:");
		painting1.setPainting("Oil","title1","author1","desc1");
		painting2.setPainting("Watercolor","title2","author2","desc2");
		painting3.setPainting("Acrylic","title3","author3","desc3");
		System.out.println("\n<---------------------------------------------------->");
		//Create 2 instances of Scupture
		Sculpture sculpture1 = new Sculpture();
		Sculpture sculpture2 = new Sculpture();
		System.out.println("\nThe Sculptures:");
		sculpture1.setSculpture("Marble","title1","author1","desc1");
		sculpture2.setSculpture("Bronze","title2","author2","desc2");
	}
}
