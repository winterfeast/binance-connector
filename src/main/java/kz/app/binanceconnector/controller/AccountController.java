package kz.app.binanceconnector.controller;

import com.binance.api.client.domain.account.AssetBalance;
import kz.app.binanceconnector.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/wallet")
    public List<AssetBalance> getWalletDetails() {
        return accountService.getWalletDetails();
    }
}
