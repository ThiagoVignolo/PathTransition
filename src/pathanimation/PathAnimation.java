/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pathanimation;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author usu2dam
 */
public class PathAnimation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setCenterX(100);
        circle.setCenterY(100);
        
        Rectangle rectangle = new Rectangle( 20, 30);
        rectangle.setFill(Color.GREEN);
        
        Path path = new Path();
        path.getElements().add (new MoveTo (0f, 50f));
        path.getElements().add (new CubicCurveTo (40f, 10f, 390f, 240f, 1904, 50f));

        PathTransition pathTransition = new PathTransition();
        
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setNode(rectangle);
        pathTransition.setPath(circle);
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount( 400);
        pathTransition.setAutoReverse(false);

        pathTransition.play();
        
        pathTransition.play();
        
        Pane root = new Pane();
        root.getChildren().add(circle);
        root.getChildren().add(rectangle);
        
        root.setOnMousePressed(event -> {
            pathTransition.pause();
        });

        root.setOnMouseReleased(event -> {
            pathTransition.play();
        });
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("PathTrancition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
