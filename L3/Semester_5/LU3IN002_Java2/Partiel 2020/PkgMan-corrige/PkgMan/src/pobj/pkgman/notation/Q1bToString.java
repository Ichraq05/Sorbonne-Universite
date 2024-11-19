package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.AbstractPkg;
import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.Version;

public class Q1bToString extends NotationBase {
	
	public class MyPkg extends AbstractPkg {

		public MyPkg(String name, IVersion version, List<IPkg> dependencies)
		{ 	super(name, version, dependencies); }
		public boolean install() { return true; }
		public void uninstall() { }
	}
	
	@Test public void testToString() {
		List<IPkg> l = new ArrayList<>();
		IVersion v = new Version(5,6);
		MyPkg m = new MyPkg("toto", v, l);
		assertEquals("toto-5.6", m.toString());
	}

}
