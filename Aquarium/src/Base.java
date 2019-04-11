import javafx.application.Application;
import javafx.stage.Stage;

public class Base{

	public static void main(String[] args) {
		
		Aquarium a = new Aquarium();
		a.ajoutPoisson(Race.CARPE, Sexe.FEMELLE, "georeg", 20);
		a.ajoutPoisson(Race.MEROU, Sexe.FEMELLE, "geog", 20);
		a.ajoutAlgue(10);
		a.ajoutAlgue(15);
		a.passeTour();
	}

}
