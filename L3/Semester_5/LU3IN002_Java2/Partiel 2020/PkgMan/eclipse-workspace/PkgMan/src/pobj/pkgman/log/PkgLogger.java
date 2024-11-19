package pobj.pkgman.log;

import java.util.List;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;

public class PkgLogger implements IPkg{
	
	// Attribut contenant l'objet décoré.
		private IPkg pkg;
		private ILogger log;
		
		// Le construteur fixe l'objet décoré dans l'attribut.
		public PkgLogger(IPkg pkg, ILogger log) {
			this.pkg = pkg;
			this.log = log;
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
			log.log("Installing " + pkg.toString());
			if (pkg.install()) {
				log.log("Success");
				return true;
			}
			else {
				log.log("Failure");
				return false;
			}
		}

		@Override
		public void uninstall() {
			log.log("Uninstalling " + pkg.toString());
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
