
public class Painting extends Art {
	public String paintType;
	
	public void viewArt() {
		System.out.println("\n" + paintType + " Painting" + "\nTitle: " + title + "\nAuthor: " + author + "\nDescription: " + description);
	}
	public void setPainting(String paintType, String title, String author, String description) {
		this.paintType = paintType;
		this.title = title;
		this.author = author;
		this.description = description;
		viewArt();
	}
}

