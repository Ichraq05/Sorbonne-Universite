package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import pobj.pkgman.Version;

public class Q1aEquals extends NotationBase {

	@Test public void testEquals1() {
		Version v1 = new Version(1,2);
		Version v2 = new Version(1,2);
		Version w1 = new Version(8,12);
		Version w2 = new Version(1,12);
		Version w3 = new Version(8,2);
		assertEquals(v1,v1);
		assertEquals(v1,v2);
		assertNotEquals(v1,w1);
		assertNotEquals(v1,w2);
		assertNotEquals(v1,w3);
	}

	@Test public void testEquals2() {
		Version v1 = new Version(1,2);
		assertFalse(v1.equals("xyz"));
	}
}

