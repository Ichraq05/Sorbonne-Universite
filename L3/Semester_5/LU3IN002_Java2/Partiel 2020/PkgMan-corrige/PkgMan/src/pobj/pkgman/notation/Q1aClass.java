package pobj.pkgman.notation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pobj.pkgman.IVersion;
import pobj.pkgman.Version;

public class Q1aClass extends NotationBase {

	@Test public void testClass() {
		Version v = new Version(1,2);
		assertTrue(Version.class.getSuperclass() == Object.class);
		assertTrue(v instanceof IVersion);
	}
	
	@Test public void testAttributes() {
		assertTrue(hasOnlyPrivateAttributes(Version.class));
		assertTrue(hasOnlyFinalOrStaticAttributes(Version.class));
	}
	
}
