package personnage;

import village_gaulois.Village;
import objets.Equipement;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	
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
	
//	private String prendreParole() {
//		return "Le gaulois" + nom + " : ";
//	}
	
//	public void frapper (Romain romain) {
//		String nomRomain = romain.getNom();
//		System.out.println(nom + " envoire un grand coup dans la machoire de " 
//		+ nomRomain);
//		int forceCoup = (this.force*this.effetPotion)/3;
//		romain.recevoirCoup(forceCoup);
//		if (this.effetPotion > 1) {
//			this.effetPotion = this.effetPotion - 1;
//		}
//	}
	
	public void boirePotion (int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
//	@Override
//	public String toString() {
//		return nom ;
//	}
	
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
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
		+ romain.getNom());
		Equipement[] autreTrophees = romain.recevoirCoup((force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
		effetPotion = 1;
		}
		for (int i = 0; autreTrophees != null && i < autreTrophees.length; i++) {
		    if (nbTrophees < trophees.length) {
		        this.trophees[nbTrophees] = autreTrophees[i];
		        nbTrophees++;
		    } else {
		        System.out.println(nom + " ne peut plus prendre de trophées !");
		        break;
		    }
		}
	}

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}
