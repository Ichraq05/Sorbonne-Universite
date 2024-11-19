package pobj.pkgman.notation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.LimitPkg;
import pobj.pkgman.Version;

public class Q1cInstall1 extends NotationBase {
		
	private IPkg[] mkPkg(int nb) {
			IPkg[] a= new IPkg[nb];
			for (int i = 0; i < nb; i++) {
				a[i] = new LimitPkg("toto", new Version(i,0), new ArrayList<>());
			}
			return a;
	}
		
	@Test public void testInstall1() {
		IPkg[] a= mkPkg(1);
		assertTrue(a[0].install());
	}
	
}
