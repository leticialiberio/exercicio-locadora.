package locadora.db;

import locadora.model.Aluguel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AluguelDB {

    private static List<Aluguel> alugueis = new ArrayList<>();

    public Aluguel adicionarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
        return aluguel;
    }

    public static List<Aluguel> listarAlugueis() {
        return alugueis;
    }

    public boolean finalizarAluguel(String placa) {
        Optional<Aluguel> aluguel = alugueis
                .stream()
                .filter(a -> a.getVeiculoAlugado().equals(placa))
                .findFirst();
        if (aluguel.isPresent()) {
            Aluguel aluguel1 = aluguel.get();
            alugueis.remove(aluguel1);
            return true;
        }
        return false;
    }
}
