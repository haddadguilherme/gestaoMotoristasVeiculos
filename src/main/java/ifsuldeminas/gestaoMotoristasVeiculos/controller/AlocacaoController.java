package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import ifsuldeminas.gestaoMotoristasVeiculos.dto.AlocacaoRequest;
import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Alocacao;
import ifsuldeminas.gestaoMotoristasVeiculos.service.AlocacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alocacao")
public class AlocacaoController {

    private final AlocacaoService alocacaoService;

    @Autowired
    public AlocacaoController(AlocacaoService alocacaoService) {
        this.alocacaoService = alocacaoService;
    }

    // Get methods
    @GetMapping("/index")
    @Operation(summary = "Buscar todas as alocações cadastradas", method = "GET")
    public List<Alocacao> index() {
        return alocacaoService.getAlocacoes();
    }

    // Post methods
    @PostMapping("/do")
    @Operation(summary = "Alocar um veículo para um motorista.", method = "POST")
    public ResponseEntity<String> alocarVeiculo(@RequestBody AlocacaoRequest alocacaoRequest) {

        Alocacao alocacaoCriada = alocacaoService.alocarVeiculo(
            alocacaoRequest.getFrota(),
            alocacaoRequest.getCpf()
        );

        if (alocacaoCriada != null) {
            return new ResponseEntity<>("Alocação criada com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Não foi possível alocar o veículo.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/undo/{id}")
    @Operation(summary = "Desalocar o veículo e motorista e tornar disponível.", method = "POST")
    public ResponseEntity<String> desalocarVeiculo(@PathVariable Long id) {
        boolean desalocacaoSucesso = alocacaoService.desalocarVeiculo(id);
        if (desalocacaoSucesso) {
            return new ResponseEntity<>("Veículo desalocado com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Alocação não encontrada.", HttpStatus.NOT_FOUND);
        }
    }
}
