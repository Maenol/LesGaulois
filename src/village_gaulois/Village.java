package village_gaulois;

import personnage.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private int nb_villageois_max;
	private Gaulois chef;
	private Gaulois[] villageois;
	
	public int getNb_villageois_max() {
		return nb_villageois_max;
	}
	public Gaulois getChef() {
		return chef;
	}
	public String getNom() {
		return nom;
	}
	public int getNbVillageaois() {
		return nbVillageois;
	}
	
	public Village(String nom,  Gaulois chef, int nb_villageaois_max) {
		this.nom = nom;
		this.chef = chef;
		this.nb_villageois_max = nb_villageaois_max;
		this.villageois = new Gaulois[nb_villageaois_max];
		chef.setVillage(this);
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois<nb_villageois_max) {
			villageois[nbVillageois] = gaulois;
			nbVillageois ++;
			gaulois.setVillage(this);
		}
	}
	
	public Gaulois trouverVillageois (int numVillageois) {
		if (numVillageois <= nbVillageois) {
			return villageois[nbVillageois - 1];
		} else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village " + this.nom + " du chef " + this.chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix;
		abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village;
		village = new Village("Village des irréductibles", abraracourcix,30);
		village.trouverVillageois(30);
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillage();
		Gaulois obelix;
		obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillage();
		Gaulois doublepolemix;
		doublepolemix = new Gaulois("Doublepolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}
}
