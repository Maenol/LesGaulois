package personnage;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	
	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le gaulois" + nom + " : ";
	}
	
	public void frapper (Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoire un grand coup dans la machoire de " 
		+ nomRomain);
		int forceCoup = (this.force*this.effetPotion)/3;
		romain.recevoirCoup(forceCoup);
		if (this.effetPotion > 1) {
			this.effetPotion = this.effetPotion - 1;
		}
	}
	
	public void boirePotion (int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	@Override
	public String toString() {
		return nom ;
	}
	
	public void sePresenter() {
		if (this.village == null) {
			parler("Bonjour, je m'appelle " + this.nom + ". Je n'ai pas de village.");
		}else {
			Gaulois chef = this.village.getChef();
			if (chef.getNom()==this.nom) {
				parler("Bonjour, je m'appelle " + this.nom + ". Je suis le chef du village : " + this.village.getNom() + ".");
			} else {
				parler("Bonjour, je m'appelle " + this.nom + ". J'habite le village : " + this.village.getNom() + ".");
			}
		}
	}

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}
