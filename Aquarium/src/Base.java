

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Base extends Application{

	public static void main(String[] args) {

		Base.launch(args);
	}

	

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Aquarium");
		Aquarium a = initAquarium();
		
		Fenetre f = new Fenetre(a);
		Scene scene = f.createScene();
		primaryStage.setScene(scene);
		primaryStage.show();
		f.remplirScene();
		primaryStage.show();
		
		f.can.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(f.racePoisson!=null) {
				f.a.ajoutPoisson(f.racePoisson, Sexe.FEMELLE, "justine", 10, (int)e.getX(), (int)e.getY());
				f.remplirScene();
				//primaryStage.show();
				}
			}
		});
		f.merouB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				f.racePoisson = Race.MEROU;
				f.merouB.setDisable(true);
				f.barB.setDisable(false);
			}
		});
		f.barB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				f.racePoisson = Race.BAR;
				f.merouB.setDisable(false);
				f.barB.setDisable(true);
			}
		});
		f.algueB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				f.a.ajoutAlgue(10);
				f.remplirScene();
			}
		});
	
	}
	private Aquarium initAquarium() {
		
		Aquarium a = new Aquarium();
		a.ajoutPoisson(Race.BAR, Sexe.FEMELLE, "georeg", 20, 118,232);
		a.ajoutPoisson(Race.MEROU, Sexe.FEMELLE, "geog", 20, 529,69);
		a.ajoutPoisson(Race.MEROU, Sexe.FEMELLE, "geoguu", 20, 429,69);
		a.ajoutPoisson(Race.MEROU, Sexe.FEMELLE, "geognn", 20, 222,147);
		a.ajoutAlgue(10);
		a.ajoutAlgue(15);
		a.passeTour();
		return a;
	}

}
