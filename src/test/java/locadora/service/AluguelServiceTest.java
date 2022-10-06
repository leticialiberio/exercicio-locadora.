package locadora.service;

import locadora.db.AluguelDBTest;
import locadora.model.Aluguel;
import locadora.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
public class AluguelServiceTest {
    @InjectMocks
    private AluguelService aluguelService;

    @Mock
    private VeiculoService veiculoService;

    @Test
    public void testCadastrarAluguelSucesso(){

    }

}

