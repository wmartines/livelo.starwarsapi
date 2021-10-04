package br.com.livelo.starwarsapi.exception;

import java.text.MessageFormat;

/**
 * Class created to handle application runtime exceptions
 *
 * @author Rodrigo G. Tavares de Souza
 * @see RuntimeException
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8910991775522741961L;

	/**
	 * Contructor
	 */
    public BusinessException() {
        super();
    }

    /**
     * Creates an exception informing the key of the error message, 
     * its cause, and message parameters
     *
     * @param message
     * @param cause
     * @param params
     */
    public BusinessException(String message, Throwable cause, Object... params) {
        super(MessageFormat.format(message, params), cause);
    }

    /**
     * Creates an exception by entering the error message key and the message parameters
     *
     * @param message
     * @param params
     */
    public BusinessException(String message, Object... params) {
        super(MessageFormat.format(message, params));
    }

    /**
     * Creates an exception stating only its cause
     *
     * @param cause 
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }
}