//Autor:Oscar Lopera

package Exeption;

//En esta clase manejamos las excepciones

public class ExeptionLopera extends Exception{

	public ExeptionLopera() {
		super();
	}

	public ExeptionLopera(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExeptionLopera(String message, Throwable cause) {
		super(message, cause);
	}

	public ExeptionLopera(String message) {
		super(message);
	}

	public ExeptionLopera(Throwable cause) {
		super(cause);
	}

}
