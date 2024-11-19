package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pobj.pkgman.IManager;
import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.updater.UpdateException;
import pobj.pkgman.updater.Updater;

public class Q7cInstall {
	
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

	@Test public void testInit() throws UpdateException {
		// rien d'installé
		assertTrue(u.getInstalled().isEmpty());
	}
	
	@Test public void testInstall1() throws UpdateException {
		// install java 8
		s.add("java");
		u.installPkgs(s);
		
		assertTrue(u.getInstalled().contains("java"));
		assertEquals(1, u.getInstalled().size());
	}

	@Test public void testInstall2() throws UpdateException {
		// install java 8
		s.add("java");
		u.installPkgs(s);

		assertEquals(0, ((MyPkg)c.getPackages().get(0)).installCalled);
		assertEquals(1, ((MyPkg)c.getPackages().get(1)).installCalled);
		assertEquals(0, ((MyPkg)c.getPackages().get(2)).installCalled);
		assertEquals(0, ((MyPkg)c.getPackages().get(3)).installCalled);
	}


	@Test public void testInstall3() throws UpdateException {
		// install eclipse
		s.add("eclipse");
		u.installPkgs(s);
		
		assertTrue(u.getInstalled().contains("java"));
		assertTrue(u.getInstalled().contains("junit"));
		assertTrue(u.getInstalled().contains("eclipse"));
		assertEquals(3, u.getInstalled().size());
	}

	@Test public void testInstall4() throws UpdateException {
		// install eclipse
		s.add("eclipse");
		u.installPkgs(s);
	
		assertEquals(1, ((MyPkg)c.getPackages().get(0)).installCalled);
		assertEquals(1, ((MyPkg)c.getPackages().get(1)).installCalled);
		assertEquals(1, ((MyPkg)c.getPackages().get(2)).installCalled);
		assertEquals(1, ((MyPkg)c.getPackages().get(3)).installCalled);
		assertEquals(1, ((MyPkg)c.getPackages().get(0)).uninstallCalled);
	}

	@Test public void testInstall5() throws UpdateException {
		// install eclipse
		s.add("junit");
		s.add("eclipse");
		u.installPkgs(s);
	
		assertEquals(1, ((MyPkg)c.getPackages().get(1)).installCalled);
		assertEquals(1, ((MyPkg)c.getPackages().get(2)).installCalled);
		assertEquals(1, ((MyPkg)c.getPackages().get(3)).installCalled);
	}

	@Test public void testReinstall1() throws UpdateException {
		// install eclipse
		s.add("eclipse");
		u.installPkgs(s);
		MyPkg java1 =(MyPkg)c.getPackages().get(1);
		
		// reinstall Java
		s.clear();
		s.add("java");
		u.installPkgs(s);
		MyPkg java2 =(MyPkg)c.getPackages().get(1);
	
		assertEquals(1, java1.installCalled + java2.installCalled);
	}

	@Test public void testReinstall2() throws UpdateException {
		// install java 8
		s.add("java");
		u.installPkgs(s);
		
		MyPkg java1 =(MyPkg)c.getPackages().get(1);
		assertEquals("java", java1.getName());
		assertEquals(8,  java1.getVersion().getMajor());
		assertEquals(0,  java1.getVersion().getMinor());
		assertEquals(1, java1.installCalled);

		// reinstall to 8.2 with new database
		c.setFile("src/pobj/pkgman/notation/example4.txt");
		u.installPkgs(s);

		MyPkg java2 =(MyPkg)c.getPackages().get(1);
		assertEquals("java", java2.getName());
		assertEquals(8,  java2.getVersion().getMajor());
		assertEquals(2,  java2.getVersion().getMinor());
		assertEquals(1, java1.uninstallCalled);
		assertEquals(1, java2.installCalled);
	}

	@Test(expected=UpdateException.class)
	public void testError() throws UpdateException {
		s.add("unknown");
		u.installPkgs(s);
	}
	
	//////
	
	@Test public void testClose1() throws UpdateException {
		s.add("java");
		u.installPkgs(s);
		assertEquals(1, c.nbClosed);		
	}

	@Test public void testClose2() {
		s.add("unknown");
		try { 	u.installPkgs(s); } 
		catch (UpdateException e) { }
		assertEquals(1, c.nbClosed);		
	}


}