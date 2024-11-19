package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.Version;
import pobj.pkgman.log.ILogger;
import pobj.pkgman.log.PkgLogger;

public class Q5bDelegate extends NotationBase {
	
	class MyPkg implements IPkg {

		public int getNameCalled;
		public int getVersionCalled;
		public int getDependenciesCalled;
		public int installCalled;
		public int uninstallCalled;
		public int equalsCalled;
		public int toStringCalled;
		
		@Override public String getName() {
			getNameCalled++;
			return "titi";
		}

		@Override public IVersion getVersion() {
			getVersionCalled++;
			return new Version(9,99);
		}

		@Override public List<IPkg> getDependencies() {
			getDependenciesCalled++;
			List<IPkg> l = new ArrayList<IPkg>();
			l.add(new MyPkg());
			l.add(new MyPkg());
			l.add(new MyPkg());
			return l;
		}

		@Override public boolean install() {
			installCalled++;
			return true;
		}

		@Override public void uninstall() {
			uninstallCalled++;
		}
		
		@Override public String toString() {
			toStringCalled++;
			return "titi-9.99";
		}
		
		@Override public boolean equals(Object o) {
			equalsCalled++;
			return true;
		}		
	}

	class MyPkg2 extends MyPkg {
		@Override public boolean install() { super.install(); return false; }
	}

	class MyLogger implements ILogger {
		private StringBuffer b = new StringBuffer();
		public int logCalled;
		public void log(String msg) {
			b.append(msg);
			b.append("\n");
			logCalled++;
		}
		public String getLog() {
			return b.toString();
		}
	}
	
	@Test public void testGetName() {
		MyPkg p = new MyPkg();
		PkgLogger l = new PkgLogger(p, new MyLogger());
		assertEquals(p.getName(), l.getName());
		assertEquals(2, p.getNameCalled);
	}

	@Test public void testGetVersion() {
		MyPkg p = new MyPkg();
		PkgLogger l = new PkgLogger(p, new MyLogger());
		assertEquals(p.getVersion(), l.getVersion());
		assertEquals(2, p.getVersionCalled);
	}

	@Test public void testGetDependencies() {
		MyPkg p = new MyPkg();
		PkgLogger l = new PkgLogger(p, new MyLogger());
		assertEquals(p.getDependencies(), l.getDependencies());
		assertEquals(2, p.getDependenciesCalled);
	}

	@Test public void testToString() {
		MyPkg p = new MyPkg();
		PkgLogger l = new PkgLogger(p, new MyLogger());
		assertEquals(p.toString(), l.toString());
		assertEquals(2, p.toStringCalled);
	}

	@Test public void testEquals() {
		MyPkg p = new MyPkg();
		PkgLogger l = new PkgLogger(p, new MyLogger());
		assertTrue(l.equals(l));
		assertEquals(1, p.equalsCalled);
	}

	@Test public void testInstall1() {
		MyPkg p = new MyPkg();
		MyLogger m = new MyLogger();
		PkgLogger l = new PkgLogger(p, m);
		assertTrue(l.install());
		assertEquals(1, p.installCalled);
		assertEqualsNormalized("Installing " + p + "\nSuccess\n", m.getLog());
	}
	
	@Test public void testInstall2() {
		MyPkg2 p = new MyPkg2();
		MyLogger m = new MyLogger();
		PkgLogger l = new PkgLogger(p, m);
		assertFalse(l.install());
		assertEquals(1, p.installCalled);
		assertEqualsNormalized("Installing " + p + "\nFailure\n", m.getLog());
	}
	
	@Test public void testUninstall() {
		MyPkg p = new MyPkg();
		MyLogger m = new MyLogger();
		PkgLogger l = new PkgLogger(p, m);
		l.uninstall();
		assertEquals(1, p.uninstallCalled);
		assertEqualsNormalized("Uninstalling " + p + "\n", m.getLog());
	}
	
	@Test public void testInstallUninstall() {
		MyPkg p = new MyPkg();
		MyLogger m = new MyLogger();
		PkgLogger l = new PkgLogger(p, m);
		l.install();
		l.uninstall();
		assertEqualsNormalized("Installing " + p + "\nSuccess\nUninstalling " + p + "\n", m.getLog());
	}
	
	
}
