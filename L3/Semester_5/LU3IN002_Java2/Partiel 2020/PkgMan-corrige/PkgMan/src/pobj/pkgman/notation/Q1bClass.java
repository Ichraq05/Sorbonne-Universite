package pobj.pkgman.notation;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import pobj.pkgman.AbstractPkg;
import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;

public class Q1bClass extends NotationBase {

	@Test public void testClass() {
		assertTrue(AbstractPkg.class.getSuperclass() == Object.class);
		assertTrue(isAbstract(AbstractPkg.class));
		assertTrue(implementsInterface(AbstractPkg.class, IPkg.class));
	}
	
	@Test public void testAttributes() {
		assertTrue(hasOnlyPrivateAttributes(AbstractPkg.class));
	}
	
	@Test public void testAttributes2() {	
		assertTrue(hasAttributeOfType(AbstractPkg.class, String.class));
		assertTrue(hasAttributeOfType(AbstractPkg.class, IVersion.class));
		assertTrue(hasAttributeOfSubtype(AbstractPkg.class, Collection.class));
	}

	@Test public void testMethods() {
		assertTrue(hasAbstractMethod(AbstractPkg.class, "install"));
		assertTrue(hasAbstractMethod(AbstractPkg.class, "uninstall"));
	}
	
	
}
