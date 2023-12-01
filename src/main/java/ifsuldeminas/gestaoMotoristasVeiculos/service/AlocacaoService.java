package ifsuldeminas.gestaoMotoristasVeiculos.service;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Alocacao;
import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;
import ifsuldeminas.gestaoMotoristasVeiculos.repository.AlocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Service
public class AlocacaoService {

    private final AlocacaoRepository alocacaoRepository;
    private final VeiculoService veiculoService;
    private final MotoristaService motoristaService;

    @Autowired
    public AlocacaoService(AlocacaoRepository alocacaoRepository, VeiculoService veiculoService, MotoristaService motoristaService) {
        this.alocacaoRepository = alocacaoRepository;
        this.veiculoService = veiculoService;
        this.motoristaService = motoristaService;
    }

    public List<Alocacao> getAlocacoes() {
        return alocacaoRepository.findAll();
    }

    public Alocacao alocarVeiculo(String frota, String cpf) {

        if (veiculoService.alocarVeiculo(frota)) {
            
            Optional<Motorista> motoristaOptional = motoristaService.findByCpf(cpf);
            
            if (motoristaOptional.isPresent()) {
                
                Alocacao alocacao = new Alocacao();
                alocacao.setMotorista(motoristaOptional.get());
                alocacao.setVeiculo(veiculoService.findByFrota(frota).orElse(null));
                alocacao.setDataInicio(LocalDate.now());

                return alocacaoRepository.save(alocacao);
            }

        }

        return null; // Não foi possível alocar o veículo
    }

    public boolean desalocarVeiculo(Long id) {
        
        Optional<Alocacao> alocacaoOptional = alocacaoRepository.findById(id);
        
        if (alocacaoOptional.isPresent()) {

            Alocacao alocacaoExistente = alocacaoOptional.get();

            Long idVeiculo = alocacaoExistente.getVeiculo().getId();

            // Desalocar o veículo usando o VeiculoService
            if (veiculoService.desalocarVeiculo(idVeiculo)) {
                // Defina a data final na alocacao
                alocacaoExistente.setDataFim(LocalDate.now());
                alocacaoRepository.save(alocacaoExistente);

                return true; // Desalocação bem-sucedida
            }
        }

        return false; // Alocação não encontrada
    }
}
