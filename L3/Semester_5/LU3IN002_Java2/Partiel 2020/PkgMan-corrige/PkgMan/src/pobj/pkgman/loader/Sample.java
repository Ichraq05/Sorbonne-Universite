package pobj.pkgman.loader;

import java.io.IOException;
import java.util.List;

import pobj.pkgman.IPkg;

public class Sample {	

	/*
	 *  Méthode statique.
	 *  Attention à bien respecter le format demandé.
	 *  Lors de la correction, je ne tiens pas compte des espaces manquantes
	 *  ou ajoutées (mais l'oubli du ":" est une erreur). 
	 */
	public static void printPkgs(List<IPkg> l) {
		// Itération sur la liste l.
		for (IPkg p : l) {
			System.out.print(p + ":");
			// Itération sur les dépendances.
			for (IPkg pp : p.getDependencies()) {
				System.out.print(" " + pp);
			}
			System.out.println();
		}
	}

	/*
	 * Pour être exécutable, une classe doit définir une méthode main plubique,
	 * statique, ayant un String[] en argument et retournant void.
	 * Notre méthode peut signaler des exceptions IOException (à cause de
	 * PkgLoader). Celles-ci afficheront un message dans la console 
	 * (comportement par défaut en cas d'exception non rattrapée dans le 
	 * programme).
	 */
	public static void main(String[] args) throws IOException {
		// Chargement.
		PkgLoader l = new PkgLoader("src/pobj/pkgman/loader/example.txt");
		// Affichage via la méthode statique.
		printPkgs(l.getPackages());
	}
}
