package personnage;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public String getNom() {
		return nom;
	}
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron(0,0);
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void fabriquerPotion (int quantite, int forcePotion) {
		this.chaudron.remplirChaudron(quantite,forcePotion);
		parler ("J'ai concocté " + quantite 
				+ " doses de potions magiques. Elle a une force de " + forcePotion + ".");
	}
	
	public void boosterGaulois (Gaulois gaulois) {
		if (this.chaudron.resterPotion() == true) {
			if (gaulois.getNom() == "Obélix") {
				parler ("Non " + gaulois.getNom() + " non ! Et tu le sais très bien !");
			} else {
				gaulois.boirePotion(this.chaudron.prendreLouche());
				parler ("Tiens " + gaulois.getNom() + " un peu de potion magique.");
			}
		} else {
			parler ("Désolé " + gaulois.getNom() + " il n'y a plus une seule goutte de potion.");
		}
	}
}
