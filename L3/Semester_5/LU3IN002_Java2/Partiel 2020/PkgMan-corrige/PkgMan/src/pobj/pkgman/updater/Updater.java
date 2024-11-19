package pobj.pkgman.updater;

import java.util.ArrayList;
import java.util.List;

import pobj.pkgman.IPkg;
import pobj.pkgman.IManager;

public class Updater {

	// Nous gardons dans des attributs (privés) le IManager et le IConnector
	// (fixés à la construction) à qui nous déléguerons le travail d'installation
	// et de recherche des (dernières versions des) paquets par leur nom.
	private IManager man;
	private IConnector connector;
	
	// Le constructeur fixe le IManager et le IConnector.
	public Updater(IConnector connector, IManager man) {
		this.connector = connector;
		this.man = man;
	}

	// Installation (ou mise à jour) d'une liste de paquets spécifiés par leur nom.
	// installPkgs signalera une UpdateException en cas d'erreur, ce qu'il faut
	// préciser par un "throws UpdateException" dans la signature.
	public void installPkgs(List<String> pkgs) throws UpdateException {
		// Récupération de la base à jour de paquets.
		IDatabase c = connector.getDatabase();
		if (c==null) {
			// Erreur de récupération de la base de paquets.
			throw new UpdateException("Cannot establish connection");
		}
		// Le try-finally assure que c.close() sera toujours appelée,
		// même en cas d'exception.
		try {
			// Pour chaque paquet à installer (ou mettre à jour).
			for (String name : pkgs) {
				// Récupération de la dernière version du paquet.
				IPkg p = c.getPackage(name);
				if (p==null) {
					// Aucun paquet de ce nom dans la base => erreur.
					throw new UpdateException("Cannot find package " + name);
				}
				// Installation du paquet, par délégation au ManagerVersion.
				if (!man.installPkg(p)) {
					// Erreur d'installation.
					throw new UpdateException("Cannot install package " + p);
				}
			}
		}
		finally {
			// Fermeture de la connexion. Toujours exécutée.
			c.close(); 
		}
	}

	// Retourne la liste des noms des paquets installés.
	public List<String> getInstalled() {
		// getInstalled retourne une liste de paquets, dont il faut extraire le nom.
		// Les noms sont ajoutés dans une liste s...
		List<String> s = new ArrayList<>();
		for (IPkg p : man.getInstalled()) {
			s.add(p.getName());
		}
		// ...qui est retournée.
		return s;
	}

	// Mise à jour de tous les paquets installés.
	// updateWorld appelle installPkgs, et peut donc signaler 
	// une UpdateException.
	public void updateWorld() throws UpdateException {
		installPkgs(getInstalled());
	}
}
