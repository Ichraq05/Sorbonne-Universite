package pobj.pkgman.notation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Test;

import pobj.pkgman.IPkg;
import pobj.pkgman.updater.Connector;
import pobj.pkgman.updater.IConnector;
import pobj.pkgman.updater.IDatabase;

public class Q7a extends NotationBase {
	
	@Test public void testClass() {
		
	}
	
	@Test public void testNull1()  throws IOException {
		IConnector c = new Connector("???");		
		assertNotNull(c);
		IDatabase d = c.getDatabase();
		assertNull(d);
	}

	@Test public void test1() throws IOException  {
		IConnector c = new Connector("src/pobj/pkgman/notation/example.txt");		
		assertNotNull(c);
		IDatabase d = c.getDatabase();
		assertNotNull(d);
	}

	@Test public void testNull2() throws IOException  {
		IConnector c = new Connector("src/pobj/pkgman/notation/example.txt");		
		IDatabase d = c.getDatabase();
		IPkg p = d.getPackage("???");
		assertNull(p);
	}

	@Test public void test2() throws IOException  {
		IConnector c = new Connector("src/pobj/pkgman/notation/example.txt");		
		IDatabase d = c.getDatabase();
		IPkg p = d.getPackage("java");
		assertEquals("java", p.getName());
	}

	@Test public void test3()  throws IOException {
		IConnector c = new Connector("src/pobj/pkgman/notation/example.txt");		
		IDatabase d = c.getDatabase();
		IPkg p = d.getPackage("java");
		assertEquals(8, p.getVersion().getMajor());
		assertEquals(0, p.getVersion().getMinor());
	}

	@Test public void test4()  throws IOException {
		IConnector c = new Connector("src/pobj/pkgman/notation/example.txt");		
		IDatabase d = c.getDatabase();
		IPkg p = d.getPackage("junit");
		assertEquals("junit", p.getName());
		assertEquals(4, p.getVersion().getMajor());
		assertEquals(0, p.getVersion().getMinor());
	}

@Test public void test5() throws IOException  {
		IConnector c = new Connector("src/pobj/pkgman/notation/example4.txt");		
		IDatabase d = c.getDatabase();
		IPkg p = d.getPackage("java");
		assertEquals(8, p.getVersion().getMajor());
		assertEquals(2, p.getVersion().getMinor());
	}

	@Test public void test6() throws IOException  {
		IConnector c = new Connector("src/pobj/pkgman/notation/example3.txt");		
		IDatabase d = c.getDatabase();
		IPkg p = d.getPackage("pq");
		assertEquals("pq", p.getName());
		assertEquals(9, p.getVersion().getMajor());
		assertEquals(3, p.getVersion().getMinor());
	}
	
	@Test public void test7()  throws IOException {
		IConnector c = new Connector("src/pobj/pkgman/notation/example4.txt");		
		IDatabase d = c.getDatabase();
		IPkg p1 = d.getPackage("java");
		assertEquals(8, p1.getVersion().getMajor());
		assertEquals(2, p1.getVersion().getMinor());
		assertEquals("java", p1.getName());
		IPkg p2 = d.getPackage("chose");
		assertEquals(99, p2.getVersion().getMajor());
		assertEquals(99, p2.getVersion().getMinor());
		assertEquals("chose", p2.getName());
	}

	@Test public void test8()  throws IOException {
		IConnector c = new Connector("src/pobj/pkgman/notation/example4.txt");		
		IDatabase d = c.getDatabase();
		IPkg p1 = d.getPackage("lll");
		assertNull(p1);
		IPkg p2 = d.getPackage("chose");
		assertEquals(99, p2.getVersion().getMajor());
		assertEquals(99, p2.getVersion().getMinor());
		assertEquals("chose", p2.getName());
		IPkg p3 = d.getPackage("lll");
		assertNull(p3);
	}

	@Test public void test9()  throws IOException {
		IConnector c = new Connector("src/pobj/pkgman/notation/example4.txt");		
		IDatabase d1 = c.getDatabase();
		IPkg p1 = d1.getPackage("java");
		assertEquals(8, p1.getVersion().getMajor());
		assertEquals(2, p1.getVersion().getMinor());
		assertEquals("java", p1.getName());
		IDatabase d2 = c.getDatabase();
		IPkg p2 = d2.getPackage("chose");
		assertEquals(99, p2.getVersion().getMajor());
		assertEquals(99, p2.getVersion().getMinor());
		assertEquals("chose", p2.getName());
	}

}

