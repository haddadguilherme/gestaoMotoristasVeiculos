package ifsuldeminas.gestaoMotoristasVeiculos.repository;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByPlaca(String placa);
    Optional<Veiculo> findByFrota(String frota);

    List<Veiculo> findByDisponivel(String disponivel);

}
