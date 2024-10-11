package com.example.realworld.domain.delivery.api;

import com.example.realworld.domain.delivery.dto.DeliveryResponseDto;
import com.example.realworld.domain.delivery.service.DeliveryService;
import com.example.realworld.domain.user.dto.RiderLocationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/{orderId}/riders/{riderId}")
    public ResponseEntity<DeliveryResponseDto> acceptDelivery(@PathVariable Long orderId, @PathVariable Long riderId) {
        DeliveryResponseDto responseDto = deliveryService.acceptDelivery(orderId, riderId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{riderId}/location")
    public ResponseEntity<RiderLocationResponseDto> getRiderLocation(@PathVariable Long riderId) {
        RiderLocationResponseDto locationResponse = deliveryService.getRiderLocation(riderId);
        return ResponseEntity.ok(locationResponse);
    }
}
