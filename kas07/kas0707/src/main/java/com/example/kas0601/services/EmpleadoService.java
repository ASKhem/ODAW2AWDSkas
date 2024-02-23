package com.example.kas0601.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.kas0601.domain.Empleado;
import com.example.kas0601.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    private final Integer pageSize = 10;

    public List<Empleado> getEmpleadosPaginados(Integer pageNum) {
        Pageable paging = PageRequest.of(pageNum, pageSize, Sort.by("nombre"));
        Page<Empleado> pagedResult = empleadoRepository.findAll(paging);
        if (pagedResult.hasContent())
            return pagedResult.getContent();
        else
            return null;
    }

    public int getTotalPaginas() {
        Pageable paging = PageRequest.of(0, pageSize, Sort.by("nombre"));
        Page<Empleado> pagedResult = empleadoRepository.findAll(paging);
        return pagedResult.getTotalPages();
    }
}
