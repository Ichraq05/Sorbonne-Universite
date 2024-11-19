package pobj.pkgman.loader;

import java.io.IOException;
import java.util.List;

import pobj.pkgman.IPkg;

public class Sample {
	public static void printPkgs(List<IPkg> lst) {
		for (IPkg i : lst) {
			System.out.print(i + ": ");
			for (IPkg j : i.getDependencies()) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Chargement.
		PkgLoader l = new PkgLoader("src/pobj/pkgman/loader/example.txt");
		// Affichage via la méthode statique.
		printPkgs(l.getPackages());
	}
}
