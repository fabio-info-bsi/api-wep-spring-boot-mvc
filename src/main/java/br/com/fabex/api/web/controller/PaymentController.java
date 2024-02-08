package br.com.fabex.api.web.controller;

import br.com.fabex.api.web.dto.PaymentDetailsDto;
import br.com.fabex.api.web.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class PaymentController{

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody final PaymentDetailsDto paymentDetailsDto) {
        PaymentDetailsDto pd = this.paymentService.processPayment(paymentDetailsDto);
        return ResponseEntity.status(HttpStatus.OK)
                .header("timestamp", String.valueOf(System.currentTimeMillis()))
                .body(pd);
    }
}
