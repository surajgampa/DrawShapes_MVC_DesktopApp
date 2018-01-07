package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			ShapeView view=new ShapeView();

			Controller c1 = new Controller(view);

			view.accessController(c1);

			Scene sceneMain=new Scene(view);
			primaryStage.setScene(sceneMain);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
