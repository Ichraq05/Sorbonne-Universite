package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pobj.pkgman.Version;

public class Q1aToString extends NotationBase {

	@Test public void testToString() {
		Version v = new Version(1,2);
		Version w = new Version(8,12);
		assertEquals("1.2", v.toString());
		assertEquals("8.12", w.toString());
	}
	
}
