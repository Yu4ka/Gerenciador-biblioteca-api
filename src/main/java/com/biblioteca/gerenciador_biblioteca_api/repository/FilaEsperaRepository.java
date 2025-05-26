package com.biblioteca.gerenciador_biblioteca_api.repository;

import com.biblioteca.gerenciador_biblioteca_api.model.FilaEsperaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaEsperaRepository extends JpaRepository<FilaEsperaModel, Long> {
}
