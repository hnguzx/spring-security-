package pers.guzx.customersecuritydemo.handle;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import pers.guzx.customersecuritydemo.code.ErrorCode;
import pers.guzx.customersecuritydemo.entity.JsonDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/7 16:22
 * @describe
 */
@Slf4j
@Component
public class LoginFailHandle implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        JsonDto<ErrorCode> result;
        if (e instanceof AccountExpiredException) {
            //账号过期
            result = JsonDto.retFail(ErrorCode.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = JsonDto.retFail(ErrorCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof BadVerificationCodeException) {
            //验证码错误
            result = JsonDto.retFail(ErrorCode.VERIFY_NOT_FOUND);
        }else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = JsonDto.retFail(ErrorCode.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = JsonDto.retFail(ErrorCode.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            result = JsonDto.retFail(ErrorCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = JsonDto.retFail(ErrorCode.USER_ACCOUNT_NOT_EXIST);
        } else {
            //其他错误
            result = JsonDto.retFail(ErrorCode.INTERNAL_SERVER_ERROR);
        }
        log.info(result.getMessage());
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
