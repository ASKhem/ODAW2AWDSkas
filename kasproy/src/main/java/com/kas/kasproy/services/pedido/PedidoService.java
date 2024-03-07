package com.kas.kasproy.services.pedido;

import java.util.List;

import com.kas.kasproy.model.Pedido;

public interface PedidoService {
    public  Pedido createPedido(Pedido pedido);
    public List<Pedido> getPedidos();
    public Pedido findById(Long id);
    public void deletePedido(Long id);
}
