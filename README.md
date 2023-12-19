# Projeto-API-Restful
API Restful de produtos seguindo modelo de  maturidade de Leonard Richardson, utilizando protocolo HTTP de forma semântica como mecanismo de comunicação de seus métodos, também definindo o tipo de retorno para cada resposta de uma aquisição, hipermidias permitindo quando a busca de um produto seja consultada, o mesmo possue links para os demais produtos na base de dados.

Para atender os padrões de uma API Restful foi utilizado.
- Spring Boot 3 E Java 17.
- Spring Data JPA
- Spring Web MVC
- Spring Validation
- Spring Hateoas


Telas de exemplo da Implementação dos Metodos Cruds, utilizando como Banco de Dados PostgreSQL.

Método POST - Inserção de produtos e valores no banco de dados.
![1_MetodoPostInserindoDados](https://github.com/thiagolucenasantos/Projeto-API-Restful/assets/77245516/a9de53fa-0836-4449-b717-01c576d86b6e)

Método GET - Fazendo a leitura do que existe no banco e nos retornando os dados.
![2_MetodoGetTrazendoDadosDaBase](https://github.com/thiagolucenasantos/Projeto-API-Restful/assets/77245516/196263c6-a3fc-4ca2-9309-70a09275576d)

Método GET - Fazendo a leitura do banco pelo ID do produto, e trazendo apenas o produto consultado.
![3_MetodoGetRetornaUmItem](https://github.com/thiagolucenasantos/Projeto-API-Restful/assets/77245516/3ba0da32-6346-495b-8f6a-69fd5aa43a87)

Método PUT - Buscando determinado produto pelo seu ID e permitindo a alteração dos seus dados e salvando no banco novamente.
![4_MetodoPutAtualizaDados](https://github.com/thiagolucenasantos/Projeto-API-Restful/assets/77245516/a02efbf4-53d0-4142-9537-3cfee15a427e)

Método DELETE - Deletando o produto através de seu ID.
![5_MetodoDeleteDados](https://github.com/thiagolucenasantos/Projeto-API-Restful/assets/77245516/2232cf7c-c0ab-4762-a907-65a42d55a15b)

Exemplo do banco de dados PostgreSQL com seus produtos atualizados.
![6PostgreSQLBancoDados](https://github.com/thiagolucenasantos/Projeto-API-Restful/assets/77245516/0f226942-106c-4586-8673-409251294f5d)

