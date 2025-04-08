package com.easyBytes.security.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloController {


        @GetMapping("/hello")
        public String hello(){
            return "Hello world";
        }

        @GetMapping("/help")
        public String help(){
            return "This is CA project help";
        }

        @GetMapping("/home")
        public String home(){
            return "welcome CA home page!";
        }

        @GetMapping("/info")
        public String info(){
            return "watch below manual to get help to create CA box";
        }
}
