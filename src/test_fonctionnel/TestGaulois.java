package test_fonctionnel;

import personnage.Gaulois;

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
	}
}
