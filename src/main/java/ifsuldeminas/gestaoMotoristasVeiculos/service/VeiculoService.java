package ifsuldeminas.gestaoMotoristasVeiculos.service;

import org.springframework.stereotype.Service;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Veiculo;
import ifsuldeminas.gestaoMotoristasVeiculos.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    // Construtor da classe inicializando o serviço
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> getVeiculos(String disponivel) {

        if(disponivel == null)
            return veiculoRepository.findAll();
        
        if(disponivel.equals("S"))
            return veiculoRepository.findByDisponivel("S");
        else
            return veiculoRepository.findByDisponivel("N");
    }

    public Veiculo criarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public boolean excluirVeiculoPorPlaca(String placa) {
        
        Optional<Veiculo> veiculoOptional = veiculoRepository.findByPlaca(placa);
        
        if (veiculoOptional.isPresent()) {
            veiculoRepository.delete(veiculoOptional.get());
            
            return true; // Exclusão bem-sucedida
        }

        return false; // Veículo não encontrado
    }

    public boolean editarVeiculo(Long id, Veiculo veiculoAtualizado) {
        
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        
        if (veiculoOptional.isPresent()) {
            Veiculo veiculoExistente = veiculoOptional.get();
            veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
            veiculoExistente.setFrota(veiculoAtualizado.getFrota());
            veiculoExistente.setDisponivel(veiculoAtualizado.getDisponivel());
            // Adicione mais atributos conforme necessário

            veiculoRepository.save(veiculoExistente);
            
            return true; // Edição bem-sucedida
        }

        return false; // Veículo não encontrado
    }

    public boolean alocarVeiculo(String frota) {

        Optional<Veiculo> veiculoOptional = veiculoRepository.findByFrota(frota);

        if (veiculoOptional.isPresent()) {

            Veiculo veiculoExistente = veiculoOptional.get();

            if (veiculoExistente.getDisponivel().equals("S")) {

                veiculoExistente.setDisponivel("N");
                veiculoRepository.save(veiculoExistente);
                
                return true; // Alocação bem-sucedida

            }
        }

        return false; // Veículo não disponível ou não encontrado
    }

    public boolean desalocarVeiculo(Long id) {

        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {

            Veiculo veiculoExistente = veiculoOptional.get();

            if (veiculoExistente.getDisponivel().equals("N")) {

                veiculoExistente.setDisponivel("S");
                veiculoRepository.save(veiculoExistente);
                
                return true; // Desalocação bem-sucedida
                
            }
        }

        return false; // Veículo já disponível ou não encontrado
    }

    // Métodos "FIND" do framework Spring Data JPA
    public Optional<Veiculo> findByPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

    public Optional<Veiculo> findByFrota(String frota) {
        return veiculoRepository.findByFrota(frota);
    }
    
}
