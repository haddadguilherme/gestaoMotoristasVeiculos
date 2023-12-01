package ifsuldeminas.gestaoMotoristasVeiculos.service;

import org.springframework.stereotype.Service;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;
import ifsuldeminas.gestaoMotoristasVeiculos.repository.MotoristaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    // Construtor da classe inicializando o serviço
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

    public boolean excluirMotoristaPorCpf(String cpf) {
        Optional<Motorista> motoristaOptional = motoristaRepository.findByCpf(cpf);
        if (motoristaOptional.isPresent()) {
            motoristaRepository.delete(motoristaOptional.get());
            return true; // Exclusão bem-sucedida
        }
        return false; // Motorista não encontrado
    }

    public boolean editarMotorista(Long id, Motorista motoristaAtualizado) {
        Optional<Motorista> motoristaOptional = motoristaRepository.findById(id);
        if (motoristaOptional.isPresent()) {
            Motorista motoristaExistente = motoristaOptional.get();
            motoristaExistente.setNome(motoristaAtualizado.getNome());
            motoristaExistente.setCpf(motoristaAtualizado.getCpf());
            motoristaExistente.setCnh(motoristaAtualizado.getCnh());
            motoristaExistente.setCategoria(motoristaAtualizado.getCategoria());
            motoristaExistente.setValidade(motoristaAtualizado.getValidade());
            // Adicione mais atributos conforme necessário

            motoristaRepository.save(motoristaExistente);
            return true; // Edição bem-sucedida
        }
        return false; // Motorista não encontrado
    }

    // Métodos "find" do framework Spring Data JPA
    public Optional<Motorista> findByCpf(String cpf) {
        return motoristaRepository.findByCpf(cpf);
    }

    public Optional<Motorista> findByNome(String nome) {
        return motoristaRepository.findByNome(nome);
    }

    public Optional<Motorista> findByCnh(String cnh) {
        return motoristaRepository.findByCnh(cnh);
    }

    
}
