package org.aaronquitech.marvel.rest.exception.customized;

/**
 * Excepción para datos no encontrados.
 *
 * @author Aaron Quiñonez
 * @since 03/02/2025
 */
public class NotDataFoundException extends RuntimeException {

	/** Serial Version. */
	private static final long serialVersionUID = 964157509649920266L;
	/** Propiedad de codigo error. */
	private String code;

	/** Metodo getter. */
	public String getCode() {
		return code;
	}

	/** Constructor de la clase. */
	public NotDataFoundException() {
		super();
	}

	/**
	 * Constructor de la clase.
	 *
	 * @param message mensaje de error
	 */
	public NotDataFoundException(String message) {
		super(message);
	}

	/**
	 * Constructor de la clase.
	 *
	 * @param code codigo de error
	 * @param message mensaje de error
	 */
	public NotDataFoundException(String code, String message) {
		super(message);
		this.code = code;
	}
}
