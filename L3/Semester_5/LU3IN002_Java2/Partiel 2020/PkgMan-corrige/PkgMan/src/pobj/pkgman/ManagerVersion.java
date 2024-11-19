package pobj.pkgman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ManagerVersion implements IManager {

	// Cette map associe à chaque nom de paquet (chaîne simple, sans 
	// information de version) le paquet IPkg effectivement installé.
	// Initialement vide (pas de paquet installé).
	private HashMap<String,IPkg> installed = new HashMap<>();

	// Installation (si aucun paquet de même nom que pkg est installé) ou mise 
	// à jour (si un paquet de même nom que pkg est installé) récursive 
	// du paquet. 
	@Override
	public boolean installPkg(IPkg pkg) {
		// Vérification qu'un paquet de même nom que pkg est déjà installé. 
		IPkg i = installed.get(pkg.getName());
		if (i != null && i.getVersion().compareTo(pkg.getVersion()) >=0) {
			// Un paquet est déjà installé et sa version est égale ou supérieure à
			// celle demandée.
			// Rien à faire, nous retournons un succès.
			return true;
		}
		// Ici, soit il n'y a pas de paquet installé de même nom que pkg (i == null),
		// soit le paquet installé a une version strictement inférieure à celle de pkg.
		// Dans les deux cas, il sera nécessaire d'installer pkg.
		// Nous installons d'abord (récursivement) ses dépendances.
		for (IPkg p : pkg.getDependencies()) {
			if (!installPkg(p))  {
				// Erreur d'installation : retour immédiat en erreur (false).
				return false;
			}
		}
		// Si un paquet du même nom que pkg est déjà installé,
		// nous le désinstallons (mise à jour).
		if (i!=null) {
			i.uninstall();
		}
		// Installation du paquet pkg.
		if (!pkg.install()) {
			return false;
		}
		// Mise à jour de la map : le nom du paquet est associé à pkg.
		// Note : si la map contenait déjà une entrée pour la clé (i.e., si un paquet
		// de même nom que pkg était installé), put remplace l'ancienne entrée
		// par la nouvelle (pkg).
		installed.put(pkg.getName(), pkg);
		// Tout s'est bien passé : nous retournons true.
		return true;
	}

	// Désinstallation.
	@Override
	public void uninstallPkg(IPkg pkg) {
		// Vérification que pkg est installé.
		// Nous cherchons d'abord un paquet de même nom que pkg dans les
		// paquets installés.
		IPkg i = installed.get(pkg.getName());
		// Puis nous vérifions que sa version correspond.
		if (i != null && i.getVersion().equals(pkg.getVersion())) {
			// Désinstallation.
			i.uninstall();
			// Mise à jour de la map.
			installed.remove(i.getName());
		}
	}

	// Retourne la liste des paquets installés.
	@Override
	public List<IPkg> getInstalled() {
		// Extraction des paquets installés depuis la map.
		Collection<IPkg> set = installed.values();
		// values() retourne une Collection.
		// Nous devons la convertir en liste.
		// Nous utilisons pour cela, le constructeur d'ArrayList prenant
		// une Collection en argument.
		return new ArrayList<>(set);
	}
}
