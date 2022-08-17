package pers.guzx.customersecuritydemo.handle;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pers.guzx.customersecuritydemo.ServiceImpl.UserAuthDetailsServiceImpl;
import pers.guzx.customersecuritydemo.ServiceImpl.UserServiceImpl;
import pers.guzx.customersecuritydemo.entity.JsonDto;
import pers.guzx.customersecuritydemo.entity.SysUserDetails;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/7 16:18
 * @describe 登录成功后处理
 */
@Slf4j
@Component
public class LoginSuccessHandle implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        log.info("login success!");
        this.onAuthenticationSuccess(request, response, authentication);
        chain.doFilter(request, response);
    }

    @Resource
    private UserServiceImpl userService;

    @Resource
    private UserAuthDetailsServiceImpl userAuthDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //更新用户表上次登录时间、更新人、更新时间等字段
        SysUserDetails user = (SysUserDetails) authentication.getPrincipal();

//        SysUserDetails byUserName = userService.getUserByUsername(user.getUsername());
        UserDetails userDetails = userAuthDetailsService.loadUserByUsername(user.getUsername());

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(JsonDto.retOk(userDetails)));
    }
}
