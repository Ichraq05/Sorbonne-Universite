package pobj.pkgman.log;

import java.util.List;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;

/*
 * Décorateur générique, qui se contente de déléguer au décoré.
 * Attention, cette classe n'hérite pas d'AbstractPkg (ou d'une autre implantation
 * de IPkg) : toutes les méthodes doivent être définies ici.
 */
public class PkgDecorator implements IPkg {

	// Attribut contenant l'objet décoré.
	private IPkg pkg;
	
	// Le construteur fixe l'objet décoré dans l'attribut.
	public PkgDecorator(IPkg pkg) {
		this.pkg = pkg;
	}

	@Override
	public String getName() {
		// Délégation au décoré.
		return pkg.getName();
	}

	@Override
	public IVersion getVersion() {
		// Délégation au décoré.
		return pkg.getVersion();
	}

	@Override
	public List<IPkg> getDependencies() {
		// Délégation au décoré.
		return pkg.getDependencies();
	}

	@Override
	public boolean install() {
		// Délégation au décoré.
		return pkg.install();
	}

	@Override
	public void uninstall() {
		// Délégation au décoré.
		pkg.uninstall();
	}

	@Override
	public boolean equals(Object o) {
		// Délégation au décoré.
		return pkg.equals(o);
	}
	
	@Override
	public String toString() {
		// Délégation au décoré.
		return pkg.toString();
	}
}
