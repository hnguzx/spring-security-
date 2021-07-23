package pers.guzx.customersecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/20 14:16
 * @describe
 */
@RestController
@RequestMapping("/private")
public class PrivateController {

//    @PreAuthorize("hasRole('USER')")
    @GetMapping("/demo")
    public String demo() {
        return "private";
    }

    @GetMapping("/query")
    public String query() {
        return "private query";
    }
}
