package services;

import java.util.List;
import java.util.Objects;

import domain.ContatoVO;
import repositories.IContatoRepository;

public class ContatoService implements IContadoService {

    private final IContatoRepository repository;

    public ContatoService(IContatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(ContatoVO contato) {
        // Validar objeto conforme a entidade contatos
        if (Objects.isNull(contato.getNome()) || contato.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório!");
        }

        if (Objects.isNull(contato.getEmail()) || contato.getEmail().isEmpty()) {
            throw new RuntimeException("É-mail é obrigatório!");
        }

        repository.salvar(contato);
    }

    @Override
    public void alterar(ContatoVO contato) {
        // TODO: Validar objeto conforme a entidade contatos
        if (Objects.isNull(contato.getId())){
            throw new RuntimeException("Contatinho não cadastrado!");

        }else{
            // TODO: Consultar e recuperar contato
            ContatoVO contatinho = new ContatoVO();
            contatinho = repository.buscarPorEmail(contato.getEmail());
            
            if (Objects.isNull(contatinho)){
                throw new RuntimeException("Contatinho não cadastrado!");
                
            }else{
                // TODO: Alterar contato
                repository.atualizar(contato);

            }
        }   
    }
  
    @Override
    public ContatoVO buscarPorEmail(String email) {
        // TODO: Validar e-mail
        if (Objects.isNull(email) || email.isEmpty()) {
            throw new RuntimeException("E-mail não cadastrado!");

        }else{
            // TODO: Localizar contato e retornar contato
            ContatoVO contatinho = new ContatoVO();
            contatinho = repository.buscarPorEmail(email);

            return contatinho;
        }    
    }

    @Override
    public void excluir(Integer id) {
        // TODO: Validar id
        if (Objects.isNull(id)){
            throw new RuntimeException("Contatinho não cadastrado!");

        }else{
            // TODO: Localizar contato e excluir contato
            List<ContatoVO> contatinhos = repository.buscarTodos();
            for(ContatoVO contatinho : contatinhos){
                if(contatinho.getId() == id){
                    repository.excluir(id);
                }
            }   
        }  
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        // TODO: Consultar e retornar todos os contatos cadastrados
        return repository.buscarTodos();
    }

}
