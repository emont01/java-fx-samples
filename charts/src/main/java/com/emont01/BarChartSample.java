package com.emont01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Eivar Montenegro on 10/08/16.
 *
 * @author Eivar Montenegro <e.mont01 at gmail.com>
 */
public class BarChartSample extends Application {
    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");

        // Buttons (TOP)
        GridPane buttonsPane = new GridPane();
        buttonsPane.setPadding(new Insets(12, 12, 12, 12));
        buttonsPane.setHgap(10);
        buttonsPane.setVgap(10);

        // Vertical bars chart
        Button vBarsButton = new Button();
        vBarsButton.setText("Vertical Bars Chart");
        buttonsPane.add(vBarsButton, 0, 0);

        // Horizontal bars chart
        Button hBarsButton = new Button();
        hBarsButton.setText("Horizontal Bars Chart");
        buttonsPane.add(hBarsButton, 1, 0);

        // Status bar
        HBox statusBar = new HBox();
        Label statusLabel = new Label();
        statusBar.getChildren().add(statusLabel);
        statusLabel.setId("status-label");
        statusLabel.setText("Welcome");

        // Main Layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(buttonsPane);
        borderPane.setCenter(null);
        borderPane.setBottom(statusBar);

        // Buttons actions
        vBarsButton.setOnMouseClicked(e -> {
            borderPane.setCenter(verticalBarsChart());
        });
        hBarsButton.setOnMouseClicked(e -> {
            borderPane.setCenter(horizontalBarsChart());
        });

        Scene scene = new Scene(borderPane, 900, 700);
        scene.getStylesheets().add("styles/bar_charts.css");
        stage.setScene(scene);
        stage.show();
    }

    private BarChart verticalBarsChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Country Summary");
        xAxis.setLabel("Country");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(austria, 25601.34));
        series1.getData().add(new XYChart.Data(brazil, 20148.82));
        series1.getData().add(new XYChart.Data(france, 10000));
        series1.getData().add(new XYChart.Data(italy, 35407.15));
        series1.getData().add(new XYChart.Data(usa, 12000));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(austria, 57401.85));
        series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68));

        barChart.getData().addAll(series1, series2, series3);
        return barChart;
    }

    private BarChart horizontalBarsChart() {
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Country Summary");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Country");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(25601.34, austria));
        series1.getData().add(new XYChart.Data(20148.82, brazil));
        series1.getData().add(new XYChart.Data(10000, france));
        series1.getData().add(new XYChart.Data(35407.15, italy));
        series1.getData().add(new XYChart.Data(12000, usa));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(57401.85, austria));
        series2.getData().add(new XYChart.Data(41941.19, brazil));
        series2.getData().add(new XYChart.Data(45263.37, france));
        series2.getData().add(new XYChart.Data(117320.16, italy));
        series2.getData().add(new XYChart.Data(14845.27, usa));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(45000.65, austria));
        series3.getData().add(new XYChart.Data(44835.76, brazil));
        series3.getData().add(new XYChart.Data(18722.18, france));
        series3.getData().add(new XYChart.Data(17557.31, italy));
        series3.getData().add(new XYChart.Data(92633.68, usa));

        barChart.getData().addAll(series1, series2, series3);
        barChart.setAlternativeColumnFillVisible(true);
        barChart.setAlternativeRowFillVisible(false);
        return barChart;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
