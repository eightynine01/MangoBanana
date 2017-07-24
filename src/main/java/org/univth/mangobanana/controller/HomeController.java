package org.univth.mangobanana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 3:08
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "/home";
    }

}
