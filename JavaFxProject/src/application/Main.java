package application;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Text t = new Text("Hello");
			
			t.setX(100);
			t.setY(100);
			
			Button b = new Button("Wakanda");
			
			Group g = new Group(t,b);
			Scene scene = new Scene(g,400,400);
			primaryStage.setTitle("Swedy");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
