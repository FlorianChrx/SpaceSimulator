package modele;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Loader {

	public static SystemeSolaire charger() throws IOException {
		List<String> tmp = new ArrayList<String>();
		
			BufferedReader buff = new BufferedReader(new FileReader("ressource/A TROUVER"));
			String ligne;
			while ((ligne = buff.readLine()) != null) {
				tmp.add(ligne);
			}
			buff.close();
			SystemeSolaire res = new SystemeSolaire();
			double g = 0.01;
			double dt = 0.025;
			double fa = 1;
		for(int i=0;i<tmp.size();++i){			
			String s = tmp.get(i);
			if(s.charAt(0)!='#' || s.substring(0,6).equals("PARAMS")) {
				String[] tab = s.split(": ");
				String[] tab2 = tab[1].split(" ");
				switch (tab2[0]) {
				case "Fixe":
					res.setEntityCenter(parseFixe(tab, tab2));
				break;
				case "Simulé":
					res.addEntity(parseSimule(tab, tab2, dt));
				break;
				case "Vaisseau":
					
				} 
			}else if (s.substring(0,6).equals("PARAMS")) {
			}
		}
		return res;
	}
	private static Planete parseSimule(String[] tab, String[] tab2,double dt) {
		return new Planete(new Point(Double.parseDouble(tab2[1].split("=")[1]),
				Double.parseDouble(tab2[2].split("=")[1])),
		Double.parseDouble(tab2[0]),20,tab[0],
		new Vecteur(Double.parseDouble(tab2[3].split("=")[1]),
				Double.parseDouble(tab2[4].split("=")[1])),
		new Trajectoire(dt));
	}

	private static Etoile parseFixe(String[] tab, String[] tab2) {
		return new Etoile(
				new Point(Double.parseDouble(tab2[1].split("=")[1]), Double.parseDouble(tab2[2].split("=")[1])),
				Double.parseDouble(tab2[0]), 40, tab[0]);
	}
	
}
