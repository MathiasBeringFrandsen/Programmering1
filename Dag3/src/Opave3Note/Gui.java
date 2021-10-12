package Opave3Note;

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
		Circle circle = new Circle(290, 110, 35);
		pane.getChildren().add(circle);
		circle.setFill(Color.YELLOW);
		circle.setStroke(Color.YELLOW);

		Rectangle hus = new Rectangle(100, 200, 120, 120);
		pane.getChildren().add(hus);
		hus.setFill(Color.RED);

		Rectangle skorsten = new Rectangle(107, 107, 30, 60);
		pane.getChildren().add(skorsten);
		skorsten.setFill(Color.ORANGERED);

		Polygon polygon = new Polygon(75, 200, 245, 200, 165, 100);
		pane.getChildren().add(polygon);
		polygon.setFill(Color.GREEN);

		Line graes = new Line(75, 320, 300, 320);
		pane.getChildren().add(graes);
		graes.setStrokeWidth(2);
		graes.setStroke(Color.GREEN);

		Rectangle vindue = new Rectangle(125, 225, 40, 40);
		pane.getChildren().add(vindue);
		vindue.setFill(Color.BLACK);

		Line solstråleEt = new Line(290, 70, 290, 35);
		pane.getChildren().add(solstråleEt);
		solstråleEt.setStroke(Color.YELLOW);
		solstråleEt.setStrokeWidth(4);

		Line solstråleTo = new Line(290, 150, 290, 185);
		pane.getChildren().add(solstråleTo);
		solstråleTo.setStroke(Color.YELLOW);
		solstråleTo.setStrokeWidth(4);

		Line solstråleTre = new Line(215, 110, 250, 110);
		pane.getChildren().add(solstråleTre);
		solstråleTre.setStroke(Color.YELLOW);
		solstråleTre.setStrokeWidth(4);

		Line solstråleFire = new Line(330, 110, 365, 110);
		pane.getChildren().add(solstråleFire);
		solstråleFire.setStroke(Color.YELLOW);
		solstråleFire.setStrokeWidth(4);

		Line solstråleFem = new Line(260, 80, 240, 60);
		pane.getChildren().add(solstråleFem);
		solstråleFem.setStroke(Color.YELLOW);
		solstråleFem.setStrokeWidth(4);

		Line solstråleSeks = new Line(260, 135, 240, 155);
		pane.getChildren().add(solstråleSeks);
		solstråleSeks.setStroke(Color.YELLOW);
		solstråleSeks.setStrokeWidth(4);

		Line solstråleSyv = new Line(319, 139, 340, 165);
		pane.getChildren().add(solstråleSyv);
		solstråleSyv.setStroke(Color.YELLOW);
		solstråleSyv.setStrokeWidth(4);

		Line solstråleOtte = new Line(320, 80, 340, 60);
		pane.getChildren().add(solstråleOtte);
		solstråleOtte.setStroke(Color.YELLOW);
		solstråleOtte.setStrokeWidth(4);


	}

}
