package pobj.pkgman;

import java.util.Collections;

/*
 * Nous avons choisi d'hériter d'AbstractPkg pour ne pas avoir à réimplanter
 * les getters, equals et toString.
 * Voir SimplePkgAdapterAlt pour une variante qui n'hérite pas d'AbstractPkg.
 */
public class SimplePkgAdapter extends AbstractPkg {

	// Attribut privé qui garde un lien vers l'objet décoré.
	private ISimplePkg pkg;
	
	// Constructeur simple, qui fixe l'obet décoré.
	public SimplePkgAdapter(ISimplePkg pkg) {
		// Appel au constructeur parent : il gardera dans ses attributs la valeur
		// du nom (délégation à l'objet décoré), de la version (par défaut) et de la 
		// liste (vide) de dépendances.
		super(pkg.name(), Version.getDefaultVersion(), Collections.emptyList());
		this.pkg = pkg;
	}

	@Override
	public boolean install() {
		// Délégation à pkg. 
		pkg.install();
		return true;
	}

	@Override
	public void uninstall() {
		// Rien à faire.
	}
	
	/*
	 * Inutile de redéfinir les accesseurs, toString() et equals().
	 * L'implantation héritée d'AbstractPkg convient.
	 */
}