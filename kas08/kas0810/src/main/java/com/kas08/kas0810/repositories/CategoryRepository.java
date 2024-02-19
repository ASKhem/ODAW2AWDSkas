package com.kas08.kas0810.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kas08.kas0810.domain.Categoria;

@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Long> {

}
