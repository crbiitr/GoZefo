package com.api.exceptions;

import lombok.NoArgsConstructor;

/**
 * Created by chetan on 30/1/18.
 */
@NoArgsConstructor
public class ParameterMissingException extends Exception {
    public ParameterMissingException(String message) {
        super(message);
    }
}
