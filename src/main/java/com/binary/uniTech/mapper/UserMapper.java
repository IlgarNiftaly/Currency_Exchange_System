package com.binary.uniTech.mapper;

import com.binary.uniTech.entity.User;
import com.binary.uniTech.request.user.UserRegisterRequest;
import com.binary.uniTech.response.user.UserRegisterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User requestToEntity(UserRegisterRequest registerRequest);

    UserRegisterResponse registerToResponse(User user);
    UserRegisterResponse loginToResponse(User user);
}
