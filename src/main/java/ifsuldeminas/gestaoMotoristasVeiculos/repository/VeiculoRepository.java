package ifsuldeminas.gestaoMotoristasVeiculos.repository;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findByPlaca(String placa);
    Veiculo findByFrota(String frota);

    List<Veiculo> findByDisponivel(String disponivel);

}
