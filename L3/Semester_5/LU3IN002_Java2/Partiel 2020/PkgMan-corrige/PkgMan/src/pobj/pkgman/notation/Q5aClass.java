package pobj.pkgman.notation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.StringJoiner;

import org.junit.Test;

import pobj.pkgman.log.LogBuffer;
import pobj.pkgman.log.ILogger;

public class Q5aClass extends NotationBase {

	@Test public void testClass() {
		LogBuffer b = new LogBuffer();		
		assertTrue(b instanceof ILogger);
	}
	
	@Test public void testAttributes1() {
		assertTrue(hasOnlyPrivateAttributes(LogBuffer.class));
	}
	
	@Test public void testAttributes2() {
		assertFalse(hasAttributeOfType(LogBuffer.class, String.class));
		assertTrue(hasAttributeOfType(LogBuffer.class, StringBuffer.class) ||
							hasAttributeOfType(LogBuffer.class, StringBuilder.class) ||
							hasAttributeOfType(LogBuffer.class, StringJoiner.class) ||
							hasAttributeOfSubtype(LogBuffer.class, Collection.class));
	}

}
