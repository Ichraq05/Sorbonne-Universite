package pobj.pkgman;

import java.util.List;

public abstract class AbstractPkg implements IPkg {
	private String nom;
	private IVersion version;
	private List<IPkg> depenses;
	
	public AbstractPkg(String nom, IVersion version, List<IPkg> depenses) {
		this.nom = nom;
		this.version = version;
		this.depenses = depenses;
	}	
	
	/** Retourne le nom du paquet. */
	public String getName() {
		return nom;
	}
	
	/** Retourne la version du paquet. */
	public IVersion getVersion() {
		return version;
	}
	
	/** Retourne la liste de dépendances du paquet. */
	public List<IPkg> getDependencies(){
		return depenses;
	}

	/** 
	 * Installe un paquet.
	 * Retourne true en cas de succès, false en cas d'échec.
	 */
	public abstract boolean install();
	
	/**
	 * Désinstalle un paquet
	 * N'échoue jamais.
	 */
	public abstract void uninstall();
	
	/** 
	 * Comparaison d'égalité.
	 * Le nom et le numéro de version de this et de o doivent correspondre.
	 */
	public boolean equals(Object o) {
		if(this == o) {return true; }
		
		if(!(o instanceof IPkg)) {
			return false;
		}
		
		IPkg i = (IPkg) o;
		
		return version.equals(i.getVersion()) && nom.equals(i.getName());
	}
	
	
	/** Conversion en chaîne de la forme nom-version. */
	public String toString() {
		return nom + "-" + version;
	}
	
}
