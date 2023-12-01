package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Veiculo;
import ifsuldeminas.gestaoMotoristasVeiculos.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

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
    @Operation(summary = "Buscar todos os veículos cadastrados", method = "GET")
    public List<Veiculo> index() {
        return veiculoService.getVeiculos(null);
    }

    // Post methods
    @PostMapping("/create")
    @Operation(summary = "Criar um novo veículo", method = "POST")
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo novoVeiculo) {
        Veiculo veiculoCriado = veiculoService.criarVeiculo(novoVeiculo);
        return new ResponseEntity<>(veiculoCriado, HttpStatus.CREATED);
    }

    // Delete methods
    @DeleteMapping("/delete/{placa}")
    @Operation(summary = "Excluir um veículo pela placa", method = "DELETE")
    public ResponseEntity<String> excluirVeiculo(@PathVariable String placa) {
        boolean exclusaoSucesso = veiculoService.excluirVeiculoPorPlaca(placa);
        if (exclusaoSucesso) {
            return new ResponseEntity<>("Veículo excluído com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Veículo não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    // Put methods
    @PutMapping("/editar/{id}")
    @Operation(summary = "Editar um veículo pelo ID", method = "PUT")
    public ResponseEntity<String> editarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        boolean edicaoSucesso = veiculoService.editarVeiculo(id, veiculoAtualizado);
        if (edicaoSucesso) {
            return new ResponseEntity<>("Veículo editado com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Veículo não encontrado.", HttpStatus.NOT_FOUND);
        }
    }
}
