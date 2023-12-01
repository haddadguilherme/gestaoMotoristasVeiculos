package ifsuldeminas.gestaoMotoristasVeiculos.repository;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    // Busca por atibuto e retorna o motorista
    Motorista findByNome(String nome);
    Motorista findByCpf(String cpf);
    Motorista findByCnh(String cnh);

    // Busca pelo atributo categoria da CNH e retorno de uma lista de motoristas
    List<Motorista> findByCategoria(String categoria);
   
}
