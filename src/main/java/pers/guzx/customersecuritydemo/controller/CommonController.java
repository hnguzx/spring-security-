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

    @GetMapping("/query")
    public String query() {
        return "common";
    }
}
