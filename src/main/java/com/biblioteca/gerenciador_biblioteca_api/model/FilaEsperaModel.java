package com.biblioteca.gerenciador_biblioteca_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // Para registrar a data e hora de entrada na fila

@Entity
@Table(name = "fila_espera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilaEsperaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento Many-to-One: Muitos itens na fila para um Livro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", nullable = false)
    private LivroModel livro;

    // Relacionamento Many-to-One: Muitos itens na fila para um Membro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_id", nullable = false)
    private MembroModel membro;

    @Column(name = "data_entrada_fila", nullable = false)
    private LocalDateTime dataEntradaFila; // Para saber a ordem de entrada (FIFO)
}
