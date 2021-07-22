package pers.guzx.customersecuritydemo.authentication;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/21 16:14
 * @describe
 */
public class BadVerificationCodeException extends AuthenticationException {
    public BadVerificationCodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BadVerificationCodeException(String msg) {
        super(msg);
    }
}
