package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.ManagerVersion;

public class Q6 extends NotationBase {

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
	
	
	@Test public void testInstall0() throws IOException {
		ManagerVersion m = new ManagerVersion();
		assertTrue(m.getInstalled().isEmpty());
	}
		
	@Test public void testInstall1() throws IOException {
		// install java-7.0
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		assertTrue(m.getInstalled().isEmpty());
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
	}
	
	@Test public void testInstall2() throws IOException {
		// install java-7.0
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		assertTrue(m.getInstalled().isEmpty());
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.getInstalled().contains(pkgs.get(0)));
	}
	
	@Test public void testInstall3() throws IOException {
		// install junit-4.0 -> install java-8.0
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(2)));
		assertEquals(1, ((MyPkg)pkgs.get(1)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(2)).installCalled);
	}
	
	@Test public void testInstall4() throws IOException {
		// install junit-4.0 -> install java-8.0
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(2)));
		assertTrue(m.getInstalled().contains(pkgs.get(1)));
		assertTrue(m.getInstalled().contains(pkgs.get(2)));
		assertEquals(2, m.getInstalled().size());
	}
	
	@Test public void testInstall5() throws IOException {
		// install eclipse-4.6 -> install java-7.0 junit-4.0 -> install java-8.0
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(3)));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(1)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(2)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(3)).installCalled);
	}

	@Test public void testInstall6() throws IOException {
		// install eclipse-4.6 -> install java-7.0 junit-4.0 -> install java-8.0
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(3)));
		assertFalse(m.getInstalled().contains(pkgs.get(0)));
		assertTrue(m.getInstalled().contains(pkgs.get(1)));
		assertTrue(m.getInstalled().contains(pkgs.get(2)));
		assertTrue(m.getInstalled().contains(pkgs.get(3)));
		assertEquals(3, m.getInstalled().size());
	}

	@Test public void testInstall7() throws IOException {
		// install java-7.0 twice
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.installPkg(pkgs.get(0)));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
	}
	
	@Test public void testInstall8() throws IOException {
		// update uninstalls previous version
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.installPkg(pkgs.get(1)));
		assertEquals(1, m.getInstalled().size());
	}
	
	@Test public void testInstall9() throws IOException {
		// update uninstalls previous version
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.installPkg(pkgs.get(1)));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(1)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(0)).uninstallCalled);
		assertEquals(0, ((MyPkg)pkgs.get(1)).uninstallCalled);
	}
	
	@Test public void testInstall10() throws IOException {
		// downgrades has no effect
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(1)));
		assertTrue(m.installPkg(pkgs.get(0)));
		assertEquals(0, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(1)).installCalled);
		assertEquals(0, ((MyPkg)pkgs.get(0)).uninstallCalled);
		assertEquals(0, ((MyPkg)pkgs.get(1)).uninstallCalled);
	}
	
	@Test public void testInstall11() throws IOException {
		// installed dependencies are not reinstalled
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.installPkg(pkgs.get(1)));
		assertTrue(m.installPkg(pkgs.get(2)));
		assertTrue(m.installPkg(pkgs.get(3)));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(1)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(2)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(3)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(0)).uninstallCalled);
		assertEquals(0, ((MyPkg)pkgs.get(1)).uninstallCalled);
		assertEquals(0, ((MyPkg)pkgs.get(2)).uninstallCalled);
		assertEquals(0, ((MyPkg)pkgs.get(3)).uninstallCalled);
	}
	
	
	////////////////////////////////////////////////////////////////
		
	@Test public void testUninstall1() throws IOException {
		// install java-7.0 and uninstall
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();

		assertTrue(m.installPkg(pkgs.get(0)))		;
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		
		m.uninstallPkg(pkgs.get(0));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(0)).uninstallCalled);
	}

	@Test public void testUninstall2() throws IOException {
		// install java-7.0 and uninstall
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();

		assertTrue(m.installPkg(pkgs.get(0)))		;
		assertTrue(m.getInstalled().contains(pkgs.get(0)));		
		assertEquals(1, m.getInstalled().size());
		
		m.uninstallPkg(pkgs.get(0));
		assertTrue(m.getInstalled().isEmpty());
	}

	@Test public void testUninstall3() throws IOException {
		// install java-7.0, uninstall, reinstall
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		
		m.uninstallPkg(pkgs.get(0));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(0)).uninstallCalled);
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertEquals(2, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(1, ((MyPkg)pkgs.get(0)).uninstallCalled);
	}

	@Test public void testUninstall4() throws IOException {
		// install java-7.0, uninstall, reinstall
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.getInstalled().contains(pkgs.get(0)));
		assertEquals(1, m.getInstalled().size());
		
		m.uninstallPkg(pkgs.get(0));
		assertTrue(m.getInstalled().isEmpty());
		
		assertTrue(m.installPkg(pkgs.get(0)));
		assertTrue(m.getInstalled().contains(pkgs.get(0)));
		assertEquals(1, m.getInstalled().size());
	}

	@Test public void testUninstall5() throws IOException {
		// install not installed
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();

		assertTrue(m.installPkg(pkgs.get(0)));
		m.uninstallPkg(pkgs.get(1));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(0, ((MyPkg)pkgs.get(1)).uninstallCalled);
	}

	@Test public void testUninstall6() throws IOException {
		// install not installed
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();

		assertTrue(m.installPkg(pkgs.get(0)));
		m.uninstallPkg(pkgs.get(1));
		assertEquals(1, ((MyPkg)pkgs.get(0)).installCalled);
		assertEquals(0, ((MyPkg)pkgs.get(1)).uninstallCalled);
	}

	
	@Test public void testUninstall7() throws IOException {
		// install eclipse-4.6, uninstall, rest should remain installed
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();

		assertTrue(m.installPkg(pkgs.get(3)));
		m.uninstallPkg(pkgs.get(3));
		assertEquals(1, ((MyPkg)pkgs.get(0)).uninstallCalled);
		assertEquals(0, ((MyPkg)pkgs.get(1)).uninstallCalled);
		assertEquals(0, ((MyPkg)pkgs.get(2)).uninstallCalled);
		assertEquals(1, ((MyPkg)pkgs.get(3)).uninstallCalled);
	}
	
	@Test public void testUninstall8() throws IOException {
		// install eclipse-4.6, uninstall, rest should remain installed
		List<IPkg> pkgs = (new NotationPkgLoader("src/pobj/pkgman/notation/example.txt", new PkgFactory())).getPackages();
		ManagerVersion m = new ManagerVersion();

		assertTrue(m.installPkg(pkgs.get(3)));
		assertEquals(3, m.getInstalled().size());
		assertFalse(m.getInstalled().contains(pkgs.get(0)));
		assertTrue(m.getInstalled().contains(pkgs.get(1)));
		assertTrue(m.getInstalled().contains(pkgs.get(2)));
		assertTrue(m.getInstalled().contains(pkgs.get(3)));

		m.uninstallPkg(pkgs.get(3));
		assertEquals(2, m.getInstalled().size());
		assertFalse(m.getInstalled().contains(pkgs.get(0)));
		assertTrue(m.getInstalled().contains(pkgs.get(1)));
		assertTrue(m.getInstalled().contains(pkgs.get(2)));
		assertFalse(m.getInstalled().contains(pkgs.get(3)));
	}

}
