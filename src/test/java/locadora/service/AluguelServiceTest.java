package locadora.service;

import locadora.db.AluguelDB;
import locadora.model.Aluguel;
import locadora.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AluguelServiceTest {
    @InjectMocks
    private AluguelService aluguelService;
    @Mock
    private Aluguel aluguel;
    @Mock
    private AluguelDB aluguelDB;
    @Mock
    private VeiculoService veiculoService;

    @Test
    public void testCadastrarAluguelSucesso() {
        Veiculo veiculo = new Veiculo("sedan", "ABC123", true);

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = LocalDate.now().plusDays(7);


        Aluguel aluguel = aluguelService.cadastrarAluguel(veiculo, dataEmprestimo, dataDevolucao);
        Assertions.assertEquals("ABC123", aluguel.getVeiculoAlugado().getPlaca());
        Assertions.assertEquals("sedan", aluguel.getVeiculoAlugado().getModelo());
        Assertions.assertTrue(aluguel.getVeiculoAlugado().isDisponivel());
        Assertions.assertEquals(LocalDate.now(), aluguel.getDataEmprestimo());

    }

    @Test
    public void testListaAlugueisVazio() {
        Mockito.when(aluguelDB.listarAlugueis()).thenReturn(new ArrayList<>());

        List<Aluguel> lista = aluguelService.listarAlugueis();
        Assertions.assertEquals(0, lista.size());
        Assertions.assertTrue(lista.isEmpty());

    }
}

