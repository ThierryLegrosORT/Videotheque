package application.model.beans;

public class Films {
	
	private int annee;
	private int id;
	private String titre;
	private String genre;

	public Films(int id, String titre, String genre, int annee) {
		super();
	this.id = id;
	this.titre = titre;
	this.genre = genre;
	this.annee = annee;
	}
		
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "id: " + id + ", " + titre + ", " + genre+", année: "+annee;
	}
		
}