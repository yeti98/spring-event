package com.devculi.springevent.helpers;

import com.devculi.springevent.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerHelper {
    final
    UserService userService;

    public CommandLineRunnerHelper(UserService userService) {
        this.userService = userService;
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // đăng kí cho user -> Invitation Letter sẽ được gửi
            userService.signup("Chí Phèo", "Chí's password");
        };
    }
}
