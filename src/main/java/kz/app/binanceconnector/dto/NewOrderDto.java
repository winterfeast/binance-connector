package kz.app.binanceconnector.dto;

import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;

public record NewOrderDto(
        String symbol,
        OrderSide side,
        OrderType type,
        String quantity,
        String quoteOrderQty
) { }
