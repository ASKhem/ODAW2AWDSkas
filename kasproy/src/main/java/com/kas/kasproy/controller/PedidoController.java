package com.kas.kasproy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas.kasproy.dto.OrdenadorNewDto;
import com.kas.kasproy.services.ordenador.OrdenadorService;
import com.kas.kasproy.services.pedido.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @Autowired
    OrdenadorService ordenadorService;

    @PostMapping("/order")
    public String submitPedido( @ModelAttribute OrdenadorNewDto ordenadorNewDto){
        System.out.println(ordenadorService.convertToOrdenador(ordenadorNewDto));
        return "redirect:/public/home";
    }
    
}
