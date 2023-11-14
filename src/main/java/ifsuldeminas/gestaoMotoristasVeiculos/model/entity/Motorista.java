package ifsuldeminas.gestaoMotoristasVeiculos.model.entity;

import javax.persistence.*;


@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String cnh;
    private String categoria;
    private String validade;

    // Construtores, getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Outros getters e setters
}
