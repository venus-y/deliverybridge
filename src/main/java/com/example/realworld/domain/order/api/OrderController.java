package com.example.realworld.domain.order.api;

import com.example.realworld.domain.order.dto.OrderRequestDto;
import com.example.realworld.domain.order.dto.OrderResponseDto;
import com.example.realworld.domain.order.service.OrderService;
import com.example.realworld.domain.user.entity.CurrentUser;
import com.example.realworld.domain.user.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/")
    public void register(@Valid @RequestBody OrderRequestDto orderRequestDto, @CurrentUser User user) {
        orderService.processOrder(orderRequestDto, user.getUsername());
    }

    @PutMapping("/{orderId}/approval")
    public void approve(@PathVariable(name = "orderId") Long orderId, @CurrentUser User user) {
        orderService.approveOrder(orderId, user.getId());

    }

    @GetMapping("/")
    public ResponseEntity<Page<OrderResponseDto>> getOrderList(Pageable pageable) {
        Page<OrderResponseDto> orderResponseDtoList = orderService.getOrderList(pageable);
        return ResponseEntity.ok(orderResponseDtoList);
    }


}
