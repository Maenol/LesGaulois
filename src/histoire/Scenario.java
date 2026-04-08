package histoire;

import personnage.Gaulois;
import personnage.Romain;
import personnage.Druide;
import objets.Equipement;

import village_gaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.fabriquerPotion(5, 3);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.boosterGaulois(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.boosterGaulois(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		int ancienneForce;

		do {
		    ancienneForce = minus.getForce();
		    asterix.frapper(minus);

		    if (minus.getForce() == ancienneForce) {
		        minus.parler("Alors " + asterix.getNom() + " on fait moins le malin face à mon équipement, Hi ! Hi !");
		        obelix.parler(asterix.getNom() + ", tu veux un peu d'aide ?");
		        obelix.frapper(minus);
		        break;
		    }
		    asterix.frapper(minus);
		    
		} while (minus.getForce() > 0 && minus.getForce() < ancienneForce);

		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			obelix.frapper(milexcus);
		} while (milexcus.getForce() > 0);


		Musee musee = new Musee();
		obelix.faireUneDonnation(musee);
		String testExtraction;
		testExtraction = musee.extraireInstructionsOcaml();
		System.out.println(testExtraction);

	}

}