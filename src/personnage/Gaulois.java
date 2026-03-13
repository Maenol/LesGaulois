package personnage;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
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
		int forceCoup = (force/3)*effetPotion;
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

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}
