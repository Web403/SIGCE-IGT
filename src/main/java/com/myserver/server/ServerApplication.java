package com.myserver.server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}

@RestController
class HomeController {

    @GetMapping("/")
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/login")
    ModelAndView about() {
        ModelAndView login = new ModelAndView();
        login.setViewName("Login.html");
        return login;
    }


    @GetMapping("/info")
    ModelAndView info() {
        ModelAndView info = new ModelAndView();
        info.setViewName("info.html");
        return info;
    }

    @GetMapping("/email")
    public ResponseEntity<Object> getData(@RequestParam String email) {
        ResponseEntity<Object> data = EmailInfo.emailInfo(email);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    
}
