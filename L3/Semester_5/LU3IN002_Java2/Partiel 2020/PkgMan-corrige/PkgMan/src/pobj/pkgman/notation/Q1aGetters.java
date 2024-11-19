package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pobj.pkgman.Version;

public class Q1aGetters extends NotationBase {
	
	@Test public void testGetters() {
		Version v = new Version(1,2);
		assertEquals(1, v.getMajor());
		assertEquals(2, v.getMinor());
		Version w = new Version(8,12);
		assertEquals(8, w.getMajor());
		assertEquals(12, w.getMinor());
	}

}
