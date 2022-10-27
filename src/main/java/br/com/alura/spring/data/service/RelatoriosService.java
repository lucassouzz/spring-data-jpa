package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while(system) {

            System.out.println("Qual acao de relatorio deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario nome");
            System.out.println("2 - Busca funcionario nome, data contratacao e salario maior");
            System.out.println("3 - Busca funcionario data contratacao");
            System.out.println("4 - Pesquisa funcionario salario");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    buscaFuncionarioDataContratacao(scanner);
                    break;
                case 4:
                    buscaFuncionarioSalario(scanner);
                    break;
                default:
                    system = false;
                    break;
            }

        }

    }

    private void buscaFuncionarioNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar");
        String nome = scanner.next();
        List<Funcionario> lista = funcionarioRepository.findByNome(nome);
        lista.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar");
        String nome = scanner.next();

        System.out.println("Qual data contratacao deseja pesquisar");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salario deseja pesquisar");
        Double salario = scanner.nextDouble();

        List<Funcionario> lista = funcionarioRepository
                .findNomeSalarioMaiorDataContratacao(nome, salario, localDate);

        lista.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(Scanner scanner){
        System.out.println("Qual data contratacao deseja pesquisar");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> lista = funcionarioRepository.findDataContratacaoMaior(localDate);
        lista.forEach(System.out::println);

    }

    private void buscaFuncionarioSalario(Scanner scanner){
        List<FuncionarioProjecao> lista = funcionarioRepository.findFuncionarioSalario();
        lista.forEach(f -> System.out.println("Funcionario: id: " + f.getId() +
                " | nome: " + f.getNome() +
                " | salario: " + f.getSalario()));
    }

}
