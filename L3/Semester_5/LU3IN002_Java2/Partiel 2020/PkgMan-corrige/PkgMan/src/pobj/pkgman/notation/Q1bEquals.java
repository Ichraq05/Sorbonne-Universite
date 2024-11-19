package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.AbstractPkg;
import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.Version;

public class Q1bEquals extends NotationBase {
	
	public class MyPkg extends AbstractPkg {
		public MyPkg(String name, IVersion version, List<IPkg> dependencies)
		{ 	super(name, version, dependencies); }
		public boolean install() { return true; }
		public void uninstall() { }
	}
	
	@Test public void testEquals1() {
		List<IPkg> l = new ArrayList<>();
		IVersion v1 = new Version(5,6);
		MyPkg m1 = new MyPkg("toto", v1, l);
		MyPkg m2 = new MyPkg("toto", v1, l);
		assertEquals(m1, m1);
		assertEquals(m1, m2);
	}

	@Test public void testEquals2() {
		List<IPkg> l = new ArrayList<>();
		IVersion v1 = new Version(5,6);
		IVersion v2 = new Version(2,3);
		IVersion v3 = new Version(2,3);
		MyPkg m1 = new MyPkg("toto", v1, l);
		MyPkg m2 = new MyPkg("toto", v1, l);
		MyPkg m3 = new MyPkg("toto", v2, l);
		MyPkg m4 = new MyPkg("toto", v3, l);
		MyPkg m5 = new MyPkg("tata", v1, l);
		assertEquals(m1, m2);
		assertNotEquals(m1, m3);
		assertNotEquals(m1, m4);
		assertNotEquals(m1, m5);
	}
	
	@Test public void testEquals3() {
		List<IPkg> l = new ArrayList<>();
		IVersion v1 = new Version(5,6);
		MyPkg m1 = new MyPkg("toto", v1, l);
		MyPkg m2 = new MyPkg("toto", v1, l);
		assertEquals(m1, m2);
		assertFalse(m1.equals("xyz"));
	}
}
