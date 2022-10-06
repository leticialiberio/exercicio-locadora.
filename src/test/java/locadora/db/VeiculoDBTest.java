package locadora.db;

import locadora.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VeiculoDBTest {
    private VeiculoDB veiculoDB = new VeiculoDB();

    @Test
    public void testAdicionaVeiculo() {
        Veiculo veiculo = new Veiculo("sedan", "ABC123", true);
        Veiculo retorno = veiculoDB.adicionarVeiculo(veiculo);

        Assertions.assertEquals("sedan", retorno.getModelo());
        Assertions.assertEquals("ABC123", retorno.getPlaca());
        Assertions.assertTrue(retorno.isDisponivel());
    }

    @Test
    public void testListaVeiculos() {
        Veiculo veiculo = new Veiculo("sedan", "ABC123", true);
        veiculoDB.adicionarVeiculo(veiculo);

        List<Veiculo> retorno = veiculoDB.listarVeiculos();
        Assertions.assertTrue(retorno.size() > 0);
    }

    @Test
    public void testBuscaVeiculo() {
        Veiculo veiculo = new Veiculo("sedan", "ABC123", true);
        veiculoDB.adicionarVeiculo(veiculo);
        Veiculo retorno = veiculoDB.buscarVeiculo("ABC123");

        Assertions.assertEquals("sedan", retorno.getModelo());
        Assertions.assertEquals("ABC123", retorno.getPlaca());
        Assertions.assertTrue(retorno.isDisponivel());
    }

    @Test
    public void testBuscaVeiculoInexistente() {
        Veiculo retorno = veiculoDB.buscarVeiculo("ABC456");
        Assertions.assertNull(retorno);
    }
}
