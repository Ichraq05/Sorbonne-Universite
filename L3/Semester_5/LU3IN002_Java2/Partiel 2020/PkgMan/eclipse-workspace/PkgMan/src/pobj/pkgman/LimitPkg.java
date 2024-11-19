package pobj.pkgman;

import java.util.List;

public class LimitPkg extends AbstractPkg {
	
	private static int cpt = 0;

	public LimitPkg(String nom, IVersion version, List<IPkg> depenses) {
		super(nom, version, depenses);
		// TODO Auto-generated constructor stub
	}
	
	public static int getNbInstalled() {
		return cpt;
	}

	@Override
	public boolean install() {
		// TODO Auto-generated method stub
		if(cpt >= 10) {
			return false;
		}
		cpt++;
		return true;
	}

	@Override
	public void uninstall() {
		// TODO Auto-generated method stub
		cpt--;
	}

}
