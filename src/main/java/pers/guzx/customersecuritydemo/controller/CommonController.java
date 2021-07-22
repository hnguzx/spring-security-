package pers.guzx.customersecuritydemo.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pers.guzx.customersecuritydemo.ServiceImpl.AuthorityServiceImpl;
import pers.guzx.customersecuritydemo.ServiceImpl.RoleServiceImpl;
import pers.guzx.customersecuritydemo.ServiceImpl.UserAuthDetailsServiceImpl;
import pers.guzx.customersecuritydemo.ServiceImpl.UserServiceImpl;
import pers.guzx.customersecuritydemo.entity.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 11:01
 * @describe
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    private UserServiceImpl userService;
    @Resource
    private AuthorityServiceImpl authorityService;
    @Resource
    private RoleServiceImpl roleService;

    @Resource
    private UserAuthDetailsServiceImpl userAuthDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @GetMapping("/demo")
    public Object demo() {
        SysUser user = new SysUser();
        user.setUsername("test");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        return userService.saveUser(user);
    }

    /*@PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        SysUser user = (SysUser) userAuthDetailsService.loadUserByUsername(username);
        return user.getAuthorities().toString();
    }*/

    @GetMapping("/query")
    public String query() {
        return "common";
    }
}
