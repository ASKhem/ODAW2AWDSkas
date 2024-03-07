package com.kas.kasproy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas.kasproy.dto.OrdenadorNewDto;


@Controller
@RequestMapping("/public")
public class PublicController {
    
    @GetMapping({"/home", "index"})
    public String getHomeView(){
        return "public/homeView";
    }

    @GetMapping("/buildPc")
    public String getBuildPcView(Model model){
        model.addAttribute("ordenador", new OrdenadorNewDto());
        return "public/buildPcFormView";
    }
    
}
