package com.biblioteca.gerenciador_biblioteca_api.model;

import com.biblioteca.model.enums.Cargo; // Importa o enum Cargo que você vai criar
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 255) // Endereço pode ser opcional
    private String endereco;

    @Column(length = 20) // Telefone pode ser opcional
    private String telefone;

    @Column(nullable = false, unique = true, length = 255) // Email deve ser único
    private String email;

    @Enumerated(EnumType.STRING) // Armazena o nome da enumeração como string no banco
    @Column(nullable = false, length = 50)
    private Cargo cargo; // MEMBRO ou FUNCIONARIO
}
