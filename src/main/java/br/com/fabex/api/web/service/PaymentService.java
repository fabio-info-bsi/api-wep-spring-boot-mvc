package br.com.fabex.api.web.service;

import br.com.fabex.api.web.dto.PaymentDetailsDto;
import br.com.fabex.api.web.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetailsDto processPayment(final PaymentDetailsDto paymentDetailsDto) {
        if(paymentDetailsDto.getAmount() <= 0){
            throw new NotEnoughMoneyException();
        }
        return paymentDetailsDto;
    }
}
