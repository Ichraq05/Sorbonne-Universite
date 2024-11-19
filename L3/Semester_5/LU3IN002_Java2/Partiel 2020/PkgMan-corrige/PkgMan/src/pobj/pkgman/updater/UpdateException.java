package pobj.pkgman.updater;

// Les exceptions normales héritent d'Exception.
public class UpdateException extends Exception {

	// Ceci permet d'éviter un "warning" d'Eclipse, mais n'est pas indispensable.
	private static final long serialVersionUID = 1L;

	public UpdateException(String msg) {
		// Le constructeur se contente de déléguer au bon constructeur du
		// parent Exception. Il fixe le message d'erreur.
		super(msg);
	}
}
