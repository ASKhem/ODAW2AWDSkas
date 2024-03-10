package com.kas.kasproy.services.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.dto.PedidoDto;
import com.kas.kasproy.model.Pedido;
import com.kas.kasproy.repositories.PedidoRepository;

@Service
public class PedidoServiceImplBD implements PedidoService{
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }
    public  Pedido createPedido(Pedido pedido){
        pedido.setFechaPedido(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }
    public Pedido findById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }
    public void deletePedido(Long id){
        pedidoRepository.deleteById(id);
    }

    public List<PedidoDto> toDto(List<Pedido> pedido){
        List<PedidoDto> pedidoDto = new ArrayList<>();
        for (Pedido p : pedido) {
            pedidoDto.add(modelMapper.map(p, PedidoDto.class));
            pedidoDto.get(pedidoDto.size()-1).setUsuarioId(p.getUsuario().getId());
            pedidoDto.get(pedidoDto.size()-1).setOrdenadorInfoId(p.getOrdenadorInfo().getId());
        }
        return pedidoDto;
    }

    public List<Pedido> getPedidosByUsuarioId(Long id){
        return pedidoRepository.getPedidosByUsuarioId(id);
    }

    public Pedido getPedidoById(Long id){
        return pedidoRepository.getPedidoById(id);
    }

}
