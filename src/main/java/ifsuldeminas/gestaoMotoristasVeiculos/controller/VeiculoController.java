package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Veiculo;
import ifsuldeminas.gestaoMotoristasVeiculos.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // Get methods
    @GetMapping("/index")
    @Operation(summary = "Busca todos os veículos cadastrados", method = "GET")
    public List<Veiculo> index() {
        return veiculoService.getVeiculos(null);
    }

    //Post methods
    @PostMapping("/create")
    @Operation(summary = "Cria um novo veículo", method = "POST")
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo novoVeiculo) {
        Veiculo veiculoCriado = veiculoService.criarVeiculo(novoVeiculo);
        return new ResponseEntity<>(veiculoCriado, HttpStatus.CREATED);
    }
}
