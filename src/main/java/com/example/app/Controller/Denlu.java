package com.example.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Denlu {
    @GetMapping("/www")
    public String show(){
        return "backendlogin";
    }
    @GetMapping("/ww")
    public String show1(){
        return "devlogin";
    }
}
