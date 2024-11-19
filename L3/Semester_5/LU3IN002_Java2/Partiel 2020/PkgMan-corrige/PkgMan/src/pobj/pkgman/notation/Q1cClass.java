package pobj.pkgman.notation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import pobj.pkgman.AbstractPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.LimitPkg;

public class Q1cClass extends NotationBase {
	
	@Test public void testClass() {
		assertTrue(LimitPkg.class.getSuperclass() == AbstractPkg.class);
	}
	
	@Test public void testAttributes() {
		assertTrue(hasOnlyPrivateAttributes(LimitPkg.class));
		assertFalse(hasAttributeOfType(LimitPkg.class, String.class));
		assertFalse(hasAttributeOfSubtype(LimitPkg.class, IVersion.class));
		assertFalse(hasAttributeOfSubtype(LimitPkg.class, Collection.class));
	}
	
	@Test public void testMethods1() {
		assertTrue(hasMethod(LimitPkg.class, "install"));
		assertTrue(hasMethod(LimitPkg.class, "uninstall"));
		assertTrue(hasMethod(LimitPkg.class, "getNbInstalled"));
	}
	
	@Test public void testMethods2() {
		assertFalse(hasMethod(LimitPkg.class, "getName"));
		assertFalse(hasMethod(LimitPkg.class, "getVersion"));
		assertFalse(hasMethod(LimitPkg.class, "getDependencies"));
		assertFalse(hasMethod(LimitPkg.class, "toString"));
		assertFalse(hasMethod(LimitPkg.class, "equals"));
	}
	
}
