package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;
import ifsuldeminas.gestaoMotoristasVeiculos.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    private final MotoristaService motoristaService;

    @Autowired
    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }
    
    // Get methods
    @GetMapping("/index")
    @Operation(summary = "Buscar todos os motoristas no sistema.", method = "GET")
    public List<Motorista> index() {
        return motoristaService.getMotoristas();
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Buscar motorista por CPF.", method = "GET")
    public Optional<Motorista> motoristaCpf(String cpf) {
        return motoristaService.findByCpf(cpf);
    }

    @GetMapping("/list/category/{categoria}")
    @Operation(summary = "Buscar todos os motoristas no sistema que possuem CNH na categoria enviada.", method = "GET")
    public List<Motorista> motoristasCategoriaCnh(String categoria) {
        return motoristaService.getMotoristasCategoriaCnh(categoria);
    }

    // Post methods
    @PostMapping("/create")
    @Operation(summary = "Criar um novo motorista.", method = "POST")
    public ResponseEntity<Motorista> criarMotorista(@RequestBody Motorista novoMotorista) {
        Motorista motoristaCriado = motoristaService.criarMotorista(novoMotorista);
        return new ResponseEntity<>(motoristaCriado, HttpStatus.CREATED);
    }

    // Delete methods
    @DeleteMapping("/delete/cpf/{cpf}")
    @Operation(summary = "Excluir um motorista pelo CPF.", method = "DELETE")
    public ResponseEntity<String> excluirMotorista(@PathVariable String cpf) {
        boolean exclusaoSucesso = motoristaService.excluirMotoristaPorCpf(cpf);
        if (exclusaoSucesso) {
            return new ResponseEntity<>("Motorista excluído com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Motorista não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    // Put methods
    @PutMapping("/editar/{id}")
    @Operation(summary = "Edita um motorista pelo ID", method = "PUT")
    public ResponseEntity<String> editarMotorista(@PathVariable Long id, @RequestBody Motorista motoristaAtualizado) {
        boolean edicaoSucesso = motoristaService.editarMotorista(id, motoristaAtualizado);
        if (edicaoSucesso) {
            return new ResponseEntity<>("Motorista editado com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Motorista não encontrado.", HttpStatus.NOT_FOUND);
        }
    }
    
}
