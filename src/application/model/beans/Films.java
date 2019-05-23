package application.model.beans;

public class Films {
	
	public Films(int id, String titre, String genre) {
		super();
	this.id = id;
	this.titre = titre;
	this.genre = genre;
	}
	
	private int id;
	private String titre;
	private String genre;
	
	public Films() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}