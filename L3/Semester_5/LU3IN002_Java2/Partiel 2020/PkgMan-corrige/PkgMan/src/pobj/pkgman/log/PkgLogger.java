package pobj.pkgman.log;

import pobj.pkgman.IPkg;

/*
 * Cette solution utilise un décorateur générique, PkgDecorator, qui se
 * contente de déléguer au décoré sans autre effet, puis une classe
 * PkgLogger qui en hérite pour redéfinir (uniquement) les méthodes qui 
 * doivent avoir un comportement différent de celui du décoré.
 */
public class PkgLogger extends PkgDecorator {

	// Attribut à qui déléguer les écritures dans le log.
	private ILogger log;
	
	public PkgLogger(IPkg pkg, ILogger log) {
		// Appel au constructeur parent pour fixer le décoré.
		super(pkg);
		this.log = log;
	}
	
	@Override
	public boolean install() {
		// Ajout dans le log.
		log.log("Installing " + this);
		// Appel d'install sur le décoré, par délégation à PkgDecorator.
		if (super.install()) {
			// Ajout dans le log.
			log.log("Success");
			return true;
		}
		else {
			// Ajout dans le log.
			log.log("Failure");
			return false;
		}
	}

	@Override
	public void uninstall() {
		// Ajout dans le log.
		log.log("Uninstalling " + this);
		// Appel d'uninstall sur le décoré, par délégation à PkgDecorator.
		super.uninstall();
	}
}
