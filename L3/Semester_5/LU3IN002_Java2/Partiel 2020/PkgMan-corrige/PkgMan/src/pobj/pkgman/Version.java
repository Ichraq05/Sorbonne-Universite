package pobj.pkgman;

public class Version implements IVersion {

	// Tous les attributs doivent être privés et "final" (constants).
	private final int major;
	private final int minor;
	
	// Le constructeur fixe les attributs constants.
	public Version(int major, int minor) {
		this.major = major;
		this.minor = minor;
	}

	// Accesseurs publics en lecture pour les attributs privés.

	// Utiliser @Override permet de s'assurer qu'on ne s'est pas trompé dans le
	// nom des méthodes ou les types des arguments
	
	@Override
	public int getMajor() {
		return major;
	}	

	@Override
	public int getMinor() {
		return minor;
	}
		
	// Conversion en chaîne.
	@Override
	public String toString() {
		// Concatener une chaîne à un entier convertit automatiquement
		// ce dernier en chaîne.
		return major + "." + minor;
	}
	
	// Comparaison d'égalité.
	@Override
	public boolean equals(Object o) {
		// Test de type, vis à vis de l'interface (et non de la classe)
		// pour plus de généralité.
		if (!(o instanceof IVersion)) {
			return false;
		}
		// Conversion de type, pour acceder à getMajor et getMinor.
		// Le test instanceof garantit que la conversion n'échoue jamais.
		IVersion v = (IVersion) o;
		// Comparaison des attributs.
		return major == v.getMajor() && minor == v.getMinor();
	}

	// Opérateur d'ordre : retourne -1, 0 ou 1.
	@Override
	public int compareTo(IVersion v) {
		// Cas numéro majeur différent.
		if (major > v.getMajor()) return 1;
		if (major < v.getMajor()) return -1;
		// Cas numéro majeur égal.
		if (minor > v.getMinor()) return 1;
		if (minor < v.getMinor()) return -1;
		// Cas d'égalité.
		return 0;
	}

	/*
	 * La version 1.0 est créée au chargement de la classe, et stockée dans une
	 * variable statique (toujours privée).
	 */
	private static Version defaultVersion = new Version(1,0);
	
	// Retourne la version 1.0.
	public static Version getDefaultVersion() {
		// Attention, pas de new : c'est toujours le même objet qui est retourné.
		// On a donc : Version.getDefaultVersion() == Version.getDefaultVersion().
		return defaultVersion;
	}
	
}
