package pobj.pkgman;

import java.util.ArrayList;
import java.util.List;

public class Manager implements IManager {

	// Liste des paquets déjà installés.
	// Initialement vide.
	private List<IPkg> installed = new ArrayList<>();

	// Accesseur pour la liste des paquets installés.
	@Override
	public List<IPkg> getInstalled() {
		return installed;
	}

	@Override
	public boolean installPkg(IPkg pkg) {
		// Si le paquet est déja installé, retourne immédiatement true.
		if (installed.contains(pkg)) {
			return true;
		}

		// Sinon, installation des dépendances avant l'installation du paquet.
		for (IPkg p : pkg.getDependencies()) {
			// L'installation se fait par appel récursif à installPkg, pour s'assurer que 
			// les dépendances sont installées transitivement.
			if (!installPkg(p)) {
				// En cas d'échec d'une installation, retour immédiat et propagation 
				// de l'erreur (retour de false) à l'appelant.
				return false;
			}
		}

		// Installation du paquet.
		if (!pkg.install()) {
			// En cas d'erreur, retour de false.
			return false;
		}

		// Si tout s'est bien passé, le paquet est ajouté à la liste,
		installed.add(pkg);
		// et on retourne true
		return true;
	}

   	@Override
	public void uninstallPkg(IPkg  pkg) {
   		// Vérification que le paquet est installé.
   		if (!installed.contains(pkg))  {
   			// si non installé, rien à faire
   			return;
   		}
   		
   		// si installé, appel à uninstall(), sur le paquet uniquement
   		// sans regarder ses dépendances,
   		pkg.uninstall();
   		// puis suppression de la liste des paquets installés.
   		installed.remove(pkg);
   	}	   	
}
