package Ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(500, 500);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    private void drawCircle(GraphicsContext gc, int x, int y, int r) {
        gc.strokeOval(x - r, y - r, r * 2, r * 2);
    }

    private void drawCross(GraphicsContext gc, int x, int y, int  w){
        gc.strokeLine(x - w, y, x + w, y);
        gc.strokeLine(x, y - w, x, y + w);
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc) {
        int x = 0;
        int y = 100;
        int r = 25;
        int w = 5;
        for (x = 50; x <= 150; x = x + 25) {
            drawCircle(gc, x, y, r);
            drawCross(gc, x, y, w);
        }
    }

}
