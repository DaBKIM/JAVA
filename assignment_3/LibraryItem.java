package OOP_assignment_3;

public abstract class LibraryItem implements Comparable<Object>{

	private String id;
	private String title;
	private String author;
	private int availableUnits;
	
	public LibraryItem(String id, String title, String author,int availableUnits) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.availableUnits = availableUnits;
	}
	
	public int getAvailableUnits() {
		return availableUnits;
	}

	public void setAvailableUnits(int availableUnits) {
		this.availableUnits = availableUnits;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Title: " + title + "\n"+"ID: " + id + "\n"+ "Author: " + author + "\n"+"Units Available: "
				+ availableUnits + "\n"+"---------------------------\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		LibraryItem other = (LibraryItem) obj;
		return this.id.equals(other.id);
	}
	
	public int compareTo(Object obj){
		
		if(obj==null) throw new NullPointerException("The object is null.\n");
		if(this.getClass()!=obj.getClass()) throw new ClassCastException("The object is not of the same type.\n");
		LibraryItem other=(LibraryItem) obj;
		return this.id.compareTo(other.id);
	}
	
	public abstract boolean returnItem();
}
