package edu.gonet.vuelos.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
* Excepciones para informar incorrecta implementación de los servicios.
*/
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidReceivedDataException extends RuntimeException {
    /**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see java.lang.RuntimeException#Exception()
     */
    public InvalidReceivedDataException () {
        super();
    }

    /**
     * @param  message el mensaje detallado (el cual es alamcenado para su 
     *         posterior obtención por el método {@link #getMessage()}).
     * @see java.lang.RuntimeException#Exception(String message)
     */
    public InvalidReceivedDataException (String message) {
        super(message);
    }
    
    /**
     * @param  message el mensaje detallado (el cual es alamcenado para su 
     *         posterior obtención por el método {@link #getMessage()}).
     * @param  cause el motivo (el cual es alamcenado para su posterior obtención
     *         por el método {@link #getCause()}).  (Un valor <tt>null</tt>
     *         es permitido, e indidcaque no existe una causa o no es conocida)
     * @see java.lang.RuntimeException#Exception(String message, Throwable cause)
     */
    public InvalidReceivedDataException (String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param  cause el motivo (el cual es alamcenado para su posterior obtención
     *         por el método {@link #getCause()}).  (Un valor <tt>null</tt>
     *         es permitido, e indidcaque no existe una causa o no es conocida)
     * @see java.lang.RuntimeException#Exception(Throwable cause)
     */
    public InvalidReceivedDataException (Throwable cause) {
        super(cause);
    }
}
