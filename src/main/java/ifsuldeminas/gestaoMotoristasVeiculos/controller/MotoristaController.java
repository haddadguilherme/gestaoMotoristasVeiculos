package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class MotoristaController {
    
    @GetMapping("/motoristas")
    @Operation(summary = "Busca os motoristas cadastrados", method = "GET")
    public String index() {
        return "Hello World!";
    }
    
}
