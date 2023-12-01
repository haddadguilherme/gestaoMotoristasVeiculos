package ifsuldeminas.gestaoMotoristasVeiculos.seed;

import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Motorista;
import ifsuldeminas.gestaoMotoristasVeiculos.model.entity.Veiculo;
import ifsuldeminas.gestaoMotoristasVeiculos.repository.MotoristaRepository;
import ifsuldeminas.gestaoMotoristasVeiculos.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDate;

@Component
public class DataSeeder {

    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;


    public void seed() {
        // Criar motoristas de exemplo
        Motorista motorista1 = new Motorista();
        motorista1.setNome("João Silva");
        motorista1.setCpf("00000000000");
        motorista1.setCnh("ABC123456");
        motorista1.setCategoria("B");
        motorista1.setValidade(LocalDate.now().plusYears(3));

        Motorista motorista2 = new Motorista();
        motorista2.setNome("Maria Oliveira");
        motorista2.setCpf("11111111111");
        motorista2.setCnh("XYZ987654");
        motorista2.setCategoria("A");
        motorista2.setValidade(LocalDate.now().plusYears(2));

        if (motoristaRepository.findByCpf(motorista1.getCpf()) == null) {
            motoristaRepository.save(motorista1);
        }

        if (motoristaRepository.findByCpf(motorista2.getCpf()) == null) {
            motoristaRepository.save(motorista2);
        }

        // Criar veículos de exemplo
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setPlaca("ABC1234");
        veiculo1.setFrota("1000");
        veiculo1.setDisponivel("S");

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setPlaca("XYZ5678");
        veiculo2.setFrota("1001");
        veiculo2.setDisponivel("S");

        if (veiculoRepository.findByPlaca(veiculo1.getPlaca()) == null) {
            veiculoRepository.save(veiculo1);
        }

        if (veiculoRepository.findByPlaca(veiculo2.getPlaca()) == null) {
            veiculoRepository.save(veiculo2);
        }

    }
}
