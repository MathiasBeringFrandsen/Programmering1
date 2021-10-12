package Opgave2FigurNote;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
		int xValue = 100;
		Color figureColor = Color.YELLOW;

		Circle circle = new Circle(xValue, 170, 20);
		pane.getChildren().add(circle);
		circle.setFill(figureColor);
		circle.setStroke(null);

		Line line = new Line(xValue, 100, 200, 100);
		pane.getChildren().add(line);
		line.setStroke(figureColor);

		Rectangle rektangel = new Rectangle(xValue, 280, 25, 100);
		pane.getChildren().add(rektangel);
		rektangel.setFill(figureColor);


	}

}
