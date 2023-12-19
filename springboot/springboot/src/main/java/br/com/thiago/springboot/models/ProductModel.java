package br.com.thiago.springboot.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;//motramos que essa classe está habilidade para serializações
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final long serialVersionUID = 1L; //implementamos para ter o número de controle de versão das classes Serializadas

    @Id// indentificando que é um ID
    @GeneratedValue(strategy = GenerationType.AUTO)//irá iniciar o ID automaticamente
    private UUID idProduct;//Fortemente recomendado o uso para nao ter IDS semelhantes os UUID em arquiteturas distribuidas
    private String name;
    private BigDecimal value;

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
