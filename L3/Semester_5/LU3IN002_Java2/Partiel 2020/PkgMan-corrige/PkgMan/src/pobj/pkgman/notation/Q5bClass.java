package pobj.pkgman.notation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.Version;
import pobj.pkgman.log.ILogger;
import pobj.pkgman.log.PkgLogger;

public class Q5bClass extends NotationBase {
	
	class MyPkg implements IPkg {

		@Override public String getName() { return ""; }
		@Override public IVersion getVersion() { return new Version(9,99); }
		@Override public List<IPkg> getDependencies() { return  new ArrayList<IPkg>(); }
		@Override public boolean install() { return true; }
		@Override public void uninstall() { }
	}

	class MyLogger implements ILogger {
		public void log(String msg) { }
		public String getLog() { return ""; }
	}
	
	@Test public void testClass() {
		PkgLogger l = new PkgLogger(new MyPkg(), new MyLogger());
		assertTrue(l instanceof IPkg);
	}
	
	@Test public void testAttributes1() {
		assertTrue(hasOnlyPrivateAttributes(PkgLogger.class));
	}
	
	@Test public void testAttributes2() {
		assertFalse(hasAttributeOfType(PkgLogger.class, String.class));
		assertFalse(hasAttributeOfSubtype(PkgLogger.class, IVersion.class));
		assertFalse(hasAttributeOfSubtype(PkgLogger.class, Collection.class));
	}
		
}
