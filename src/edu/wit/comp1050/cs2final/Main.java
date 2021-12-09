package edu.wit.comp1050.cs2final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
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
		boardPane.setHgap(50);
		boardPane.setVgap(51.5);

		ScrollPane scrollPane = new ScrollPane(boardPane);

		boardPane.setAlignment(Pos.CENTER);

		/* Setting the correct layout */
		stage.setScene(new Scene(scrollPane));
		stage.setHeight(740);
		stage.setWidth(705);
		stage.show();

		/* Setting the Background Image */
		BackgroundImage checkers = new BackgroundImage(
				new Image("http://www.clipartbest.com/cliparts/dc6/o6G/dc6o6GnKi.jpeg", 700, 700, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		/* setting the node */
		boardPane.setBackground(new Background(checkers));
		Game g = new Game();
		g.initButtons(boardPane);
		g.start();
	}

	public static void main(String[] args) {
		launch();
	}
}