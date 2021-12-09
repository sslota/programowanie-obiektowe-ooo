package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    private AbstractWorldMap map;
    private GridPane mapGrid;

    public void init() throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(0, 0)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);

    }

    private void drawMap() {
        this.mapGrid = new GridPane();
        Label yx = new Label("y/x");
        yx.setFont(new Font(16));
        mapGrid.add(yx, 0, 0);
        GridPane.setHalignment(yx, HPos.CENTER);
        for (int k = 0; k <= map.getRightCorner().x - map.getLeftCorner().x; k++) {
            Label idx = new Label("" + (map.getLeftCorner().x + k));
            idx.setFont(new Font(16));
            mapGrid.add(idx, k + 1, 0);
            GridPane.setHalignment(idx, HPos.CENTER);
        }


        for (int k = 0; k <= map.getRightCorner().y - map.getLeftCorner().y; k++) {
            Label idx = new Label("" + (map.getRightCorner().y - k));
            idx.setFont(new Font(16));
            mapGrid.add(idx, 0, k + 1);
            GridPane.setHalignment(idx, HPos.CENTER);
        }


        for (int i = 0; i <= map.getRightCorner().x - map.getLeftCorner().x; i++) {
            for (int j = 0; j <= map.getRightCorner().y - map.getLeftCorner().y; j++) {
                Vector2d curMapPos = new Vector2d(map.getLeftCorner().x + i, map.getRightCorner().y - j);
                if (map.objectAt(curMapPos) != null) {
                    Label sq = new Label(map.objectAt(curMapPos).toString());
                    sq.setFont(new Font(16));
                    mapGrid.add(sq, i + 1, j + 1);
                    GridPane.setHalignment(sq, HPos.CENTER);

                } else {
                    Label sq = new Label(" ");
                    sq.setFont(new Font(16));
                    mapGrid.add(sq, i + 1, j + 1);
                    GridPane.setHalignment(sq, HPos.CENTER);
                }
            }
        }
        for (int k = 0; k <= map.getRightCorner().x - map.getLeftCorner().x + 1; k++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(30));

        }
        for (int l = 0; l <= map.getRightCorner().y - map.getLeftCorner().y + 1; l++) {

            mapGrid.getRowConstraints().add(new RowConstraints(30));

        }
        mapGrid.setGridLinesVisible(true);
    }

    public void start(Stage primaryStage) {
        drawMap();
        Scene scene = new Scene(mapGrid, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}