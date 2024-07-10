package kz.app.binanceconnector.service;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.AssetBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static kz.app.binanceconnector.util.BinanceUtil.isNotZeroValue;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final BinanceApiRestClient binanceApiRestClient;

    public List<AssetBalance> getWalletDetails() {
        return binanceApiRestClient.getAccount()
                .getBalances()
                .stream()
                    .filter(assetBalance -> isNotZeroValue(assetBalance.getFree())
                                          | isNotZeroValue(assetBalance.getLocked())
                    ).toList();
    }
}
