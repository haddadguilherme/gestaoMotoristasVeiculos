# Projeto Final Backend - IF Sul de Minas

GitHub : https://github.com/haddadguilherme/gestaoMotoristasVeiculos

Vídeo YouTube : https://youtu.be/QmC9UkNtidA


Projeto final para finalizar a disciplina backend do curso de pós-graduação do IF Sul de Minas.

##Tecnologias
Para o desenvolvimento da aplicação, foram utilizadas às tecnologias e libs abaixo:

| Nome                     | Versão         |
|:-------------------------|:---------------|
| Java                     | JDK 17         |
| Gradle                   |                |
| Spring Boot              | 2.7.17         |
| MySQL                    | Latest         | 

##Pré requisitos de tecnologia
- Instalar o _**Java 17**_<br>
- Instalar o _**Gradle 3.5 ou 4.1**_

##Build
- Fazer o build da aplicação através do comando `gradle build`(_**Necessário ter o gradle instalado**_).

##Execução
- Execute o comando `docker compose` para criação do banco de dados com a configuração correta
- Fazer a execução da aplicação através do comando `gradle bootrun`
- Pontos a serem observados no processo de execução são:
    - Execução na porta _**8080**_;
    - Acesso através do swagger-ui = (http://localhost:8080/swagger-ui/index.html)
