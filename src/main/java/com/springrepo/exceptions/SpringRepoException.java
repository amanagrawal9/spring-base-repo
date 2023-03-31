package com.springrepo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class SpringRepoException extends RuntimeException {

    private HttpStatus httpStatus;
    private String errorMessage;

}
