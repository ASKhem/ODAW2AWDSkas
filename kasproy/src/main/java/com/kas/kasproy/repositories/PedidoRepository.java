package com.kas.kasproy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kas.kasproy.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findAllByOrderByPrecioDesc();
    public List<Pedido> getPedidosByUsuarioId(Long id);
    public Pedido getPedidoById(Long id);

}
