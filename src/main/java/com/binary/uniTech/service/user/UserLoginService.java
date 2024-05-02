package com.binary.uniTech.service.user;


import com.binary.uniTech.entity.User;
import com.binary.uniTech.mapper.UserMapper;
import com.binary.uniTech.repository.UserRepository;
import com.binary.uniTech.request.user.UserLoginRequest;
import com.binary.uniTech.response.user.UserLoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserLoginService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public boolean login(UserLoginRequest loginRequest){
        User login = userRepository.findByUserPin(loginRequest.getUserPin());
        if(Objects.isNull(login) || !login.getPassword().equals(loginRequest.getPassword())){
            System.out.println("pin or password is incorrect");
            log.info("pin or password is incorrect");
            return false;
        }

        return true;
    }

}
