package br.com.fabex.api.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDetailsDto {
    private String id;
    private double amount;
}
