package pobj.pkgman.notation;

import java.util.List;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;

public class NotationPkg extends NotationAbstractPkg implements IPkg {

	public NotationPkg(String name, IVersion version, List<IPkg> dependencies) {
		super(name, version, dependencies);
	}

	@Override
	public boolean install() {
		return true;
	}

	@Override
	public void uninstall() { }

}
