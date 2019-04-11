

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Fenetre extends Application{
	
	int x, y;
	Stage s;
	Canvas can;
	Image img;
	Random r;
	int nbPoisson;
	int nbAlgues;

	int bla;
	
	public Fenetre(Stage s,int nbP, int nbA) {
		nbPoisson = nbP;
		nbAlgues = nbA;
		this.s = s;
	}

	public static void main(String[] args) {
		ExempleJavaFXAvecCanvas.launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		r = new Random();
		primaryStage.setTitle("Aquarium");
		can = new Canvas(600,800);
		Pane vue = new Pane(can);
		HBox boiteStatsPoisson = new HBox();
		boiteStatsPoisson.getChildren().add(new Label("nbPoisson: "+ nbPoisson+" nbAlgues: "+nbAlgues));
		boiteStatsPoisson.setAlignment(Pos.CENTER);
		HBox.setHgrow(boiteStatsPoisson, Priority.ALWAYS);
		boiteStatsPoisson.setMaxWidth(Double.MAX_VALUE);
		
		VBox boiteScene = new VBox();
		boiteScene.getChildren().add(vue);
		boiteScene.getChildren().add(boiteStatsPoisson);
		VBox.setVgrow(vue, Priority.ALWAYS);
		Scene scene = new Scene(boiteScene);
		s.setScene(scene);
		s.show();
		
	}

	
}
