package com.codemovers.scholar.backoffice.helper.exception;

import com.codemovers.scholar.backoffice.helper.utilities;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author mover
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {

    private static final Logger LOG = Logger.getLogger(InternalErrorException.class.getName());

    public InternalErrorException() {
        super("INTERNAL SERVER ERROR");

    }

    public InternalErrorException(String message) {
        this(message, null);
    }

    public InternalErrorException(String message, Throwable ex) {
        super(message, ex);

        LOG.log(Level.SEVERE, message, "INTERNAL SERVER ERROR ");

        if (ex != null) {
            LOG.log(Level.SEVERE, utilities.getStackTrace(ex));
        }
    }

}
