package Opgave5OlympiskeCirkler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
		Circle blåCirkel = new Circle(75, 100, 50);
		pane.getChildren().add(blåCirkel);
		blåCirkel.setFill(null);
		blåCirkel.setStroke(Color.BLUE);
		blåCirkel.setStrokeWidth(4);

		Circle sortCirkel = new Circle(175, 100, 50);
		pane.getChildren().add(sortCirkel);
		sortCirkel.setFill(null);
		sortCirkel.setStroke(Color.BLACK);
		sortCirkel.setStrokeWidth(4);

		Circle rødCirkel = new Circle(275, 100, 50);
		pane.getChildren().add(rødCirkel);
		rødCirkel.setFill(null);
		rødCirkel.setStroke(Color.RED);
		rødCirkel.setStrokeWidth(4);

		Circle gulCirkel = new Circle(125, 150, 50);
		pane.getChildren().add(gulCirkel);
		gulCirkel.setFill(null);
		gulCirkel.setStroke(Color.YELLOW);
		gulCirkel.setStrokeWidth(4);

		Circle grønCirkel = new Circle(225, 150, 50);
		pane.getChildren().add(grønCirkel);
		grønCirkel.setFill(null);
		grønCirkel.setStroke(Color.GREEN);
		grønCirkel.setStrokeWidth(4);

	}

}
