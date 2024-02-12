package br.com.fabex.api.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private Long id;
    private String product;
    private BigDecimal price;
}
