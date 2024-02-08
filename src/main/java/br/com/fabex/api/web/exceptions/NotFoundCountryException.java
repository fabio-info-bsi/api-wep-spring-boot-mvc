package br.com.fabex.api.web.exceptions;

import br.com.fabex.api.web.exceptions.dto.ErrorDetails;

public class NotFoundCountryException extends BaseException{

    public NotFoundCountryException() {
        super(new ErrorDetails(404, "Not Founf Country"));
    }
    public NotFoundCountryException(ErrorDetails errorDetails) {
        super(errorDetails);
    }
}
