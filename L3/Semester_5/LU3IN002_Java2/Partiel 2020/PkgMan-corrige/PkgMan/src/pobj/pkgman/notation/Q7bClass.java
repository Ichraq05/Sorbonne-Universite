package pobj.pkgman.notation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pobj.pkgman.updater.UpdateException;

public class Q7bClass extends NotationBase {
	
	@Test public void testClass1() {
		assertTrue(inheritsFrom(UpdateException.class, Throwable.class));
	}

	@Test public void testClass2() {
		assertTrue(inheritsFrom(UpdateException.class, Exception.class));
		assertFalse(inheritsFrom(UpdateException.class, RuntimeException.class));
	}	
}

