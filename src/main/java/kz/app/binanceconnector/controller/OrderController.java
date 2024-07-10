package kz.app.binanceconnector.controller;

import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import kz.app.binanceconnector.dto.NewOrderDto;
import kz.app.binanceconnector.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{symbol}")
    public List<Order> getAllOrders(
            @PathVariable("symbol") String symbol
    ) {
        return orderService.getAllOrders(symbol);
    }

    @PostMapping("/create")
    public NewOrderResponse createOrder(@RequestBody NewOrderDto order) {
        return orderService.create(order);
    }
}