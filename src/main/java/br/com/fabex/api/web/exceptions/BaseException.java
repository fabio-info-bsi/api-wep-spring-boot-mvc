package br.com.fabex.api.web.exceptions;

import br.com.fabex.api.web.exceptions.dto.ErrorDetails;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private final ErrorDetails errorDetails;

    public BaseException(ErrorDetails errorDetails) {
        super(errorDetails.getMessage());
        this.errorDetails = errorDetails;
    }

}
