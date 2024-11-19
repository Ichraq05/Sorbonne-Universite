package pobj.pkgman;

import java.util.List;

public class LimitPkg extends AbstractPkg {

	/*
	 * Il ne faut pas (re)définir les attributs name, version, dependencies
	 * Il sont déjà présents (mais privés) dans AbstractPkg, dont on hérite.
	 */
	
	// Attribut statique, commun à tous les objets de cette classe (ou héritée).
	// Automatiquement initialisé à 0. C'est ce qu'il faut.
	private static int nbInstalled;

	// Constructeur de même signature qu'AbstractPkg.
	public LimitPkg(String name, IVersion version, List<IPkg> dependencies) {
		/*
		 * Nous ne pouvons pas modifier les attributs name, version, 
		 * dependencies, privés dans AbstractPkg.
		 * Nous passons donc par le constructeur d'AbstractPkg pour 
		 * les initialiser, avec un appel à super.
		 */
		super(name, version, dependencies);
	}

	@Override
	public boolean install() {
		// Retourne avec une erreur (false) si trop de paquets sont installés.
		if (nbInstalled >= 10) {
			return false; 
		}
		// Sinon, incrémente nbInstalled.
		nbInstalled++;
		return true;
	}

	@Override
	public void uninstall() {
		nbInstalled--;
	}

	public static int getNbInstalled() {
		return nbInstalled;
	}
	
	/*
	 * Il ne faut pas (re)définir les méthodes getName, getVersion, 
	 * getDependencies, equals, toString. 
	 * Elles sont héritées d'AbstractPkg, et peuvent donc accéder à ses attributs
	 * privés (name, version, dependencies).
	 */
}
