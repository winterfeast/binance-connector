package kz.app.binanceconnector.service;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.NewOrder;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import kz.app.binanceconnector.dto.NewOrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final BinanceApiRestClient client;

    public List<Order> getAllOrders(String symbol) {
        return client.getAllOrders(new AllOrdersRequest(symbol));
    }
    
    public NewOrderResponse create(NewOrderDto orderDto) {
        log.info("Create order by dto: {}", orderDto);

        NewOrder order = new NewOrder(
                orderDto.symbol(),
                orderDto.side(),
                orderDto.type(),
                null,
                orderDto.quantity());
        order.quoteOrderQty(orderDto.quoteOrderQty());

        log.info("Order created: {}", order);

        return client.newOrder(order);
    }
}
