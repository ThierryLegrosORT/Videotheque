package application.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import application.Main;
import application.model.beans.Films;
import application.model.dao.FilmsDAO;

public class ListViewControler {
	
	@FXML
	private Button chercher;
	@FXML
	private Button ajouter;
	@FXML
	private Button supprimer;
	@FXML
	private Button editer;
	@FXML
	private Button quitter;
	@FXML
	private Button lister;
	@FXML
	private TableView video;
	@FXML
	private TableColumn id;
	@FXML
	private TableColumn titre;
	@FXML
	private TableColumn genre;
	@FXML
	private TableColumn annee;
	@FXML
	private TextField tf;
	
	public void listeTable() { // Permet de lister les titres présent en BDD
		try {
			
			// On commence par créer un objet
			FilmsDAO listeDeFilms = new FilmsDAO();
			
			// Puis on instancie une liste visualisable
			ObservableList<Films> film = listeDeFilms.listeBDD();
			
			// On initialise les différentes colonnes
			ObservableList<TableColumn> colonnes = video.getColumns();
			colonnes.get(0).setCellValueFactory(new PropertyValueFactory("id"));
			colonnes.get(1).setCellValueFactory(new PropertyValueFactory("titre"));
			colonnes.get(2).setCellValueFactory(new PropertyValueFactory("genre"));
			colonnes.get(3).setCellValueFactory(new PropertyValueFactory("annee"));
			
			// On remplie les colonnes avec les données présentes en BDD
			video.setItems(film);
			
			
		}
		catch(Exception e) {
			System.out.println("Listing BDD error: "+e.getLocalizedMessage());
		}
	}
	
	
	public void onButtonClick() {
		try {
			
			// On appelle ici le loader de la fenêtre de recherche
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("View/mainGUI.fxml"));
			Parent root = (Parent) loader.load();
						
			mainGUIControler sc1 = loader.getController();
			sc1.cchfilm(video.getItems());
			
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL); //SOURCE: https://www.developpez.net/forums/d1299811/java/interfaces-graphiques-java/javafx/javafx-applications-multi-fenetres/
			stage.setScene(scene);
			stage.show();
		
		
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			
		}
		
	}
	
	public void add() {
		//System.out.println("Adding...");
		
		try {
			
			// On appelle le loader d'ajout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("View/AddView.fxml"));
			Parent root = (Parent) loader.load();
						
			AddViewControler sc1 = loader.getController();
			sc1.setFilm(null);
			
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL); //SOURCE: https://www.developpez.net/forums/d1299811/java/interfaces-graphiques-java/javafx/javafx-applications-multi-fenetres/
			stage.setScene(scene);
			stage.show();
		
		
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			
		}
	}
	
	public void remove() {
		//System.out.println("Removing...");
		
		// Ici on permet la sélection d'un objet dans la BDD via le TableView
		Films toRemove = (Films) video.getSelectionModel().getSelectedItem();
		FilmsDAO remove = new FilmsDAO();
		remove.delete(toRemove);
	}
	
	public void quitter() {
		
	}
	

}
