package pobj.pkgman.notation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pobj.pkgman.IManager;
import pobj.pkgman.IPkg;

public class NotationManagerVersion implements IManager {

	// map to name of installed packages to packages
	private HashMap<String,IPkg> installed = new HashMap<>();

	@Override
	public boolean installPkg(IPkg pkg) {
		// check that the package is not already installed with a sufficient version
		IPkg i = installed.get(pkg.getName());
		if (i != null && i.getVersion().compareTo(pkg.getVersion()) >=0) {
			return true;
		}
		// make sure dependencies are installed
		for (IPkg p : pkg.getDependencies()) {
			if (!installPkg(p))  {
				return false;
			}
		}
		// uninstall if a version is already present
		if (i!=null) {
			i.uninstall();
		}
		// install the correct version
		if (!pkg.install()) {
			return false;
		}
		// remember that the package is installed
		installed.put(pkg.getName(), pkg);
		return true;
	}

	@Override
	public void uninstallPkg(IPkg pkg) {
		// check whether the package with the specified version is installed
		IPkg i = installed.get(pkg.getName());
		if (i != null && i.getVersion().equals(pkg.getVersion())) {
			i.uninstall();
			installed.remove(i.getName());
		}
	}

	@Override
	public List<IPkg> getInstalled() {
		return new ArrayList<>(installed.values());
	}
	
}
