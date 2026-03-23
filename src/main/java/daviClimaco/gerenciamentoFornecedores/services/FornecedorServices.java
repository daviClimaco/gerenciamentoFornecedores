package daviClimaco.gerenciamentoFornecedores.services;

import daviClimaco.gerenciamentoFornecedores.entity.Fornecedor;
import daviClimaco.gerenciamentoFornecedores.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServices {

    private FornecedorRepository fornecedorRepository;

    public FornecedorServices(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public void salvar(Fornecedor fornecedor){
        fornecedorRepository.save(fornecedor);
    }

    public void deletar(Long id){
        fornecedorRepository.deleteById(id);
    }

    public Fornecedor buscarPorId(Long id){
        return fornecedorRepository.findById(id).orElse(null);
    }

    public List<Fornecedor> buscarTodos(){
        return fornecedorRepository.findAll();
    }
}