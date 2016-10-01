package com.emont01;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

/**
 * Created by Eivar Montenegro on 09/29/16.
 *
 * @author Eivar Montenegro <e.mont01 at gmail.com>
 */

public class PieChartSample extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
//        chart.setLabelLineLength(10);
//        chart.setLegendSide(Side.LEFT);

        final Label caption = new Label("");
        caption.setId("caption");

        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(
                MouseEvent.MOUSE_PRESSED,
                e -> {
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());
                    caption.setText(String.valueOf(data.getPieValue()) + "%");
                }
            );
        }

        root.getChildren().add(chart);
        root.getChildren().add(caption);

        scene.getStylesheets().add("/styles/pie_charts.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
