package com.emont01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Eivar Montenegro on 10/08/16.
 *
 * @author Eivar Montenegro <e.mont01 at gmail.com>
 */
public class BubbleChartSample extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Bubble Chart Sample");
        final NumberAxis xAxis = new NumberAxis(1, 53, 4);
        final NumberAxis yAxis = new NumberAxis(0, 80, 10);
        final BubbleChart<Number, Number> bubbleChart = new BubbleChart<>(xAxis, yAxis);
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$ ",null));
        yAxis.setLabel("Product Budget");
        yAxis.setTickLabelGap(10);
        yAxis.setTickLabelFill(Color.CHOCOLATE);

        xAxis.setLabel("Week");
        xAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"w",null));
        xAxis.setTickLabelGap(5);
        xAxis.setTickLabelFill(Color.DARKGREY);

        bubbleChart.setTitle("Budget Monitoring");
        bubbleChart.setAlternativeColumnFillVisible(false);
        bubbleChart.setAlternativeRowFillVisible(true);
        bubbleChart.setVerticalGridLinesVisible(true);
        bubbleChart.setVerticalZeroLineVisible(false);
        bubbleChart.setHorizontalGridLinesVisible(false);
        bubbleChart.setHorizontalZeroLineVisible(false);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Product 1");
        series1.getData().add(new XYChart.Data(3, 35, 2));
        series1.getData().add(new XYChart.Data(12, 60, 1.8));
        series1.getData().add(new XYChart.Data(15, 15, 7));
        series1.getData().add(new XYChart.Data(22, 30, 2.5));
        series1.getData().add(new XYChart.Data(28, 20, 1));
        series1.getData().add(new XYChart.Data(35, 41, 5.5));
        series1.getData().add(new XYChart.Data(42, 17, 9));
        series1.getData().add(new XYChart.Data(49, 30, 1.8));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Product 2");
        series2.getData().add(new XYChart.Data(8, 15, 2));
        series2.getData().add(new XYChart.Data(13, 23, 1));
        series2.getData().add(new XYChart.Data(15, 45, 3));
        series2.getData().add(new XYChart.Data(24, 30, 4.5));
        series2.getData().add(new XYChart.Data(38, 78, 1));
        series2.getData().add(new XYChart.Data(40, 41, 7.5));
        series2.getData().add(new XYChart.Data(45, 57, 2));
        series2.getData().add(new XYChart.Data(47, 23, 3.8));

        Scene scene = new Scene(bubbleChart);
        bubbleChart.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
