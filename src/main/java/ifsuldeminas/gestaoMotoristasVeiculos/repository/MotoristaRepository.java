package ifsuldeminas.gestaoMotoristasVeiculos.repository;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    // Busca por atibuto e retorna o motorista
    Optional<Motorista> findByNome(String nome);
    Optional<Motorista> findByCpf(String cpf);
    Optional<Motorista> findByCnh(String cnh);

    // Busca pelo atributo categoria da CNH e retorno de uma lista de motoristas
    List<Motorista> findByCategoria(String categoria);
   
}
