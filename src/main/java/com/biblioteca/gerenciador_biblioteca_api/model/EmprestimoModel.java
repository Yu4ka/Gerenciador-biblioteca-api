package com.biblioteca.gerenciador_biblioteca_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate; // Para datas de empréstimo e devolução

@Entity
@Table(name = "emprestimos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento Many-to-One: Muitos empréstimos para um Livro
    @ManyToOne(fetch = FetchType.LAZY) // Carregamento preguiçoso para evitar carregar o livro inteiro desnecessariamente
    @JoinColumn(name = "livro_id", nullable = false) // Coluna da chave estrangeira
    private LivroModel livroModel;

    // Relacionamento Many-to-One: Muitos empréstimos para um Membro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_id", nullable = false)
    private MembroModel membro;

    @Column(name = "data_emprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao_prevista", nullable = false)
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "data_devolucao_real") // Pode ser nulo se o livro ainda não foi devolvido
    private LocalDate dataDevolucaoReal;

    @Column(nullable = false)
    private boolean ativo; // Indica se o empréstimo está ativo (true) ou finalizado (false)
}
