package se.alipsa.fxsvgimage.issue39;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ExampleApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(20));
    Circle circle = new Circle();
    circle.setRadius(40);
    circle.setFill(Paint.valueOf("blue"));
    hbox.getChildren().add(circle);
    root.setCenter(hbox);
    FlowPane actionPane = new FlowPane();
    actionPane.setPadding(new Insets(10));
    Label fileNameLabel = new Label("File name");
    TextField filenameField = new TextField("Node.svg");
    Button createSvgButton = new Button("Create SVG");
    createSvgButton.setOnAction(a -> NodeConverter.convert(circle, filenameField.getText()));
    actionPane.getChildren().addAll(fileNameLabel, filenameField, createSvgButton);
    root.setBottom(actionPane);
    Scene scene = new Scene(root);
    primaryStage.setTitle("Node to SVG export example");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
