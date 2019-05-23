package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

import application.model.beans.Films;
import application.model.dao.FilmsDAO;

public class mainGUIControler {
	
	@FXML
	private Button search;
	@FXML
	private Button add;
	@FXML
	private Button remove;
	@FXML
	private TextField tf;
	@FXML
	private Label titre;
	@FXML
	private Label genre;
	
	public void fillView(ArrayList<Films> f) {
		//titre.setText(f.getTitre());
		//genre.setText(f.getGenre());
		
		System.out.println("Searching...");
	}
	
	public void add() {
		System.out.println("Adding...");
	}
	
	public void remove() {
		System.out.println("Removing...");
	}
	
	public void onButtonClick() {
		System.out.println("public void search");
		
		String titre = tf.getText();
		
		
		FilmsDAO fdao = new FilmsDAO();
		ArrayList<Films> f = fdao.findByName(titre);
		
		this.fillView(f);
	}

}
