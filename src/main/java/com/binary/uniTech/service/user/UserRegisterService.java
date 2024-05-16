package com.binary.uniTech.service.user;

import com.binary.uniTech.entity.User;
import com.binary.uniTech.exception.UserConflictException;
import com.binary.uniTech.exception.error.ErrorMessage;
import com.binary.uniTech.mapper.UserMapper;
import com.binary.uniTech.repository.UserRepository;
import com.binary.uniTech.request.user.UserRegisterRequest;
import com.binary.uniTech.response.user.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegisterService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserEmailService emailService;


    public UserRegisterResponse register(UserRegisterRequest registerRequest){
        if(checkUserPin(registerRequest.getUserPin())){
            throw new UserConflictException(ErrorMessage.USERPIN_ALREADY_EXISTS); //
        }
        if(checkEmail(registerRequest.getEmail())){
            throw new UserConflictException(ErrorMessage.EMAIL_ALREADY_EXISTS); //
        }
        User user = userMapper.requestToEntity(registerRequest);
        User userSave = userRepository.save(user);
        log.info("user in registered {}", user);

        emailService.sendEmail("ilqardrob@gmail.com", "This is subjects", "This is body of email");
        System.out.println("Mail sendering");

        return userMapper.registerToResponse(user);
    }

    private boolean checkUserPin(String userPin){
        return userRepository.findByUserPin(userPin)!= null;
    }
    private boolean checkEmail(String email){
        return userRepository.findByEmail(email)!=null;
    }
}
