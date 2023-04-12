# Boas-vindas ao projeto Drone Feeder!

<details>
<summary><strong>👨‍💻 Descrição do projeto</strong></summary><br />

O projeto consiste em uma aplicação que representa uma API Rest de controle de entregas por drones.
</details>

<details>
<summary><strong>📝 Detalhes do desenvolvimento</strong></summary><br />

Nesse projeto foi utilizado a linguagem Java e o framework Spring-boot para o desenvolvimento, na parte de armazenamento, foi utilizado MySQL para persistência da aplicação e hsql para armazenamento no contexto de testes, os quais foram realizados com JUnit, a aplicação foi montada em um ambiente docker, utilizando o docker-compose para orquestração dos containers. 

</details>

<details>
<summary><strong>🎲 Diagrama de entidades e relacionamentos</strong></summary><br />

![digram](https://github.com/WBomfim/Drone-Feeder/blob/main/images/Drone_Feeder_Schema.png)
</details>
  
<details>
<summary><strong>📖 Documentação</strong></summary><br />

[Click aqui para acessar a documentação](https://documenter.getpostman.com/view/22491482/2s93Xu1Qx7)	
</details>

# Instruções para rodar o projeto

<details>
<summary><strong>:whale: Rodando com docker</strong></summary><br />

**:warning: Atenção:** É necessário ter o docker instalado em sua máquina.

Primeiramente clone o projeto no diretório de sua preferência:

```bash
  git clone git@github.com:WBomfim/Drone-Feeder.git
```

Acesse o diretório clonado:

```bash
  cd Drone-Feeder
```

**:warning: Atenção:** Lembre-se de verificar se não há outra aplicação rodando nas portas 3306 e 8080, caso tenha, será necessário parar os serviços antes de subir os containers.

Suba os containers para por a aplicação em funcionamento:

```bash
  docker-compose up
```

- Se preferir pode usar a flag `-d` para rodar os containers em background.

A aplicação estará disponivel para acesso conforme abaixo, sendo possível realizar requisições seguindo as instruções da documentação:

```bash
  localhost:8080
```

- Para encerrar a aplicação basta pressionar `Ctrl + C`

- Se tiver optado por rodar os containers em segundo plano, para encerrar utilize:

```bash
  docker-compose down
```
</details>

<details>
<summary><strong>💻️ Rodando localmente</strong></summary><br />

**:warning: Atenção:** É necessário ter a JRE-11 e JDK-11 instalados em sua máquina.

Primeiramente clone o projeto no diretório de sua preferência:

```bash
  git clone git@github.com:WBomfim/Drone-Feeder.git
```

Acesse o diretório clonado:

```bash
  cd Drone-Feeder
```

Crie no seu MySQL um schema com o nome de sua preferência, sugerimos `Drone_Feeder`.

Defina o nome do schema criado na variável de ambiente:

```bash
  export MYSQL_DATABASE=nome_do_schema
```

Defina o host do seu banco na variável de ambiente:

```bash
  export MYSQL_HOST=nome_do_schema
```

Defina o usuario do seu banco na variável de ambiente:

```bash
  export MYSQL_USER=nome_do_schema
```

Defina a senha do seu banco na variável de ambiente:

```bash
  export MYSQL_PASSWORD=nome_do_schema
```

E finalmente rode a aplicação:

```bash
  mvn spring-boot:run
```

A aplicação estará disponivel para acesso conforme abaixo, sendo possível realizar requisições seguindo as instruções da documentação:

```bash
  localhost:8080
```

- Para encerrar a aplicação basta pressionar `Ctrl + C`
</details>

# Demais detalhes
<details>
<summary><strong>🚀 Próximas implementações</strong></summary><br />

- Implementar testes de integração para cobrir 100% da aplicação.
- Implementar testes unitário em toda a camada de serviço.
- implementar validações de acesso aos endpoits.
- Implementar um micro servidor em javascrip para simular o funcionamento dos drones.
- Implementar um front-end para criar uma esperiência mais visual da aplicação. 
</details>

# Autores

🖋️ [@Willian Bomfim](https://www.linkedin.com/in/willianbomfim/) 
<br/>
🖋️ [@Gregory Oliveira](https://www.linkedin.com/in/gregory-oliveira/)
