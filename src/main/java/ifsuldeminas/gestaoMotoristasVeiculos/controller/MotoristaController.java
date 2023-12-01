package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;
import ifsuldeminas.gestaoMotoristasVeiculos.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

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
    @Operation(summary = "Busca todos os motoristas cadastrados no sistema.", method = "GET")
    public List<Motorista> index() {
        return motoristaService.getMotoristas();
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Busca motorista por um CPF passado por parâmetro.", method = "GET")
    public Motorista motoristaCpf(String cpf) {
        return motoristaService.findByCpf(cpf);
    }

    @GetMapping("/category/list/{categoria}")
    @Operation(summary = "Busca todos os motoristas cadastrados no sistema que possuem CNH na categoria enviada.", method = "GET")
    public List<Motorista> motoristasCategoriaCnh(String categoria) {
        return motoristaService.getMotoristasCategoriaCnh(categoria);
    }

    // Post methods
    @PostMapping("/create")
    @Operation(summary = "Cria um novo motorista", method = "POST")
    public ResponseEntity<Motorista> criarMotorista(@RequestBody Motorista novoMotorista) {
        Motorista motoristaCriado = motoristaService.criarMotorista(novoMotorista);
        return new ResponseEntity<>(motoristaCriado, HttpStatus.CREATED);
    }
    
}
