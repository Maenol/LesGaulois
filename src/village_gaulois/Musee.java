package village_gaulois;

import personnage.Gaulois;
import objets.Equipement;
import objets.Trophee;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;
	
	public void donnerTrophee (Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		this.trophees[nbTrophees] = trophee;
		nbTrophees ++;
	}
	
	public String extraireInstructionsOcaml () {
		String texte;
		texte = "let musee = [ \n";
		for (int i = 0; i < nbTrophees; i++) {
			Trophee trophee = trophees[i];
			Gaulois gaulois = trophee.getGaulois();
			Equipement equipement = trophee.getEquipement();
			String nomEquipement;
			if (equipement == Equipement.BOUCLIER) {
				nomEquipement = "bouclier";
			} else {
				nomEquipement = "casque";
			}
			texte += "    \"" + gaulois.getNom() + "\", \"" + nomEquipement + "\";\n";
		}
		texte += "]";
		return texte;
	}
}
