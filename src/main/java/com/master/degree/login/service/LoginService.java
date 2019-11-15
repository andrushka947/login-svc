package com.master.degree.login.service;

import com.master.degree.login.client.UserClient;
import com.master.degree.login.exception.BadRequestException;
import com.master.degree.login.exception.UnauthorizedException;
import com.master.degree.login.model.LoginDto;
import com.master.degree.login.model.LoginResponse;
import com.master.degree.login.model.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private UserClient userClient;

    public LoginResponse login(LoginDto dto) {
        UserDto user = userClient.getUser(dto.getEmail());
        if (user == null) {
            throw new BadRequestException("Wrong email provided");
        }
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new UnauthorizedException("Wrong password provided");
        }
        return new LoginResponse(true);
    }

}
