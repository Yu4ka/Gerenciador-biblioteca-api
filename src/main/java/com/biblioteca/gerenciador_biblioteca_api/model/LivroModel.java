package com.biblioteca.gerenciador_biblioteca_api.model;

import jakarta.persistence.*; // Para anotações JPA como @Entity, @Id, etc.
import lombok.AllArgsConstructor; // Para construtor com todos os argumentos
import lombok.Data;             // Para getters, setters, toString, equals e hashCode
import lombok.NoArgsConstructor;  // Para construtor sem argumentos

@Entity // Marca a classe como uma entidade JPA
@Table(name = "livros") // Define o nome da tabela no banco de dados (opcional, padrão é o nome da classe)
@Data // Anotação do Lombok para gerar getters, setters, toString, equals e hashCode
@NoArgsConstructor // Anotação do Lombok para gerar construtor sem argumentos
@AllArgsConstructor // Anotação do Lombok para gerar construtor com todos os argumentos
public class LivroModel {

    @Id // Marca a propriedade como a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do ID pelo banco de dados
    private Long id;

    @Column(nullable = false, length = 255) // Define a coluna 'titulo' como não nula e com tamanho máximo de 255
    private String titulo;

    @Column(nullable = false, length = 255)
    private String autor;

    @Column(nullable = false)
    private Integer anoPublicacao;

    @Column(nullable = false, unique = true, length = 13) // ISBN deve ser único e ter 13 caracteres (padrão)
    private String isbn;

    @Column(nullable = false)
    private Integer quantidadeTotal; // Total de cópias do livro na biblioteca

    @Column(nullable = false)
    private Integer quantidadeDisponivel; // Cópias disponíveis para empréstimo
}
