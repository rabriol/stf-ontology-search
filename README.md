# stf-ontology-search

Este projeto foi resultado da minha pesquisa de mestrado cujo tema foi *Utilização de Ontologias para Busca em Base de Dados de Acórdãos do Supremo Tribunal Federal*

## Executando o projeto

Para executar este projeto em seu computador, siga os passos descritos abaixo.

### Pré-Requisítos

* Java (v8)
* MySQL (v5.7.16)
* Gradle (v3.3)

### Configurando a base de dados com os acórdãos do Supremo Tribunal Federal

Dentro do projeto no caminho src/main/resources/db contêm toda a base de dados do MySQL utilizada na execução deste projeto. Importe os arquivos sql para o seu banco de dados e não se esqueça de nomear o schema da sua base de dados como *acordaos_v1*.

### Build do projeto e execução

Após realizar o clone do projeto para o seu computador, execute o comando:

```
gradle build
```

Após o build finalizar com sucesso, execute então o comando abaixo:

```
gradle bootRun
```

Aguarde uma mensagem similar a esta *Started STFApp in 10.365 seconds (JVM running for 11.357)* e então você estará pronto para testar, para isso acesse no seu navegador o endereço localhost:8081.
