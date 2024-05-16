package com.binary.uniTech.exception.error;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    String code;
    String message;

}
