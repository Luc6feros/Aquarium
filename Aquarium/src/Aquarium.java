
import java.util.ArrayList;
import java.util.Iterator;


public class Aquarium {

	ArrayList<Poisson> listePoisson;
	ArrayList<Algue> listeAlgue;




	public Aquarium() {
		listePoisson = new ArrayList<Poisson>();
		listeAlgue = new ArrayList<Algue>();


	}
	

	public int nbAlgue() {

		return this.listeAlgue.size();
	}

	public int nbPoisson() {

		return this.listePoisson.size();
	}
	public void ajoutPoisson(Race r, Sexe s, String nom, int pv,int x, int y) {

		switch (r) {
		case BAR:
			listePoisson.add(new Poisson(TypePoisson.HERBIVORES, r, s, nom, pv, x, y));
			break;
		case SOLE:
			listePoisson.add(new Poisson(TypePoisson.HERBIVORES, r, s, nom, pv, x, y));
			break;
		case CARPE:
			listePoisson.add(new Poisson(TypePoisson.HERBIVORES, r, s, nom, pv,x,  y));
			break;
		case MEROU:
			listePoisson.add(new Poisson(TypePoisson.CARNIVORE, r, s, nom, pv,x, y));
			break;
		case POISSONCLOWN:
			listePoisson.add(new Poisson(TypePoisson.CARNIVORE, r, s, nom, pv,x, y));
			break;
		case THON:
			listePoisson.add(new Poisson(TypePoisson.CARNIVORE, r, s, nom, pv,x,y));
			break;
		default:
			break;

		}
	}
	public void removePoisson(Poisson p) {
		if(!listePoisson.isEmpty()) {
			listePoisson.remove(p);
		}

	}
	public void ajoutAlgue(int pv) {
		listeAlgue.add(new Algue(pv));
	}

	public int removeAlgue(Algue al) {

		if(!listeAlgue.isEmpty()) {
			listeAlgue.remove(al);
			return 1;
		}
		return -1;
	}

	public void passeTour() {
		Iterator<Poisson> iP = listePoisson.listIterator();
		System.out.println("Nb algues : "+ listeAlgue.size());
		while(iP.hasNext()) {
			Poisson p = iP.next();
			System.out.println(p.toString());
		}
	}
}



