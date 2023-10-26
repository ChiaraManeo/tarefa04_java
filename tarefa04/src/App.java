import java.sql.Connection;
import java.util.List;

import dao.factories.ConexaoFactory;
import dao.factories.ContatoMySqlDAO;
import dao.factories.IContatoDAO;
import domain.ContatoVO;
import repositories.ContatoMySqlRepository;
import repositories.IContatoRepository;
import services.ContatoService;
import services.IContadoService;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * Este conjunto de instruções inicializaram as dependencias 
         * para o uso do serviço de contatos utilizando o repositório
         * com o SGBD MySQL.
         */
        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoMySqlDAO(conexao);
        IContatoRepository repository = new ContatoMySqlRepository(dao);

        IContadoService service = new ContatoService(repository);

        // Criar objeto ContatoVO e realizar chamada do metodo salvar do service
        ContatoVO c1 = new ContatoVO(
            null, 
            "Chiara Maneo", 
            "chiaramaneo@gmail.com", 
            "19983560473", 
            "maneo_chi");
        //service.salvar(c1);

        //TODO: Criar mais 2 contatos.
        ContatoVO c2 = new ContatoVO(
            null, 
            "Lucas Santos", 
            "lucassantos@gmail.com", 
            "199835608365", 
            "santoslucas");
        //service.salvar(c2);

        ContatoVO c3 = new ContatoVO(
            null,
            "Pedro Arthur",
            "pedroart@hotmail.com",
            "19987654543",
            "arthurpedro");
        //service.salvar(c3);

        //TODO: Exibir os contatos cadastrados
        List<ContatoVO> cadastrinhos = service.buscarTodos();
        System.out.println(cadastrinhos);

        // TODO: Remover o primeiro contatto criado.
        service.excluir(1);

        // TODO: Buscar e exibir o segundo contato criado com base no e-mail
        service.buscarPorEmail("lucassantos@gmail.com");


        // TODO: Altere o repositório MySQL pelo repositório em memória


    }
}
