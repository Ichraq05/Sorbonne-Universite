package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pobj.pkgman.ISimplePkg;
import pobj.pkgman.SimplePkgAdapter;

public class Q4Delegation extends NotationBase {
	
	private class MyPkg implements ISimplePkg {

		public int installCalled;
		public int nameCalled;
		
		@Override public String name() {
			nameCalled++;
			return "name";
		}

		@Override
		public void install() {
			installCalled++;
		}		
	}
	
	@Test public void testName() {
		MyPkg p = new MyPkg();
		SimplePkgAdapter a = new SimplePkgAdapter(p);
		assertEquals(p.name(), a.getName());
		assertTrue(p.nameCalled >= 1);
	}
	
	@Test public void testVersion() {
		MyPkg p = new MyPkg();
		SimplePkgAdapter a = new SimplePkgAdapter(p);
		assertEquals(1, a.getVersion().getMajor());
		assertEquals(0, a.getVersion().getMinor());		
	}

	@Test public void testInstall() {
		MyPkg p = new MyPkg();
		SimplePkgAdapter a = new SimplePkgAdapter(p);
		assertTrue(a.install());
		assertEquals(1, p.installCalled);		
	}
	
	@Test public void testUninstall() {
		MyPkg p = new MyPkg();
		SimplePkgAdapter a = new SimplePkgAdapter(p);
		a.uninstall();
	}
	
	@Test public void testDependencies() {
		MyPkg p = new MyPkg();
		SimplePkgAdapter a = new SimplePkgAdapter(p);
		assertTrue(a.getDependencies().isEmpty());
	}
	
}
