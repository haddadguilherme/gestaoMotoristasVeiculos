package ifsuldeminas.gestaoMotoristasVeiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ifsuldeminas.gestaoMotoristasVeiculos.seed.DataSeeder;

import javax.annotation.PostConstruct;

@Configuration
public class SeedDataBase {

    @Autowired
    private DataSeeder seeder;

    @PostConstruct
    public void popularBancoDeDados() {
        seeder.seed();
    }
    
}
