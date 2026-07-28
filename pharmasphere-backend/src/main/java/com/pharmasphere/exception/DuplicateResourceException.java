package com.pharmasphere.exception;

import java.util.Map;

/**
 * Duplicate Resource Exception.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 28-07-2026
 */
public class DuplicateResourceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Map<String, String> errors;

    public DuplicateResourceException(Map<String, String> errors) {
        super("Duplicate resource found.");
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}