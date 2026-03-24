package daviClimaco.gerenciamentoFornecedores.controller;

import daviClimaco.gerenciamentoFornecedores.entity.Fornecedor;
import daviClimaco.gerenciamentoFornecedores.services.FornecedorServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController {

    private FornecedorServices fornecedorServices;

    public FornecedorController(FornecedorServices fornecedorServices) {
        this.fornecedorServices = fornecedorServices;
    }

    @PostMapping
    public ResponseEntity<Fornecedor> salvar(@RequestBody Fornecedor fornecedor){
        Fornecedor requeste = fornecedorServices.salvar(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(fornecedor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> buscarTodos(){
        List<Fornecedor> requeste = fornecedorServices.buscarTodos();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("{id}")
    public Fornecedor buscarPorId(@PathVariable Long id){
        return fornecedorServices.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        fornecedorServices.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public Fornecedor atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        return fornecedorServices.atualizar(id, fornecedor);
    }
}