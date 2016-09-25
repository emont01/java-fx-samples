package com.emont01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class LoginForm extends Application {
    final Text actionTarget = new Text();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        // Login form elements
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);
        actionTarget.setId("action-target");

        Label label = new Label("User name:");
        grid.add(label, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        // Sign in button
        Button signInButton = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(signInButton);
        grid.add(hBox, 1, 4);

        // Action target text
        grid.add(actionTarget, 1, 6);

        // Sign in click
        signInButton.setOnAction(e -> {
            handleLogin();
        });
        signInButton.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                handleLogin();
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add(LoginForm.class.getResource("Login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin() {
        actionTarget.setText("Sign in button pressed!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
