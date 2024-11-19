package pobj.pkgman.notation;

import org.junit.Test;

import pobj.pkgman.log.LogBuffer;

public class Q5aMsg extends NotationBase {
	
	@Test public void testGetLog() {
		LogBuffer b = new LogBuffer();		
		assertEqualsNormalized("", b.getLog());
	}
	
	@Test public void testMsg() {
		LogBuffer b = new LogBuffer();		
		b.log("abc");
		assertEqualsNormalized("abc\n", b.getLog());
		b.log("xyz");
		assertEqualsNormalized("abc\nxyz\n", b.getLog());
	}
	
}
