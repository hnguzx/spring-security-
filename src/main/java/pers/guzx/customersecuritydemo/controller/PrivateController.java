package pers.guzx.customersecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/20 14:16
 * @describe 如果方法上有对权限进行校验，则以方法上的权限要求为准
 */
@RestController
@RequestMapping("/private")
public class PrivateController {

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/demo")
    public String demo() {
        return "private";
    }

//    @PreAuthorize("hasRole('USER')")
    @GetMapping("/query")
    public String query() {
        return "private query";
    }
}
