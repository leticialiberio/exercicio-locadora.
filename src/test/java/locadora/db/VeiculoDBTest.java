package locadora.db;

import locadora.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoDBTest {

    private static List<Veiculo> veiculos = new ArrayList<>();

    public Veiculo adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        return veiculo;
    }

    public static List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public Veiculo buscarVeiculo(String placa) {
        Optional<Veiculo> veiculo = veiculos
                .stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst();
        if (veiculo.isPresent()) {
            return veiculo.get();
        }
        return null;
    }
}
