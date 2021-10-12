package Opgave3Smiley;

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
		Circle head = new Circle(200, 200, 100);
		pane.getChildren().add(head);
		head.setFill(null);
		head.setStroke(Color.LIGHTBLUE);

		Circle leftEye = new Circle(170, 160, 20);
		pane.getChildren().add(leftEye);
		leftEye.setFill(null);
		leftEye.setStroke(Color.LIGHTBLUE);

		Circle rightEye = new Circle(230, 160, 20);
		pane.getChildren().add(rightEye);
		rightEye.setFill(null);
		rightEye.setStroke(Color.LIGHTBLUE);

		Line mouth = new Line(150, 225, 250, 225);
		pane.getChildren().add(mouth);
		mouth.setStroke(Color.LIGHTBLUE);


	}

}
