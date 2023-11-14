package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class HomeController {
    
    @GetMapping("/")
    @Operation(summary = "Página inicial do sistema", method = "GET")
    public String index() {
        return "Hello World!";
    }

}
