
import java.io.InputStream;
import java.util.Iterator;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Fenetre{

	int x, y;
	Label stats;
	Canvas can;
	int nbPoisson;
	int nbAlgues;
	Aquarium a;
	Image fond;
	Image bar;
	Image merou;
	Image algue;
	Random r;
	Button merouB;
	Button barB;
	Button algueB;
	Race racePoisson;

	public Fenetre(Aquarium a) {
		this.a = a;
		r = new Random();
		nbPoisson = a.nbPoisson();
		nbAlgues = a.nbAlgue();	
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("eau.png");
		fond = new Image(in);
		in = ClassLoader.getSystemClassLoader().getResourceAsStream("merou.png");
		merou = new Image(in);
		in = ClassLoader.getSystemClassLoader().getResourceAsStream("bar.png");
		bar = new Image(in);
		in = ClassLoader.getSystemClassLoader().getResourceAsStream("algue.png");
		algue = new Image(in);
	}
	public Scene createScene() {

		can = new Canvas(800,600);
		Pane vue = new Pane(can);
		stats = new Label("Nb Poisson: "+ a.nbPoisson() + " Nb Algues: "+ a.nbAlgue());
		stats.setMaxWidth(Double.MAX_VALUE);
		stats.setAlignment(Pos.CENTER);
		HBox boiteScene = new HBox();


		VBox boiteAquarium = new VBox();
		boiteAquarium.getChildren().add(vue);
		boiteAquarium.getChildren().add(stats);


		VBox boiteBoutons = new VBox();
		barB = new Button("Poisson BAR");
		barB.setMaxWidth(Double.MAX_VALUE);
		merouB = new Button("Poisson MEROU");
		merouB.setMaxWidth(Double.MAX_VALUE);
		algueB = new Button("Algue");
		algueB.setMaxWidth(Double.MAX_VALUE);
		
		boiteBoutons.getChildren().add(algueB);
		boiteBoutons.getChildren().add(barB);
		boiteBoutons.getChildren().add(merouB);

		boiteScene.getChildren().add(boiteAquarium);
		boiteScene.getChildren().add(boiteBoutons);


		return new Scene(boiteScene);
	}
	public void remplirScene() {
		//GraphicsContext gc = can.getGraphicsContext2D();
		//gc.setFill(Color.AQUA);
		//gc.fillRect(0, 0, can.getWidth(), can.getHeight());
		stats.setText("Nb Poisson: "+ a.nbPoisson() + " Nb Algues: "+ a.nbAlgue());
		tracefond();
		traceAquarium();

	}	
	private void tracefond() {
		GraphicsContext gc = can.getGraphicsContext2D();
		int heightImage = (int) can.getHeight()/10;
		int widthImage = (int)can.getWidth()/14;
		for(int i=0; i<14;i++) {
			for(int j=0; j<10;j++){
				gc.drawImage(fond, i*widthImage,j*heightImage, widthImage,heightImage);
			}
		}
	}
	private void traceAquarium() {
		GraphicsContext gc = can.getGraphicsContext2D();
		Iterator<Poisson> iP = a.listePoisson.iterator();
		while(iP.hasNext()) {
			Poisson p = iP.next();
			switch(p.race) {
			case MEROU:
				gc.drawImage(merou, p.coordX, p.coordY);
				break;
			case BAR:
				gc.drawImage(bar, p.coordX, p.coordY);
				break;
			default: 
				System.out.println("Connais pas");
			}
		}
		Iterator<Algue> iA = a.listeAlgue.iterator();
		while(iA.hasNext()) {
			iA.next();
			gc.drawImage(algue, r.nextInt((int)(can.getWidth()-algue.getWidth())), (int) can.getHeight()-algue.getHeight());
			}
	}
}

