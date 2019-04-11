
enum TypePoisson{
	CARNIVORE,
	HERBIVORES
};
enum Race{
	MEROU,
	THON,
	POISSONCLOWN,
	SOLE,
	BAR,
	CARPE
};
enum Sexe{
	MALE,
	FEMELLE
};
public class Poisson {
	
	TypePoisson type;
	String nom;
	Sexe sexe;
	Race race;
	int coordX;
	int coordY;
	int pv;
	
	public Poisson(TypePoisson t, Race r, Sexe s, String n, int pointVie, int x, int y) {
		type = t;
		race = r;
		sexe = s;
		nom = n;
		pv = pointVie;
		coordX = x;
		coordY = y;
	}
	public void mange(Poisson p, Aquarium a) {
		if (this.type.equals(TypePoisson.CARNIVORE)) {
			a.listePoisson.remove(p);
		}		
	}
	public void mange(Algue al, Aquarium a) {
			a.listeAlgue.remove(al);		
	}
	
	@Override
	public String toString(){
		return "Nom: " + nom + " Sexe: "+ sexe;
	}
}
