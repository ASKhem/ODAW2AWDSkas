package com.kas.kasproy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {
    
    @GetMapping({"/home", "index"})
    public String getHomeView(){
        return "public/homeView";
    }
    
}
