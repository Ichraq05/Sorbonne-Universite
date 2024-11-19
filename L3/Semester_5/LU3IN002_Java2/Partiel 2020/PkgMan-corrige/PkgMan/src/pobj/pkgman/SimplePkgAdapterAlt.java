package pobj.pkgman;

import java.util.Collections;
import java.util.List;

/*
 * Version qui n'hérite pas d'AbstractPkg.
 */
public class SimplePkgAdapterAlt implements IPkg {

	// Attribut privé qui garde un lien vers l'objet décoré.
	private ISimplePkg pkg;

	// Constructeur simple, qui fixe l'objet décoré.
	public SimplePkgAdapterAlt(ISimplePkg pkg) {
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

	@Override
	public String getName() {
		// Délégation à pkg. 
		return pkg.name(); 
	}

	@Override
	public IVersion getVersion() {
		// Version par défaut.
		return Version.getDefaultVersion();
	}

	@Override
	public List<IPkg> getDependencies() {
		// Liste vide.
		return Collections.emptyList();
	}
}
