package ifsuldeminas.gestaoMotoristasVeiculos.model.entity;

import javax.persistence.*;

@Entity
public class Veiculo {
    
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 7)
    private String placa;

    // Em transportadoras são criados códigos de frota para simplificar a busca dos veículos
    // Exemplo: A placa HKP-0A00 pode ser a frota 1010
    @Column(nullable = true, length = 10)
    private String frota;

    // S = sim, N = não, B = bloqueado
    @Column(nullable = false, length = 1)
    private String disponivel;

    
    // Getters
    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getFrota() {
        return frota;
    }

    public String getDisponivel() {
        return disponivel;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setFrota(String frota) {
        this.frota = frota;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }
    
}
