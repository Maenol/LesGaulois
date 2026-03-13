package test_fonctionnel;

import personnage.Gaulois;
import personnage.Romain;

public class TestGaulois {
	public static void main (String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		Gaulois obelix;
		obelix = new Gaulois("Obélix", 16);
		asterix.parler("Bonjour " + obelix.getNom() + ".");
		obelix.parler( "Bonjour " + asterix.getNom() 
		+ ". Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		Romain minus;
		minus = new Romain("Minus", 6);
		System.out.println("Dans la forêt " + asterix.getNom() + " et " 
		+ obelix.getNom() + " tombent nez à nez sur le romain " + minus.getNom() + ".");
		while (minus.getForce() > 0) {
			asterix.frapper(minus);
		}
	}
}
