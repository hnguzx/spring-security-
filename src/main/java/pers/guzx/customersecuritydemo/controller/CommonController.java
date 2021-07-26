package pers.guzx.customersecuritydemo.controller;

import org.springframework.web.bind.annotation.*;
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
