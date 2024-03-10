import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Aqui você pode escrever o código para testar os repositórios e as funcionalidades do projeto
        // Por exemplo:
        PessoaFisicaRepo repo = new PessoaFisicaRepo();

        // Adicionar pessoas físicas ao repositório
        PessoaFisica pessoa1 = new PessoaFisica(1, "Fulano", "12345678900", 25);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Ciclano", "98765432100", 30);
        repo.inserir(pessoa1);
        repo.inserir(pessoa2);

        // Exibir todas as pessoas físicas
        System.out.println("Pessoas Físicas:");
        for (PessoaFisica pessoa : repo.obterTodos()) {
            pessoa.exibir();
            System.out.println();
        }

        // Persistir os dados em arquivo
        try {
            repo.persistir("pessoasFisicas.dat");
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados: " + e.getMessage());
        }

        // Recuperar os dados do arquivo
        try {
            repo.recuperar("pessoasFisicas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }

        // Exibir novamente todas as pessoas físicas após recuperar os dados do arquivo
        System.out.println("Pessoas Físicas após recuperação:");
        for (PessoaFisica pessoa : repo.obterTodos()) {
            pessoa.exibir();
            System.out.println();
        }
    }
}
