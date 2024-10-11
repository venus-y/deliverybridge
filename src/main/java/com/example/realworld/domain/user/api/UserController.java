package com.example.realworld.domain.user.api;


import com.example.realworld.domain.user.dto.UserRegisterDto;
import com.example.realworld.domain.user.repository.UserRepository;
import com.example.realworld.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/")
    public void register(@Valid @RequestBody UserRegisterDto userRegisterDto) throws BindException {
        userService.insert(userRegisterDto);
    }


}
