package edu.wit.comp1050.cs2final;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
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

        /* initialize ui components */
        GridPane boardPane = new GridPane();
        
        for ( int r = 0; r < 8;r ++) { 
        	for ( int c = 0; c < 8; c ++ ) {
        		int number = 8 * r + c; 
        		Button btn = new Button (String.valueOf((number)));
        		boardPane.add(btn,c , r);
        	}
        }
        
        ScrollPane scrollPane = new ScrollPane (boardPane) ; 
        
        stage.setScene(new Scene(scrollPane));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}