package br.com.thiago.springboot.controllers;

import br.com.thiago.springboot.dtos.ProductRecordDto;
import br.com.thiago.springboot.models.ProductModel;
import br.com.thiago.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController //bin do spring que tem implementação de apiRest
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    //passamos a URI de nome products, para quando o usuário necessitar ele será o responsável pelo retorno a requisiçãp
    @PostMapping("/products") //método de criação dos produtos na base de Dados
    //o @RequestBody irá receber nosso productRecordDto, onde já mapeamos os dados na sua classe Record
    //@Valid importante para que nossas validações sejam efetivas, se não incluir pode ocorrer erros
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) throws BadRequestException {

        var productModel = new ProductModel();//Iniciando nossa classe ProductModel, para que possa receber os dados e salvar n banco de dados na tabela TB_PRODUCTS

        BeanUtils.copyProperties(productRecordDto, productModel);//convertendo o productRecordDto para productModel com BeanUtils.copyProperties
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));// retornando o ResponseEntity para ser salvo o productModel
        //IMPLEMENTAR MELHORIAS DE BAD-REQUEST

    }

    @GetMapping("/products") //metodo retorna todos os produtos
    //retorna o status 200 ok, e a list de todos os produtos na base de dados do productRepository
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> productsList = productRepository.findAll();
        if (!productsList.isEmpty()) {
            for (ProductModel product : productsList) {
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @GetMapping("/products/{id}")//Método retorna somente um item da lista
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {//notação PathVariale utilizada para capturar o id
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        product0.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/products/{id}")//Método atualização de valores de um produto atráves de seu ID
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productModel = product0.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")//Método deleção de itens atráves de seu ID
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}
