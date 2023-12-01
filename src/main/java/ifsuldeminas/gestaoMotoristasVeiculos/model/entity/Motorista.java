package ifsuldeminas.gestaoMotoristasVeiculos.model.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Motorista {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;
    
    @Column(nullable = false, length = 11)
    private String cpf;
    
    @Column(nullable = false, length = 20)
    private String cnh;
    
    @Column(nullable = true, length = 2)
    private String categoria;
    
    @Column(nullable = true)
    private LocalDate validade;


    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getValidade() {
        return validade;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
