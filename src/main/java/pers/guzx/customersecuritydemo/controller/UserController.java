package pers.guzx.customersecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 11:02
 * @describe
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/demo")
    public String demo() {
        return "user";
    }

    @GetMapping("/query")
    public String query() {
        return "user query";
    }
}
