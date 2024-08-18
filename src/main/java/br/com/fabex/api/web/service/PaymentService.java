package br.com.fabex.api.web.service;

import br.com.fabex.api.web.dto.PaymentDetailsDto;
import br.com.fabex.api.web.exceptions.NotEnoughMoneyException;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class PaymentService {

    public PaymentDetailsDto processPayment(final PaymentDetailsDto paymentDetailsDto) {
        if(paymentDetailsDto.getAmount() <= 0){
            throw new NotEnoughMoneyException();
        }
        String paymentId = UUID.randomUUID().toString();
        log.info("paymentId UUID genereted: {}", paymentId);
        return new PaymentDetailsDto(paymentId, paymentDetailsDto.getAmount());
    }

    @PreDestroy
    public void destroy() throws InterruptedException {
        //business destroy (wait for 10s)
        Thread.sleep(10000);
        log.info("destroy PaymentService...");
    }
}
