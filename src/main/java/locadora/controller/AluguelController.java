package locadora.controller;


import locadora.model.Aluguel;
import locadora.service.AluguelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AluguelController {
    private AluguelService aluguelService = new AluguelService();

    @GetMapping("/aluguel")
    public List<Aluguel> getAlugueis() {
        return aluguelService.listarAlugueis();
    }

    @PostMapping("/aluguel")
    public void postAlugueis(@RequestBody Aluguel aluguel) {
        aluguelService.cadastrarAluguel(aluguel.getVeiculoAlugado(), aluguel.getDataEmprestimo(),aluguel.getDataDevolucao());
    }
}
