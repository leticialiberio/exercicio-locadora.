package locadora.controller;

import locadora.model.Veiculo;
import locadora.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VeiculoController {
    private VeiculoService veiculoService = new VeiculoService();

    @GetMapping("/veiculo")
    public List<Veiculo> getVeiculo() {
        return veiculoService.listarVeiculos();
    }

    @PostMapping("/veiculo")
    public Veiculo postVeiculo(@RequestBody Veiculo veiculo){
        return veiculoService.cadastrarVeiculo(veiculo.getModelo(), veiculo.getPlaca(), veiculo.isDisponivel());
    }
}
