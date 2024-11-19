package pobj.pkgman.notation;

import java.util.List;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;

public abstract class NotationAbstractPkg implements IPkg {

	private String name;
	private IVersion version;
	private List<IPkg> dependencies;

	public NotationAbstractPkg(String name, IVersion version, List<IPkg> dependencies) {
		this.name = name;
		this.version = version;
		this.dependencies = dependencies;
	}	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public IVersion getVersion() {
		return version;
	}

	@Override
	public List<IPkg> getDependencies() {
		return dependencies;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IPkg)) return false;
		IPkg p = (IPkg) o;
		return version.equals(p.getVersion()) && name.equals(p.getName());
	}
	
	@Override
	public String toString() {
		return name + "-" + version;
	}
}
