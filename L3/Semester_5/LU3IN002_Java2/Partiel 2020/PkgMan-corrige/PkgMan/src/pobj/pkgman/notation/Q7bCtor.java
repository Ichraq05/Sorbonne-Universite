package pobj.pkgman.notation;

import org.junit.Test;

import pobj.pkgman.updater.UpdateException;

public class Q7bCtor extends NotationBase {
	
	@Test public void testCtor() {
		new UpdateException("msg");
	}

	@Test public void testAttr() {
		UpdateException u = new UpdateException("msg");
		assertEqualsNormalized("msg", u.getMessage());
	}

}

