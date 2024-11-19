package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.LimitPkg;
import pobj.pkgman.Version;

public class Q1cInstall4 extends NotationBase {
		
	private IPkg[] mkPkg(int nb) {
			IPkg[] a= new IPkg[nb];
			for (int i = 0; i < nb; i++) {
				a[i] = new LimitPkg("toto", new Version(i,0), new ArrayList<>());
			}
			return a;
	}
		
	@Test public void testUninstall() {
		IPkg[] a= mkPkg(1);
		assertTrue(a[0].install());
		assertEquals(1, LimitPkg.getNbInstalled());
		a[0].uninstall();
		assertEquals(0, LimitPkg.getNbInstalled());
	}
	
}
