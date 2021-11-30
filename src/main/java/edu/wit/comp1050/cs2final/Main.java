package edu.wit.comp1050.cs2final;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of Checkers game for CS2 final project.
 *
 * @author Ben O'Neill
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /* set window properties */
        stage.setTitle("Checkers");

        /* initialize ui components */
        GridPane boardPane = new GridPane();
        stage.show();
        // TODO rest of UI
    }

    public static void main(String[] args) {
        launch();
    }
}