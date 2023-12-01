package ifsuldeminas.gestaoMotoristasVeiculos.service;

import org.springframework.stereotype.Service;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;
import ifsuldeminas.gestaoMotoristasVeiculos.repository.MotoristaRepository;

import java.util.List;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;


    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public List<Motorista> getMotoristas() {
        return motoristaRepository.findAll();
    }

    public List<Motorista> getMotoristasCategoriaCnh(String categoria) {
        return motoristaRepository.findByCategoria(categoria);
    }

    public Motorista criarMotorista(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    // Métodos "find" do framework Spring Data JPA
    public Motorista findByCpf(String cpf) {
        return motoristaRepository.findByCpf(cpf);
    }

    public Motorista findByNome(String nome) {
        return motoristaRepository.findByNome(nome);
    }

    public Motorista findByCnh(String cnh) {
        return motoristaRepository.findByCnh(cnh);
    }

    
}
