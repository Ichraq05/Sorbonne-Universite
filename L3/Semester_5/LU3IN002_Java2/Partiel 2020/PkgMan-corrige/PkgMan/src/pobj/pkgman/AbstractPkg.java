package pobj.pkgman;

import java.util.List;

public abstract class AbstractPkg implements IPkg {

	/*
	 * Attributs privés.
	 * Programmation vis à vis des interfaces (IVersion, List) plutôt que 
	 * des classes concrètes (Version, ArrayList). 
	 */
	private String name;
	private IVersion version;
	private List<IPkg> dependencies;

	/*
	 * Le constructeur fixe la valeur des attributs privés.
	 * Il devra être appelé par les classes concrètes qui héritent d'AbstractPkg.
	 */
	public AbstractPkg(String name, IVersion version, List<IPkg> dependencies) {
		this.name = name;
		this.version = version;
		this.dependencies = dependencies;
	}	
	
	// Accesseurs publics en lecture pour les attributs privés.

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IVersion getVersion() {
		return version;
	}

	@Override
	public List<IPkg> getDependencies() {
		return dependencies;
	}

	// Comparaison d'égalité.
	@Override
	public boolean equals(Object o) {
		// Comme dans Version, un test de type puis une conversion.
		if (!(o instanceof IPkg)) {
			return false;
		}
		IPkg p = (IPkg) o;
		// Attention, nous ne comparons plus des entiers comme dans Version,
		// il faut donc utiliser equals et pas ==.
		return version.equals(p.getVersion()) && name.equals(p.getName());
	}
	
	// Conversion en chaîne.
	@Override
	public String toString() {
		// Concatener une chaîne à un objet convertit ce dernier en chaîne par un
		// appel implicite à toString. On appelle donc bien ici version.toString().
		return name + "-" + version;
	}
}
