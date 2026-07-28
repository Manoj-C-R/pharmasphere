package com.pharmasphere.exception;

/**
 * Resource Not Found Exception.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 28-07-2026
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}