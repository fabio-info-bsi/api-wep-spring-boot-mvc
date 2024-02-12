package br.com.fabex.api.web.controller;

import br.com.fabex.api.web.model.Purchase;
import br.com.fabex.api.web.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @PostMapping
    public void save(@RequestBody Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @GetMapping
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }
}
