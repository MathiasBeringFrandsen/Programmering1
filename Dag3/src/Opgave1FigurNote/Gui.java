package Opgave1FigurNote;

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
		Circle circle = new Circle(120, 170, 100); // Circle centrum 70,70 and
		// radius 30
		pane.getChildren().add(circle);
		circle.setFill(Color.DEEPSKYBLUE);
		circle.setStroke(null);

		Line line = new Line(200, 270, 100, 270); // Line from (70,70) to (100,70)
		pane.getChildren().add(line);

		// Rectangle from (100,40) width 75 and height 25
		Rectangle rektangel = new Rectangle(300, 80, 25, 100);
		pane.getChildren().add(rektangel);
		rektangel.setFill(Color.DARKSLATEGRAY);


	}

}
