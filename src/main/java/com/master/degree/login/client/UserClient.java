package com.master.degree.login.client;

import com.master.degree.login.model.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "userClient", url = "${api.user-svc.host}")
public interface UserClient {

    @GetMapping(path = "/users")
    UserDto getUser(@RequestParam("email") String email);

}
