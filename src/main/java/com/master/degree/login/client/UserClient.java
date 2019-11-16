package com.master.degree.login.client;

import com.master.degree.login.model.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "userClient", url = "${api.user-svc.host}")
public interface UserClient {

    @GetMapping(path = "/users/{email}")
    UserDto getUser(@PathVariable("email") String email);

    @GetMapping(path = "/users")
    List<UserDto> getUsers();

    @PostMapping(path = "/users")
    void save(UserDto userDto);

    @DeleteMapping(path = "/users/{email}")
    void delete(@PathVariable("email") String email);
}
