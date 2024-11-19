package pobj.pkgman.updater;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pobj.pkgman.IPkg;
import pobj.pkgman.loader.PkgLoader;

public class Connector implements IConnector {	
	
	/*
	 * Le nom de fichier est spécifié à la construction, mais est (ré)utilisé à
	 * chaque appel à getDatabase().
	 * Il faut donc le maintenir dans un attribut (privé).
	 */
	private String file;

	// Pas d'appel à PkgLoader, le constructeur se contente de se souvenir
	// du nom du fichier.
	public Connector(String file) {
		this.file = file;
	}
	
	// getDatabase fait tout le travail : chargement de la base et construction d'un
	// nouveau IDatabase à chaque nouvel appel.
	@Override
	public IDatabase getDatabase() {
		// Les paquets de la base seront classés par nom de paquet dans une map
		// lors du chargement.
		Map<String,IPkg> data = new HashMap<>();
		try {
			// Chargement de la liste des paquets.
			PkgLoader l = new PkgLoader(file);
			// Pour chaque paquet, on met à jour la map data : le paquet n'est
			// ajouté que si data ne contient pas de paquet de même nom, ou bien
			// un paquet de même nom mais de version inférieure.
			for (IPkg p : l.getPackages()) {
				// Y-a-t-il déjà un paquet de même nom que p ?
				IPkg old = data.get(p.getName());
				if (old == null || old.getVersion().compareTo(p.getVersion()) < 0) {
					// Pas de paquet de même nom, ou bien un paquet de version
					// strictement inférieure à p.
					data.put(p.getName(), p);
				}
			}
			// En sortie de boucle, data contient une entrée pour chaque nom de 
			// paquet présent dans file.
			// À chaque nom de paquet de file, data associe le paquet de file de
			// version la plus haute.
		} catch (IOException e) {
			// Erreur de chargement, nous retournons null.
			return null;
		}
		
		// L'objet IDatabase retourné est instancié ici par une classe anonyme
		// (une classe sans nom qui implante l'interface IDatabase en 
		// fournissant le code des méthodes getPackage et close).
		// La syntaxe générale est : "new interface() { méthodes };". 
		// Une classe interne aurait aussi bien marché (mais serait un peu plus
		// verbeuse).
		return new IDatabase() {
			// La classe anonyme est dans la portée de la variable locale data.
			// Toutes ses méthodes peuvent donc y accéder (même si elles sont
			// appelées après le retour de la méthode getDatabase() : l'instance
			// garde une référence cachée sur la map, qui reste valide en dehors de
			// la portée normale de la variable locale data).
			
			@Override public IPkg getPackage(String name) {
				// get retournera naturellement null si aucun paquet de nom name
				// n'existe dans la map data.
				return data.get(name);
			}
			@Override public void close() {
				// Rien à faire dans close.				
			}
		};
	}
}
