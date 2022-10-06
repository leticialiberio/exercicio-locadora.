package locadora.db;

import locadora.model.Aluguel;
import locadora.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class AluguelDBTest {
    private AluguelDB aluguelDB = new AluguelDB();
    private Veiculo veiculo = new Veiculo();

    @Test
    public void testAdicionaAluguelSucesso() {
        Veiculo veiculo = new Veiculo("sedan", "ABC123", true);
        Aluguel aluguel = new Aluguel(veiculo, LocalDate.now(), LocalDate.now().plusDays(7));
        Aluguel retorno = aluguelDB.adicionarAluguel(aluguel);

        Assertions.assertEquals("sedan", retorno.getVeiculoAlugado().getModelo());
        Assertions.assertEquals("ABC123", retorno.getVeiculoAlugado().getPlaca());
        Assertions.assertTrue(retorno.getVeiculoAlugado().isDisponivel());
        Assertions.assertEquals(LocalDate.now(), retorno.getDataEmprestimo());
    }

    @Test
    public void testListaAlugueisSucesso() {
        Veiculo veiculo = new Veiculo("sedan", "ABC123", true);
        Aluguel aluguel = new Aluguel(veiculo, LocalDate.now(), LocalDate.now().plusDays(7));
        aluguelDB.adicionarAluguel(aluguel);

        List<Aluguel> retorno = aluguelDB.listarAlugueis();
        Assertions.assertTrue(retorno.size() > 0);
    }
}
