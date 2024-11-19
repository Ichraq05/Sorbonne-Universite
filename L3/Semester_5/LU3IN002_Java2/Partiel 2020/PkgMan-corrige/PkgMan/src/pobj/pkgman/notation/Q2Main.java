package pobj.pkgman.notation;

import java.util.List;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;
import pobj.pkgman.LimitPkg;
import pobj.pkgman.loader.Sample;

public class Q2Main extends NotationBase {
	
	class PkgFactory implements IPkgFactory {

		@Override
		public IPkg newPkg(String name, IVersion version, List<IPkg> dependencies) {
			return new LimitPkg(name, version, dependencies);
		}
		
	}
	
	@Test public void testMain() throws Exception {
		divertStdout();
		Sample.main(new String[0]);
		assertEqualsNormalized(
				"java-7.0:\n" + 
				"java-8.0:\n" + 
				"junit-4.0: java-8.0\n" + 
				"eclipse-4.6: java-7.0 junit-4.0\n",
				getOut());
	}
}
