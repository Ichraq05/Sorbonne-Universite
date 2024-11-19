package pobj.pkgman.notation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;

public class NotationBase {
	
	// stdout capture & comparison
	
	ByteArrayOutputStream out;

	public void divertStdout() {
		 out = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(out)); 
	}
	
	public String getOut() {
		System.out.flush();
		return out.toString();
	}
	
	
	// string comparison
	
	private String normalize(String r) {
		return r.replaceAll("[\n\r\t ]","");
	}
	
	public void assertEqualsNormalized(String a, String b) {
		assertEquals(normalize(a.trim()), normalize(b.trim()));
	}
	
	
	// class test
	
	static public boolean isAbstract(Class<?> c) {
		return Modifier.isAbstract(c.getModifiers());
	}
	
	static public boolean implementsInterface(Class<?> c, Class<?> itf) {
		for (Class<?> cc : c.getInterfaces()) {
			if (cc == itf) return true;
		}
		return false;
	}
	
	static public boolean inheritsFrom(Class<?> c, Class<?> p) {
		while (c != Object.class) {
			if (c == p) return true;
			c = c.getSuperclass();
		}
		return false;
	}
	
	
	// attribute test
	
	static public boolean hasOnlyPrivateAttributes(Class<?> c) {
		for (Field f : c.getDeclaredFields()) {
			if (!Modifier.isPrivate(f.getModifiers())) {
				return false;
			}
		}
		return true;
	}

	static public boolean hasOnlyFinalAttributes(Class<?> c) {
		for (Field f : c.getDeclaredFields()) {
			if (!Modifier.isFinal(f.getModifiers())) {
				return false;
			}
		}
		return true;
	}

	static public boolean hasOnlyFinalOrStaticAttributes(Class<?> c) {
		for (Field f : c.getDeclaredFields()) {
			int m = f.getModifiers();
			if (!Modifier.isFinal(m) && !Modifier.isStatic(m)) {
				return false;
			}
		}
		return true;
	}

	static public boolean hasNoAttribute(Class<?> c) {
		return c.getDeclaredFields().length == 0;
	}
	
	static public boolean hasAttributeOfType(Class<?> c, Class<?> t) {
		for (Field f : c.getDeclaredFields()) {
			if (f.getType() == t) {
				return true;
			}
		}
		return false;		
	}

	static public boolean hasAttributeOfSubtype(Class<?> c, Class<?> t) {
		for (Field f : c.getDeclaredFields()) {
			if (t.isAssignableFrom(f.getType())) {
				return true;
			}
		}
		return false;		
	}

	
	// method tests
	
	static public boolean hasMethod(Class<?> c, String name) {
		for (Method m : c.getDeclaredMethods()) {
			if (m.getName().equals(name))
				return true;
		}
		return false;		
	}

	static public boolean hasAbstractMethod(Class<?> c, String name) {
		for (Method m : c.getDeclaredMethods()) {
			int x = m.getModifiers();
			if (m.getName().equals(name) && !Modifier.isAbstract(x))
				return false;
		}
		return true;		
	}

	static public boolean hasStaticMethod(Class<?> c, String name) {
		for (Method m : c.getDeclaredMethods()) {
			int x = m.getModifiers();
			if (m.getName().equals(name) && Modifier.isStatic(x))
				return true;
		}
		return false;		
	}


}
