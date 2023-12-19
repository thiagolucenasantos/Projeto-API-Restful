package br.com.thiago.springboot.repositories;

import br.com.thiago.springboot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//extendendo o JpaRepository para utilizar as anotações necessárias
@Repository // bin gerenciado pelo spring do tipo repositorio
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
