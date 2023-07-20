package com.Rcommunity.Revos.global.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Getter
@Builder
public class AppException extends RuntimeException{

    private ErrorCode ErrorCode;

    private String message;

}
