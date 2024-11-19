package pobj.pkgman;

import java.util.ArrayList;
import java.util.List;

public class Manager implements IManager {
	private List<IPkg> liste = new ArrayList<>();
	
	public Manager() {}
	
	@Override
	public boolean installPkg(IPkg pkg) {
		// TODO Auto-generated method stub
		if(liste.contains(pkg)) {
			return true;
		}
		for(IPkg i : pkg.getDependencies()) {
			if (!installPkg(i)) {
				return false;
			}
		}
		
		if (!pkg.install()) {
			return false;
		}

		liste.add(pkg);
		return true;
	}

	@Override
	public void uninstallPkg(IPkg  pkg) {
   		if (!liste.contains(pkg))  {
   			return;
   		}
   		
   		pkg.uninstall();
   		liste.remove(pkg);
   	}

	@Override
	public List<IPkg> getInstalled() {
		// TODO Auto-generated method stub
		return liste;
	}
	
}
