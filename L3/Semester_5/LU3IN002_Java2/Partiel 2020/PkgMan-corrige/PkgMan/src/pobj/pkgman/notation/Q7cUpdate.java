package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.IManager;
import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.updater.UpdateException;
import pobj.pkgman.updater.Updater;

public class Q7cUpdate {
	
	private int totalInstalled;
	
	class MyPkg extends NotationAbstractPkg {

		public int installCalled;
		public int uninstallCalled;

		public MyPkg(String name, IVersion version, List<IPkg> dependencies) {
			super(name, version, dependencies);
		}

		@Override public boolean install() {
			if (totalInstalled >= 10) {
				return false;
			}
			installCalled++;
			totalInstalled++;
			return true;
		}

		@Override public void uninstall() {
			uninstallCalled++;
		}		
	}

	
	class PkgFactory implements IPkgFactory {
		@Override
		public IPkg newPkg(String name, IVersion version, List<IPkg> dependencies) {
			return new MyPkg(name, version, dependencies);
		}
	}
	
	
	////////////////////////////////////////////////////////////////

	private NotationConnector c = new NotationConnector("src/pobj/pkgman/notation/example.txt", new PkgFactory());
	private IManager m = new NotationManagerVersion();
	private Updater  u = new Updater(c, m);
	private ArrayList<String> s = new ArrayList<>();

	@Test public void testUpdate() throws UpdateException {
		// install java 8
		s.add("java");
		u.installPkgs(s);
		
		MyPkg java1 =(MyPkg)c.getPackages().get(1);
		assertEquals("java", java1.getName());
		assertEquals(8,  java1.getVersion().getMajor());
		assertEquals(0,  java1.getVersion().getMinor());
		assertEquals(1, java1.installCalled);

		// update to 8.2 with new database
		c.setFile("src/pobj/pkgman/notation/example4.txt");
		u.updateWorld();

		MyPkg java2 =(MyPkg)c.getPackages().get(1);
		assertEquals("java", java2.getName());
		assertEquals(8,  java2.getVersion().getMajor());
		assertEquals(2,  java2.getVersion().getMinor());
		assertEquals(1, java1.uninstallCalled);
		assertEquals(1, java2.installCalled);
	}

	@Test public void testUpdate2() throws UpdateException {
		// install eclipse
		s.add("eclipse");
		u.installPkgs(s);
		
		MyPkg java1 =(MyPkg)c.getPackages().get(1);
		assertEquals("java", java1.getName());
		assertEquals(8,  java1.getVersion().getMajor());
		assertEquals(0,  java1.getVersion().getMinor());
		assertEquals(1, java1.installCalled);

		// update to java 8.2 with new database
		c.setFile("src/pobj/pkgman/notation/example4.txt");
		u.updateWorld();

		MyPkg java2 =(MyPkg)c.getPackages().get(1);
		assertEquals("java", java2.getName());
		assertEquals(8,  java2.getVersion().getMajor());
		assertEquals(2,  java2.getVersion().getMinor());
		assertEquals(1, java1.uninstallCalled);
		assertEquals(1, java2.installCalled);
	}

}
