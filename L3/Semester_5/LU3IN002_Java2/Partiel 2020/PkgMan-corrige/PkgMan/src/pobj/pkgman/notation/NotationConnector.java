package pobj.pkgman.notation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pobj.pkgman.IPkg;
import pobj.pkgman.updater.IConnector;
import pobj.pkgman.updater.IDatabase;

public class NotationConnector implements IConnector {	
	
	private String file;
	private IPkgFactory fact;
	private List<IPkg> pkgs;
	
	public int nbClosed;
	
	public NotationConnector(String file, IPkgFactory fact) {
		this.file = file;
		this.fact = fact;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	@Override
	public IDatabase getDatabase() {
		Map<String,IPkg> data = new HashMap<>();
		try {
			NotationPkgLoader l = new NotationPkgLoader(file, fact);
			pkgs = l.getPackages();
			for (IPkg p : pkgs) {
				IPkg old = data.get(p.getName());
				if (old == null || old.getVersion().compareTo(p.getVersion()) < 0) {
					// keep only the latest version
					data.put(p.getName(), p);
				}
			}
		} catch (IOException e) {
			return null;
		}
		return new IDatabase() {
			@Override public IPkg getPackage(String name) {
				return data.get(name);
			}
			@Override public void close() { nbClosed++; }
		};
	}
	
	public List<IPkg> getPackages() {
		return pkgs;
	}
	
}
