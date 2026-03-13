package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion () {
		if (this.quantitePotion == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void remplirChaudron (int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public int prendreLouche () {
		this.quantitePotion = this.quantitePotion - 1;
		return this.forcePotion;
	}
}