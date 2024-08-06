package br.com.fabex.api.web.controller;

import br.com.fabex.api.web.dto.PaymentDetailsDto;
import br.com.fabex.api.web.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
public class PaymentController{

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody final PaymentDetailsDto paymentDetailsDto,
                                         @RequestHeader final Map<String, String> headers) {
        log.info("Request Body: {}", paymentDetailsDto);
        PaymentDetailsDto pd = this.paymentService.processPayment(paymentDetailsDto);
        return ResponseEntity.status(HttpStatus.OK)
                .header("timestamp", String.valueOf(System.currentTimeMillis()))
                .body(pd);
    }

    @PostMapping("/payment-delay")
    public ResponseEntity<?> makePaymentDelay(@RequestBody final PaymentDetailsDto paymentDetailsDto,
                                              @RequestHeader final Map<String, String> headers) {
        log.info("Delay Request {}", paymentDetailsDto);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PaymentDetailsDto pd = this.paymentService.processPayment(paymentDetailsDto);
        return ResponseEntity.status(HttpStatus.OK)
                .header("timestamp", String.valueOf(System.currentTimeMillis()))
                .body(pd);
    }

    @PostMapping("/payment-bad-request")
    public ResponseEntity<?> makePaymentBadRequest(@RequestBody final PaymentDetailsDto paymentDetailsDto,
                                              @RequestHeader final Map<String, String> headers) {
        log.info("Bad Request {}", paymentDetailsDto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
