package com.example.realworld.domain.shop.api;

import com.example.realworld.domain.order.dto.NotificationRequestDto;
import com.example.realworld.domain.shop.dto.ShopRegisterDto;
import com.example.realworld.domain.shop.service.ShopService;
import com.example.realworld.domain.user.entity.CurrentUser;
import com.example.realworld.domain.user.entity.User;
import com.example.realworld.domain.user.service.RiderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;
    private final RiderService riderService;

    @PostMapping("/{shopId}/nearest-riders")
    public void sendMessageToNearestRiders
            (@PathVariable(name = "shopId") Long shopId, @Valid @RequestBody NotificationRequestDto notificationRequestDto) {
        riderService.demoMethod(shopId, notificationRequestDto);
    }

    @PostMapping("/")
    public void register(@Valid @RequestBody ShopRegisterDto registerDto, @CurrentUser User user) {
        shopService.register(registerDto, user);

    }
}
