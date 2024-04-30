package com.binary.uniTech.service.user;

import com.binary.uniTech.entity.User;
import com.binary.uniTech.exception.UserConflictException;
import com.binary.uniTech.mapper.UserMapper;
import com.binary.uniTech.repository.UserRepository;
import com.binary.uniTech.request.user.UserRegisterRequest;
import com.binary.uniTech.response.user.UserRegisterResponse;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegisterService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserRegisterResponse register(UserRegisterRequest registerRequest){
        if(checkUserPin(registerRequest.getUserPin())){
            throw new UserConflictException(HttpStatus.CONFLICT.name(), "userPin is already used"); //
        }
        if(checkEmail(registerRequest.getEmail())){
            throw new UserConflictException(HttpStatus.CONFLICT.name(), "user email is already user"); //
        }
        User user = userMapper.requestToEntity(registerRequest);
        User userSave = userRepository.save(user);
        log.info("user in registered {}", user);
        return userMapper.registerToResponse(user);
    }

    private boolean checkUserPin(String userPin){
        return userRepository.findByUserPin(userPin)!= null;
    }
    private boolean checkEmail(String email){
        return userRepository.findByEmail(email)!=null;
    }
}
