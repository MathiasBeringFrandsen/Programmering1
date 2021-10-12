package Opgave2opgaver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
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
		Rectangle rektangel = new Rectangle(100, 40, 80, 30);
		pane.getChildren().add(rektangel);
		rektangel.setFill(Color.BLUE);
		rektangel.setStroke(null);

		Text text = new Text(118, 59, "Mathias");
		text.setFill(Color.RED);
		pane.getChildren().add(text);

	}

}
