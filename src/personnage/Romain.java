package personnage;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return"Le romain " + nom + " : ";
	}
	
	public void recevoirCoup (int forceCoup) {
		assert forceCoup >=0;
		int force1 = this.force;
		this.force = this.force - forceCoup;
		if (this.force <= 0) {
			parler ("J'abandonne");
		} else {
			parler ("Aïe");
		}
		assert force1 >= this.force;
	}
	
	private boolean isInvariantVerified() {
		if (this.force >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2 :
			System.out.println("Le soldat " + this.nom +"  est déjà bien protégé !");
			break;
		case 1 :
			if (this.equipement[0] == equipement) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + equipement + ".");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		default :
			ajouterEquipement(equipement);
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		this.equipement[nbEquipement] = equipement;
		nbEquipement ++;
		System.out.println("Le soldat " + this.nom + " s'équipde d'un " + equipement + ".");
	}
	
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		assert minus.isInvariantVerified();
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
	
}
