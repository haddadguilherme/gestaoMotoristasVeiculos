package ifsuldeminas.gestaoMotoristasVeiculos.model.entity;

import javax.persistence.*;


@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String cnh;
    
    @Column(nullable = true)
    private String categoria;
    
    @Column(nullable = true)
    private String validade;

    // Construtores, getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
