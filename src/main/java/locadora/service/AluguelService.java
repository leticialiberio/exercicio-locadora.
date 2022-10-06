package locadora.service;

import locadora.db.AluguelDB;
import locadora.db.VeiculoDB;
import locadora.model.Aluguel;
import locadora.model.Veiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * A aplicação deverá ter as seguintes operações:
 * Cadastro de Aluguel
 * Listagem dos Alugueis OK
 * Finalização do Aluguel (Devolução do veículo)
 *
 * O cadastro do aluguel deve verificar se o carro que está sendo alugado existe,
 * e se ele está disponível ou não. Se não existir ou não estiver disponível,
 * deve ser retornado um erro para o usuário.
 * A data do emprestimo é sempre a data atual, e a dataDevelocao deve ser a dataEmprestimo + 7 dias.
 **/
public class AluguelService {
    private AluguelDB aluguelDB = new AluguelDB();

    public Aluguel cadastrarAluguel(Veiculo veiculo, LocalDate dataEmprestimo, LocalDate dataDevolucao){
        if (veiculo == null || !veiculo.isDisponivel())
            return null;
        if (dataEmprestimo.isAfter(dataDevolucao))
            return null;
        if (dataDevolucao.isBefore(dataEmprestimo))
            return null;

        dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(7);

        return aluguelDB.adicionarAluguel(new Aluguel());
    }

    public List<Aluguel> listarAlugueis(){
        return aluguelDB.listarAlugueis();
    }

    public boolean devolverVeiculoAlugado(String placa){
        return aluguelDB.finalizarAluguel(placa);
    }
}
