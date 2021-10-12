package Ex6;

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
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc) {
        gc.strokeLine(5, 180, 190, 180);
        int x = 190;
        int y = 180;
        gc.strokeLine(x, y, x - 10, y - 4);
        gc.strokeLine(x, y, x - 10, y + 4);

        int y1 = 175;
        int y2 = 185;
        for (int i = 0; i < 11; i++) {
            int x1 = 20 + i * 15;
            if ((i % 5) == 0) {
                gc.strokeLine(x1, y1 - 5, x1, y2 + 5);
                gc.fillText("" + i, x1, y2 + 15);
            } else {
                gc.strokeLine(x1, y1, x1, y2);
            }
        }

    }
}
