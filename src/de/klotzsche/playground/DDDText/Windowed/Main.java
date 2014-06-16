package de.klotzsche.playground.DDDText.Windowed;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * Created by Felix on 16.06.2014.
 */
public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public String getText(){
        System.out.print("Welchen Text möchtest du darstellen?: ");
        return new Scanner(System.in).nextLine();
    }

    private void setStyles(Scene s){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String text = this.getText();

        Text t = new Text(text);
        t.setId("dddText");
        t.getStyleClass().add("text3D");
        GridPane p = new GridPane();
        p.setAlignment(Pos.CENTER);
        p.add(t,0,0);

        Scene scene = new Scene(p, 800, 600);
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

        primaryStage.setTitle("My JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
