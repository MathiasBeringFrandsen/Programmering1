package Opgave4Note;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
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
		Rectangle remBund = new Rectangle(175, 258, 50, 100);
		pane.getChildren().add(remBund);
		remBund.setFill(Color.BROWN);

		Line syningNederstVenstre = new Line(180, 258, 180, 358);
		pane.getChildren().add(syningNederstVenstre);
		syningNederstVenstre.setStroke(Color.WHITE);
		syningNederstVenstre.getStrokeDashArray().addAll(3d);

		Line syningNederstHojre = new Line(220, 258, 220, 358);
		pane.getChildren().add(syningNederstHojre);
		syningNederstHojre.setStroke(Color.WHITE);
		syningNederstHojre.getStrokeDashArray().addAll(3d);

		Rectangle remTop = new Rectangle(175, 42, 50, 100);
		pane.getChildren().add(remTop);
		remTop.setFill(Color.BROWN);

		Line syningTopVenstre = new Line(180, 43, 180, 142);
		pane.getChildren().add(syningTopVenstre);
		syningTopVenstre.setStroke(Color.WHITE);
		syningTopVenstre.getStrokeDashArray().addAll(3d);

		Line syningTopHojre = new Line(220, 43, 220, 142);
		pane.getChildren().add(syningTopHojre);
		syningTopHojre.setStroke(Color.WHITE);
		syningTopHojre.getStrokeDashArray().addAll(3d);

		Circle urSkive = new Circle(200, 200, 60);
		pane.getChildren().add(urSkive);
		urSkive.setFill(null);
		urSkive.setStroke(Color.SILVER);
		urSkive.setStrokeWidth(10);

		Text et = new Text(195, 155, "1");
		et.setFill(Color.BLACK);
		pane.getChildren().add(et);
		et.getTransforms().add(new Rotate(30, 200, 200));

		Text to = new Text(195, 155, "2");
		to.setFill(Color.BLACK);
		pane.getChildren().add(to);
		to.getTransforms().add(new Rotate(60, 200, 200));

		Text tre = new Text(195, 155, "3");
		tre.setFill(Color.BLACK);
		pane.getChildren().add(tre);
		tre.getTransforms().add(new Rotate(90, 200, 200));

		Text fire = new Text(195, 155, "4");
		fire.setFill(Color.BLACK);
		pane.getChildren().add(fire);
		fire.getTransforms().add(new Rotate(120, 200, 200));

		Text fem = new Text(195, 155, "5");
		fem.setFill(Color.BLACK);
		pane.getChildren().add(fem);
		fem.getTransforms().add(new Rotate(150, 200, 200));

		Text seks = new Text(195, 155, "6");
		seks.setFill(Color.BLACK);
		pane.getChildren().add(seks);
		seks.getTransforms().add(new Rotate(180, 200, 200));

		Text syv = new Text(195, 155, "7");
		syv.setFill(Color.BLACK);
		pane.getChildren().add(syv);
		syv.getTransforms().add(new Rotate(210, 200, 200));

		Text otte = new Text(195, 155, "8");
		otte.setFill(Color.BLACK);
		pane.getChildren().add(otte);
		otte.getTransforms().add(new Rotate(240, 200, 200));

		Text ni = new Text(195, 155, "9");
		ni.setFill(Color.BLACK);
		pane.getChildren().add(ni);
		ni.getTransforms().add(new Rotate(270, 200, 200));

		Text ti = new Text(192, 155, "10");
		ti.setFill(Color.BLACK);
		pane.getChildren().add(ti);
		ti.getTransforms().add(new Rotate(300, 200, 200));

		Text elleve = new Text(192, 155, "11");
		elleve.setFill(Color.BLACK);
		pane.getChildren().add(elleve);
		elleve.getTransforms().add(new Rotate(330, 200, 200));

		Text tolv = new Text(192, 155, "12");
		tolv.setFill(Color.BLACK);
		pane.getChildren().add(tolv);

		Line storeViser = new Line(200, 200 , 200, 160);
		pane.getChildren().add(storeViser);

		Line lilleViser = new Line(200, 200, 232, 200);
		pane.getChildren().add(lilleViser);

		Polygon storeViserTrekant = new Polygon(196, 160, 204, 160, 200, 156);
		pane.getChildren().add(storeViserTrekant);
		storeViserTrekant.setFill(Color.BLACK);

		Polygon lilleViserTrekant = new Polygon(232, 196, 232, 204, 236, 200);
		pane.getChildren().add(lilleViserTrekant);
		lilleViserTrekant.setFill(Color.BLACK);

		Text urNavn = new Text(172, 225, "ROLEXX");
		pane.getChildren().add(urNavn);
		urNavn.setFont(Font.font(17));
		urNavn.setFill(Color.GOLD);

	}

}
