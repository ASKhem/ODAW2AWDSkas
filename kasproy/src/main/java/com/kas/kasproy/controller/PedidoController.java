package com.kas.kasproy.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kas.kasproy.dto.OrdenadorNewDto;
import com.kas.kasproy.model.Pedido;
import com.kas.kasproy.services.componente.ComponenteService;
import com.kas.kasproy.services.ordenador.OrdenadorService;
import com.kas.kasproy.services.pedido.PedidoService;
import com.kas.kasproy.services.usuario.UsuarioService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @Autowired
    OrdenadorService ordenadorService;

    @Autowired
    ComponenteService componenteService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/order")
    public String submitPedido(@ModelAttribute OrdenadorNewDto ordenadorNewDto, Model model) {
        Pedido pedido = new Pedido(0L, usuarioService.findUsarioByNombre(usuarioService.getCurrentUserName()),
                ordenadorService.convertToOrdenador(ordenadorNewDto),
                ordenadorService.calcularPrecio(componenteService.getcomponentesOrdenador(ordenadorNewDto)), null);
        Pedido pedido2 = pedidoService.createPedido(pedido);
        System.out.println(pedido2);
        model.addAttribute("componentes", componenteService.getcomponentesOrdenador(ordenadorNewDto));
        model.addAttribute("pedido", pedido2.getId());
        model.addAttribute("ordenador", pedido2.getOrdenadorInfo().getId());
        model.addAttribute("precio", pedido2.getPrecio());
        model.addAttribute("usuario", pedido2.getUsuario().getId());
        LocalDateTime fechaPedido = pedido2.getFechaPedido();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaFormateada = fechaPedido.format(formatter);
        model.addAttribute("fecha", fechaFormateada);
        return "orders/orderView";
    }

    @GetMapping("/order/{id}")
    public String getPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.getPedidoById(id);
        model.addAttribute("componentes", componenteService.getcomponentesOrdenador(ordenadorService.convertToOrdenadorNewDto(pedido.getOrdenadorInfo())));
        model.addAttribute("pedido", pedido.getId());
        model.addAttribute("ordenador", pedido.getOrdenadorInfo().getId());
        model.addAttribute("precio", pedido.getPrecio());
        model.addAttribute("usuario", pedido.getUsuario().getId());
        LocalDateTime fechaPedido = pedido.getFechaPedido();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaFormateada = fechaPedido.format(formatter);
        model.addAttribute("fecha", fechaFormateada);
        return "orders/orderView";
    }

    @GetMapping("/list")
    public String listPedidos(@RequestParam (required = false) Long usuario, Model model){
        List<Pedido> pedidos = pedidoService.getPedidos();
        if(usuario != null){
            pedidos = pedidoService.getPedidosByUsuarioId(usuario);
            model.addAttribute("usuario", usuario);
        }
        System.out.println(pedidoService.toDto(pedidos).get(0).getFechaPedido());
        model.addAttribute("pedidos", pedidoService.toDto(pedidos));
        return "orders/ordersListView";
    }

    @GetMapping("/list/usuario")
    public String listPedidosUsuarioActual(Model model) {
        List<Pedido> pedidos = pedidoService.getPedidosByUsuarioId(usuarioService.findUsarioByNombre(usuarioService.getCurrentUserName()).getId());
        model.addAttribute("pedidos", pedidoService.toDto(pedidos));
        return "orders/ordersListView";
    }

    @GetMapping("/order/list/{usuario}")
    public String listPedidosUsuario(@PathVariable Long usuario, Model model) {
        List<Pedido> pedidos = pedidoService.getPedidosByUsuarioId(usuario);
        model.addAttribute("pedidos", pedidoService.toDto(pedidos));
        return "orders/ordersListView";
    }

}
