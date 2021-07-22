package pers.guzx.customersecuritydemo.handle;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import pers.guzx.customersecuritydemo.code.ErrorCode;
import pers.guzx.customersecuritydemo.entity.JsonDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/9 10:54
 * @describe
 */
@Slf4j
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=utf-8");
        JsonDto<Object> objectJsonDto = JsonDto.retFail(ErrorCode.USER_NOT_AUTH);
        response.getWriter().write(JSONObject.toJSONString(objectJsonDto));
    }
}
