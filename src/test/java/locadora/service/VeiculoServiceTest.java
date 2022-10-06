package locadora.service;


import locadora.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VeiculoServiceTest {
    private VeiculoService veiculoService = new VeiculoService();
    @Test
    public void testCadastrarVeiculo() {
        Veiculo veiculo = veiculoService.cadastrarVeiculo("sedan", "ABC123", true);
        Assertions.assertEquals("sedan", veiculo.getModelo());
        Assertions.assertEquals("ABC123", veiculo.getPlaca());
        Assertions.assertTrue(veiculo.isDisponivel());
    }

    @Test
    public void testCadastrarVeiculoErroModeloVazio() {
        Veiculo veiculo = veiculoService.cadastrarVeiculo("", "ABC123", true);
        Assertions.assertNull(veiculo);
    }

    @Test
    public void testCadastrarVeiculoErroPlacaVazia() {
        Veiculo veiculo = veiculoService.cadastrarVeiculo("sedan", "", true);
        Assertions.assertNull(veiculo);
    }
    @Test
    public void testCadastrarVeiculoErroIndisponivel() {
        Veiculo veiculo = veiculoService.cadastrarVeiculo("sedan", "ABC123", false);
        Assertions.assertNull(veiculo);
    }
    @Test
    public void testListarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        Veiculo veiculo = veiculoService.cadastrarVeiculo("sedan", "ABC123", true);
        Veiculo veiculo2 = veiculoService.cadastrarVeiculo("SUV", "DEF456", true);
        Assertions.assertEquals(2, veiculos.size());
    }

    @Test
    public void testBuscaVeiculoNaoEncontrado() {
        Veiculo veiculo = veiculoService.buscarVeiculo("GHI789");
        Assertions.assertNull(veiculo);
    }
}
