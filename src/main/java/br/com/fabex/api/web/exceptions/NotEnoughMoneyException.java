package br.com.fabex.api.web.exceptions;

import br.com.fabex.api.web.exceptions.dto.ErrorDetails;

public class NotEnoughMoneyException extends BaseException{

    public NotEnoughMoneyException() {
        super(new ErrorDetails(41, "Not Money"));
    }
    public NotEnoughMoneyException(ErrorDetails errorDetails) {
        super(errorDetails);
    }
}
