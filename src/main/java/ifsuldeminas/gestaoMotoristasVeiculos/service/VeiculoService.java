package ifsuldeminas.gestaoMotoristasVeiculos.service;

import org.springframework.stereotype.Service;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Veiculo;
import ifsuldeminas.gestaoMotoristasVeiculos.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;


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


    // Métodos "FIND" do framework Spring Data JPA
    public Veiculo findByPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

    public Veiculo findByFrota(String frota) {
        return veiculoRepository.findByPlaca(frota);
    }
    
}
