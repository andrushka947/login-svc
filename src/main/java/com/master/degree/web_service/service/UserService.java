package com.master.degree.web_service.service;

import com.master.degree.web_service.client.UserClient;
import com.master.degree.web_service.model.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserClient userClient;

    public UserDto getUser(String email) {
        return userClient.getUser(email);
    }

    public List<UserDto> getUsers() {
        return userClient.getUsers();
    }

    public void signup(UserDto userDto) {
        userClient.save(userDto);
    }

    public void delete(String email) {
        userClient.delete(email);
    }
}
