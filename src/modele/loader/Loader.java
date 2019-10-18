package modele.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modele.maths.Point;
import modele.maths.Trajectoire;
import modele.maths.Vecteur;
import modele.system.Etoile;
import modele.system.Planete;
import modele.system.SystemeSolaire;
import modele.system.Vaisseau;

public class Loader {

	public static SystemeSolaire charger() throws IOException, PropertiesException {
		List<String> tmp = new ArrayList<String>();

		BufferedReader buff = new BufferedReader(new FileReader("ressource/properties"));
		String ligne;
		while ((ligne = buff.readLine()) != null) {
			tmp.add(ligne);
		}
		buff.close();
		SystemeSolaire res = new SystemeSolaire();
		Double g=null;
		Double dt = null;
		Double fa=null;
		Double rayon=null;
		for (int i = 0; i < tmp.size(); ++i) {
			String s = tmp.get(i);
			if (s.charAt(0) != '#' && !s.substring(0, 6).equals("PARAMS")) {
				if (dt == null || g==null  || fa==null ||rayon==null) {	
					throw new PropertiesException();
				}
				String[] tab = s.split(": ");
				String[] tab2 = tab[1].split(" ");
				switch (tab2[0]) {
				case "Fixe":
					res.setEntityCenter(parseFixe(tab, tab2,dt));
					break;
				case "Simulé":
					res.addEntity(parseSimule(tab, tab2, dt));
					break;
				case "Vaisseau":
					res.setVaisseau(parseVaisseau(tab, tab2, dt));
					break;
				}
			} else if (s.substring(0, 6).equals("PARAMS")) {
				String[] tab = s.split(" ");
				g = Double.parseDouble(tab[1].split("=")[1]);
				fa = Double.parseDouble(tab[3].split("=")[1]);
				dt = Double.parseDouble(tab[2].split("=")[1]);
				rayon = Double.parseDouble(tab[4].split("=")[1]);
			}
		}
		if (dt == null || g==null  || fa==null ||rayon==null) {	
			throw new PropertiesException();
		}
		res.setG(g);
		res.setRayon(rayon);
		res.setFa(fa);
		
		return res;
	}

	private static Planete parseSimule(String[] tab, String[] tab2, double dt) {
		return new Planete(
				new Point(Double.parseDouble(tab2[2].split("=")[1]), Double.parseDouble(tab2[3].split("=")[1])),
				Double.parseDouble(tab2[1].split("=")[1]), 20, tab[0],
				new Vecteur(Double.parseDouble(tab2[4].split("=")[1]), Double.parseDouble(tab2[5].split("=")[1])),
				new Trajectoire(dt));
	}

	private static Vaisseau parseVaisseau(String[] tab, String[] tab2, double dt) {
		return new Vaisseau(
				new Point(Double.parseDouble(tab2[2].split("=")[1]), Double.parseDouble(tab2[3].split("=")[1])),
				Double.parseDouble(tab2[1].split("=")[1]), 10, tab[0],
				new Vecteur(Double.parseDouble(tab2[4].split("=")[1]), Double.parseDouble(tab2[5].split("=")[1])),
				new Trajectoire(dt), Double.parseDouble(tab2[6].split("=")[1]),
				Double.parseDouble(tab2[7].split("=")[1]));
	}

	private static Etoile parseFixe(String[] tab, String[] tab2,double dt) {
		return new Etoile(
				new Point(Double.parseDouble(tab2[2].split("=")[1]), Double.parseDouble(tab2[3].split("=")[1])),
				Double.parseDouble(tab2[1].split("=")[1]), 40.0, tab[0], new Vecteur(0, 0), new Trajectoire(dt));
	}

}
