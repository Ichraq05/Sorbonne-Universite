package pobj.pkgman.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	VersionTest.class,
	LimitPkgTest.class,
	ManagerTest.class,
	SimplePkgAdapterTest.class,
	LogBufferTest.class,
	PkgLoggerTest.class,
	ManagerVersionTest.class,
	ConnectorTest.class,
	UpdaterTest.class,
})

public class TestAll {
	/* vide */
}
