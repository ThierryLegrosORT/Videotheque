package application.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import application.model.beans.Films;
import application.model.dao.FilmsDAO;

public class mainGUIControler {
	
	@FXML
	private Button search;
	@FXML
	private Button close;
	@FXML
	private TextField tf;
	@FXML
	private Label titre;
	private ObservableList<Films> cherche;
	
	public void fillView(ArrayList<Films> f) {
		titre.setText(f.toString());
		//genre.setText(f.toString());
	}
	
	public void cchfilm(ObservableList<Films> cherche) {
		this.cherche = cherche;
	}
	
	public void onButtonClick() {
		
		// Après avoir saisi les info pour la recherche du film
		// on récupère les données du TextField, qu'on passe en paramètre de requête
		String indice = tf.getText();
		FilmsDAO fdao = new FilmsDAO();
		ArrayList<Films> f = fdao.findbyname(indice);
		System.out.println(f);
		
		this.fillView(f);
	}
	
	public void add() {
		//System.out.println("Adding...");
	}
	
	public void remove() {
		//System.out.println("Removing...");
	}
	
	public void close() {
		//System.out.println("Closing...");
		Stage stage = (Stage) close.getScene().getWindow();
		stage.close();
	}

}
