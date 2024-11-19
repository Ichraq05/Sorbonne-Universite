package pobj.micros.scheduler;

public class Service implements IService {

	private  final String name;
	private final int version;
	
	public Service(String name, int version) {
		this.name = name;
		this.version = version;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return getName() + "/" + getVersion();
	}
	
	@Override
	public boolean equals(Object x) {
		if (x instanceof IService) {
			IService y = (IService) x;
			return getName().equals(y.getName()) && version == y.getVersion();
		}
		else return false;
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode() + getVersion();
	}
}
