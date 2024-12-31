# Clear Native API

Bem-vindo ao projeto **Clear Native API**. Este projeto é implementado seguindo os princípios de **Clean Architecture**, focando em separar responsabilidades e garantindo escalabilidade e manutenção eficiente do código. O foco da API é usar GraalVM AOT.

## Estrutura do Projeto

A seguir, uma visão geral sobre a estrutura do projeto e as responsabilidades de cada camada:

**1. Domain**  
A camada **Domain** é o coração da aplicação, contendo as regras de negócio e casos de uso. Ela é independente de outras camadas, permitindo que mudanças externas não afetem a lógica de negócio.  
Local: `/src/main/java/br/com/clear/clearnativeapi/domain/`  
Componentes:
- **Entities**: Representam os modelos principais do sistema.
- **Use Cases**: Reúnem as regras de negócio em implementações claras e coesas.
- **Repositories**: Declaram as interfaces que devem ser implementadas pelas camadas externas para manipular dados.

**2. Application/Adapter**  
A camada **Application** contém os adaptadores que se comunicam com a camada de domínio e frameworks externos. Aqui é onde implementamos dependências específicas, como interações com APIs, frameworks ou bancos de dados.  
Local: `/src/main/java/br/com/clear/clearnativeapi/adapter/`  
Componentes:
- **Services**: Adaptadores para os casos de uso definidos na camada de domínio.
- **Configurations**: Configurações de dependências como JWT (`JwtUtilImpl`) e outros serviços.

**3. Infrastructure**  
A camada **Infrastructure** contém configurações e implementações de componentes externos, como repositórios persistentes (e.g., banco de dados).  
Local: `/src/main/java/br/com/clear/clearnativeapi/infrastructure/`  
Componentes:
- **Repositories**: Implementações dos repositórios declarados no domínio, como o `ResponsibleJpaRepository`.

**4. Web**  
A camada **Web** é responsável por expor as interfaces da aplicação para o mundo externo (e.g., APIs REST).  
Local: `/src/main/java/br/com/clear/clearnativeapi/web/`  
Componentes:
- **Controllers**: Ponto de entrada para as requisições, como `AuthController` e `ResponsibleController`.

## Configuração e Build

Este projeto utiliza **Gradle** como ferramenta de build e gerenciador de dependências.

### Como configurar o ambiente:

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/clear-native-api.git
   ```

2. **Importe o projeto no IntelliJ IDEA ou sua IDE preferida**.

3. **Construa o projeto**  
   Use o comando:
   ```bash
   ./gradlew build
   ```

4. **Execute os testes**
   ```bash
    ./gradlew test
   ```

### Configuração de ferramentas:

- **JWT**: Token utilizado para autenticação. Confira a implementação presente na classe `JwtUtilImpl`.

## Endpoints da API

A seguir, um resumo dos endpoints expostos pelos controladores (**Controllers**):

### Autenticação
| Método | Endpoint       | Descrição             |
|--------|----------------|-----------------------|
| POST   | `/auth/login`  | Realiza login         |
| POST   | `/auth/signup` | Cadastra novo usuário |

### Responsáveis
| Método | Endpoint              | Descrição                  |
|--------|-----------------------|----------------------------|
| GET    | `/responsible`        | Retorna lista de responsáveis |
| POST   | `/responsible`        | Cadastra um responsável    |
| DELETE | `/responsible/{id}`   | Remove um responsável pelo ID |

## Principais Tecnologias e Bibliotecas

- **Java**: Linguagem principal do projeto.
- **Jakarta EE**: Framework para desenvolvimento de aplicações corporativas.
- **Spring Boot**: Gerenciamento de dependências e inicialização.
- **Spring Data JPA**: Abstração para acesso a dados.
- **Lombok**: Redução de código boilerplate.
- **JWT**: Token para autenticação e segurança.
- **Gradle**: Construção e gerenciamento de dependências.
