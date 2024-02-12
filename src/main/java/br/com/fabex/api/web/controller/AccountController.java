package br.com.fabex.api.web.controller;

import br.com.fabex.api.web.dto.TransferRequest;
import br.com.fabex.api.web.model.Account;
import br.com.fabex.api.web.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private TransferService transferService;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }
}
