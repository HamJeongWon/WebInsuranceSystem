package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class main {
		
    @RequestMapping("/main") 
    private String boardList(Model model) throws Exception{
        return "main"; 
    }
}
