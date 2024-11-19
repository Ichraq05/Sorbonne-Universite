package pobj.pkgman.notation;

import java.util.List;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;

public interface IPkgFactory {
	public IPkg newPkg(String name, IVersion version, List<IPkg> dependencies);
}
