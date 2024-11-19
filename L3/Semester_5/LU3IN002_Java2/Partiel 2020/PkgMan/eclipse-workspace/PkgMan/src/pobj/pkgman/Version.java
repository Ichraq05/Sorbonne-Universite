package pobj.pkgman;

public class Version implements IVersion{
	private final int major;
	private final int minor;
	
	public Version(int major, int minor) {
		this.major = major;
		this.minor = minor;
	}
	@Override
	public int getMajor() {
		// TODO Auto-generated method stub
		return major;
	}

	@Override
	public int getMinor() {
		// TODO Auto-generated method stub
		return minor;
	}
	
	public boolean equals(Object o) {
		if(this == o) { return true;  }
		
		if(!(o instanceof Version)) { return false; }
		
		Version v = (Version)o;
		
		return this.major == v.major && this.minor == v.minor;
	}
	
	public String toString() {
		return this.major + "." + this.minor;
	}

	@Override
	public int compareTo(IVersion v) {
		// TODO Auto-generated method stub
		
		if(v.getMajor() < this.major || (v.getMajor() == this.major && v.getMinor() < this.minor)) {
			return 1;
		}
		else if(v.getMajor() == this.major) {
			return 0;
		}
		return -1;
	}
	

	private static final Version defaultVersion = new Version(1, 0);

	public static Version getDefaultVersion() {
	    return defaultVersion;
	}


}
