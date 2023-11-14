package ifsuldeminas.gestaoMotoristasVeiculos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Projeto Final Backend - IF Sul de Minas", version = "1", description = "API desenvolvida para trabalho final de disciplina Backend."))
public class GestaoMotoristasVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoMotoristasVeiculosApplication.class, args);
	}

}
