package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pobj.pkgman.IVersion;
import pobj.pkgman.Version;

public class Q1aDefault extends NotationBase {

	@Test public void testDefaultVersion1() {
		IVersion v = Version.getDefaultVersion();
		assertEquals(1, v.getMajor());
		assertEquals(0, v.getMinor());
	}

	@Test public void testDefaultVersion2() {
		IVersion v1 = Version.getDefaultVersion();
		IVersion v2 = Version.getDefaultVersion();
		assertTrue(v1 == v2);
	}

}
