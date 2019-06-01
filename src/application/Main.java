package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("View/ListeView.fxml"));
			//loader.setLocation(Main.class.getResource("View/mainGUI.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
						
			Scene sc1 = new Scene(root);
			primaryStage.setScene(sc1);
			primaryStage.show();
		
		
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
