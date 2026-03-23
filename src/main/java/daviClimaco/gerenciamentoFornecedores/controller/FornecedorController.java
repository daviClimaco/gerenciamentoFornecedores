package daviClimaco.gerenciamentoFornecedores.controller;

import daviClimaco.gerenciamentoFornecedores.entity.Fornecedor;
import daviClimaco.gerenciamentoFornecedores.services.FornecedorServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController {

    private FornecedorServices fornecedorServices;

    public FornecedorController(FornecedorServices fornecedorServices) {
        this.fornecedorServices = fornecedorServices;
    }

    @PostMapping
    public void salvar(@RequestBody Fornecedor fornecedor){
        fornecedorServices.salvar(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> buscarTodos(){
        return fornecedorServices.buscarTodos();
    }

    @GetMapping("{id}")
    public Fornecedor buscarPorId(@PathVariable Long id){
        return fornecedorServices.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        fornecedorServices.deletar(id);
    }
}