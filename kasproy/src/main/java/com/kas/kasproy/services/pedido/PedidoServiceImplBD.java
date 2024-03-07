package com.kas.kasproy.services.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.model.Pedido;
import com.kas.kasproy.repositories.PedidoRepository;

@Service
public class PedidoServiceImplBD implements PedidoService{
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }
    public  Pedido createPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public Pedido findById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }
    public void deletePedido(Long id){
        pedidoRepository.deleteById(id);
    }

}
