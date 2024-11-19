package pobj.pkgman.log;

public class LogBuffer implements ILogger {

	/*
	 * Nous utilisons un StringBuilder pour ajouter avec un coût linéaire en 
	 * la taille de la chaîne ajoutée (et non en la taille du log).
	 * Utiliser un StringBuffer, un StringJointer, ou même une List<String> étaient
	 * également des réponses acceptables.
	 */
	private StringBuilder buf = new StringBuilder();
	
	@Override
	public void log(String msg) {
		buf.append(msg);
		buf.append('\n');
	}

	@Override
	public String getLog() {
		return buf.toString();
	}
}
