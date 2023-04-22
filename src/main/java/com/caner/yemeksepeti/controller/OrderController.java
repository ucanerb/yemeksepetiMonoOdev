package com.caner.yemeksepeti.controller;

import com.caner.yemeksepeti.dto.request.SaveOrderRequestDto;
import com.caner.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.caner.yemeksepeti.dto.response.SaveOrderResponseDto;
import com.caner.yemeksepeti.repository.entity.Order;
import com.caner.yemeksepeti.repository.entity.Restaurant;
import com.caner.yemeksepeti.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.caner.yemeksepeti.constant.EndPointList.*;
import static com.caner.yemeksepeti.constant.EndPointList.FIND_ALL;

@RestController
@RequiredArgsConstructor
@RequestMapping(ORDER)
public class OrderController {
    private final OrderService orderService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveOrderRequestDto dto){
        orderService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping(FIND_ALL_ORDER_BY_CUSTOMERID)
    public ResponseEntity<List<Order>> findAllOrderByCustomerId(@PathVariable Long customerId){
        return ResponseEntity.ok(orderService.findAllOrderByCustomerId(customerId));
    }
    @GetMapping(FIND_ALL_ORDER_BY_RESTAURANTID)
    public ResponseEntity<List<Order>> findAllOrderByRestaurantId(@PathVariable Long restaurantId){
        return ResponseEntity.ok(orderService.findAllOrderByRestaurantId(restaurantId));
    }
}
