package pobj.pkgman.notation;

import java.util.List;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.loader.Sample;

public class Q2Print1 extends NotationBase {
	

	class PkgFactory implements IPkgFactory {

		// test vis à vis de l'implantation correcte d'IPkg
		@Override
		public IPkg newPkg(String name, IVersion version, List<IPkg> dependencies) {
			return new NotationPkg(name, version, dependencies);
		}
		
	}
	
	@Test public void testPrintPkgs() throws Exception {
		divertStdout();
		NotationPkgLoader l = new NotationPkgLoader("src/pobj/pkgman/notation/example2.txt", new PkgFactory());
		Sample.printPkgs(l.getPackages());
		assertEqualsNormalized(
				"toto-1.0:\n" +
				"titi-2.0: toto-1.0\n" +
				"super-6.66: titi-2.0 toto-1.0\n",
				getOut());
	}
}
