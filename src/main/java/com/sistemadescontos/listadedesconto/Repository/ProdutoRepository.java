package com.sistemadescontos.listadedesconto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistemadescontos.listadedesconto.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
    
}