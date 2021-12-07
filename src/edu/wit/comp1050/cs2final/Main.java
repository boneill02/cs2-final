package edu.wit.comp1050.cs2final;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of Checkers game for CS2 final project.
 *
 * @author Ben O'Neill, Yogi Patel
 * 
 * 
 */
public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        /* set window properties */
        stage.setTitle("Checkers");

        /* initialize UI components */
       
        
        GridPane boardPane = new GridPane();

        boardPane.setPadding(new Insets(10));
        boardPane.setHgap(10);
        boardPane.setVgap(10);


        ScrollPane scrollPane = new ScrollPane (boardPane) ; 
        //Setting the correct layout 
        stage.setScene(new Scene(scrollPane));
        stage.setHeight(850);
        stage.setWidth(825);
        stage.show();
        // TODO rest of UI

        Game g = new Game();
        g.initButtons(boardPane);
        g.start();
    }

    public static void main(String[] args) {
        launch();
    }
}