package pobj.pkgman.notation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.ISimplePkg;
import pobj.pkgman.SimplePkgAdapter;

public class Q4Class extends NotationBase {
	
	private class MyPkg implements ISimplePkg {

		@Override public String name() {
			return "name";
		}

		@Override public void install() { }
	}
		
	@Test public void testClass() {
		MyPkg p = new MyPkg();
		SimplePkgAdapter a = new SimplePkgAdapter(p);
		assertTrue(a instanceof IPkg);
	}
	
	@Test public void testAttributes() {
		assertTrue(hasOnlyPrivateAttributes(SimplePkgAdapter.class));
		assertTrue(hasAttributeOfType(SimplePkgAdapter.class, ISimplePkg.class));
	}
	
}
