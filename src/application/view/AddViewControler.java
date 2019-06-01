package application.view;

import application.model.beans.Films;
import application.model.dao.FilmsDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddViewControler {
	@FXML
	private TextField tfTitre;
	@FXML
	private TextField tfGenre;
	@FXML
	private TextField tfAnnee;
	@FXML
	private Button valider;
	@FXML
	private Button annuler;
	private ObservableList<Films> flm;
	
	public void setFilm(ObservableList<Films> flm) {
		this.flm = flm;
	}
	
	public void valider() {
		String titre = tfTitre.getText();
		String genre = tfGenre.getText();
		int annee = Integer.valueOf(tfAnnee.getText());
		
		try {
			
			// On créé un objet Films et on lui passe les paramètres
			Films film = new Films();
			film.setTitre(titre);
			film.setGenre(genre);
			film.setAnnee(annee);
			
			FilmsDAO insertFilm = new FilmsDAO();
			insertFilm.create(film);
			flm.add(film);
			Stage stage = (Stage) valider.getScene().getWindow();
			stage.close();
		}
		catch(Exception e) {
			//System.out.println("Error: "+e.getLocalizedMessage());
		}
	}
	
	public void annuler() {
		System.out.println("Closing...");
		Stage stage = (Stage) annuler.getScene().getWindow();
		stage.close();
	}

}

