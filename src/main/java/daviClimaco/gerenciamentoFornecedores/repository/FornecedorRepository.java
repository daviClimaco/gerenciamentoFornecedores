package daviClimaco.gerenciamentoFornecedores.repository;

import daviClimaco.gerenciamentoFornecedores.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}