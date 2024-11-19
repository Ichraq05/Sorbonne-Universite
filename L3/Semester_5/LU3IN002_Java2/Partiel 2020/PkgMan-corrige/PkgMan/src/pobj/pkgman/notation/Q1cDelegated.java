package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.LimitPkg;
import pobj.pkgman.Version;

public class Q1cDelegated extends NotationBase {
	
	@Test public void testGetters() {
		List<IPkg> l = new ArrayList<>();
		Version v = new Version(5,6);
		LimitPkg m = new LimitPkg("toto", v, l);
		assertEquals("toto", m.getName());
		assertEquals(5, m.getVersion().getMajor());
		assertEquals(6, m.getVersion().getMinor());
		assertTrue(m.getDependencies().isEmpty());
	}

	@Test public void testToString() {
		List<IPkg> l = new ArrayList<>();
		Version v = new Version(5,6);
		LimitPkg m = new LimitPkg("toto", v, l);
		assertEquals("toto-5.6", m.toString());
	}

	@Test public void testEquals() {
		List<IPkg> l = new ArrayList<>();
		Version v1 = new Version(5,6);
		Version v2 = new Version(2,3);
		Version v3 = new Version(2,3);
		LimitPkg m1 = new LimitPkg("toto", v1, l);
		LimitPkg m2 = new LimitPkg("toto", v1, l);
		LimitPkg m3 = new LimitPkg("toto", v2, l);
		LimitPkg m4 = new LimitPkg("toto", v3, l);
		LimitPkg m5 = new LimitPkg("tata", v1, l);
		assertEquals(m1, m1);
		assertEquals(m1, m2);
		assertNotEquals(m1, m3);
		assertNotEquals(m1, m4);
		assertNotEquals(m1, m5);
		assertFalse(m1.equals("xyz"));
	}
	
}
