package com.chamindu.demo.controller;

/**
 * Author by chamindu_kaushalya
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/getMsg")
    public String getAppNama() {
        return "Welcome to my Employee management System";
    }
}
