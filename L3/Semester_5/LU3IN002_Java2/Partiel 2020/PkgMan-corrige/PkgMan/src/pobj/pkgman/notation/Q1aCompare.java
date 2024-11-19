package pobj.pkgman.notation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pobj.pkgman.Version;

public class Q1aCompare extends NotationBase {

	@Test public void testCompareTo1() {
		Version v1 = new Version(1,2);
		Version v4 = new Version(1,2);
		assertTrue(v1.compareTo(v1) == 0);
		assertTrue(v1.compareTo(v4) == 0);
	}	

	@Test public void testCompareTo2() {
		Version v1 = new Version(1,2);
		Version v2 = new Version(1,99);
		assertTrue(v1.compareTo(v2) == -1);
		assertTrue(v2.compareTo(v1) == 1);
	}	
	
	@Test public void testCompareTo3() {
		Version v1 = new Version(1,2);
		Version v2 = new Version(1,99);
		Version v3 = new Version (2,1);
		assertTrue(v1.compareTo(v3) == -1);
		assertTrue(v2.compareTo(v3) == -1);
		assertTrue(v3.compareTo(v1) == 1);
		assertTrue(v3.compareTo(v2) == 1);
	}	

	@Test public void testCompareTo4() {
		Version v1 = new Version(1,2);
		Version v2 = new Version(1,99);
		Version v3 = new Version (2,1);
		assertTrue(v1.compareTo(v3) == -1);
		assertTrue(v2.compareTo(v3) == -1);
		assertTrue(v3.compareTo(v1) == 1);
		assertTrue(v3.compareTo(v2) == 1);
	}	

}
