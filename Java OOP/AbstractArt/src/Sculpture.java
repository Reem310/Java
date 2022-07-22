
public class Sculpture extends Art {
	public String material;
	
	public void viewArt() {
		System.out.println("\n" + material + " Sculpture" + "\nTitle: " + title + "\nAuthor: " + author + "\nDescription: " + description);
	}
	public void setSculpture(String material, String title, String author, String description) {
		this.material = material;
		this.title = title;
		this.author = author;
		this.description = description;
		viewArt();
	}
}
