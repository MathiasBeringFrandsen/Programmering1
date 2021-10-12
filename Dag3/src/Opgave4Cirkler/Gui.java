package Opgave4Cirkler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Gui extends Application {
	
	@Override
	public void start(Stage stage) {
		Pane root = initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Shapes");
		stage.setScene(scene);
		stage.show();

	}

	private Pane initContent() {
		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {
		Circle storSort = new Circle(150, 150, 50);
		pane.getChildren().add(storSort);
		storSort.setFill(null);
		storSort.setStroke(Color.BLACK);
		storSort.setStrokeWidth(10);

		Circle mellemSort = new Circle(150, 150, 30);
		pane.getChildren().add(mellemSort);
		mellemSort.setFill(null);
		mellemSort.setStroke(Color.BLACK);
		mellemSort.setStrokeWidth(10);

		Circle lilleSort = new Circle(150, 150, 10);
		pane.getChildren().add(lilleSort);
		lilleSort.setFill(Color.BLACK);
		lilleSort.setStroke(Color.BLACK);
		lilleSort.setStrokeWidth(10);

	}

}
