# 🚛 Relatórios de Frota

Sistema backend para gerenciamento e geração de relatórios relacionados aos gastos e serviços de uma frota de veículos.

O sistema tem como objetivo centralizar os registros de **abastecimentos, lavagens e manutenções**, utilizando as informações das notas fiscais para manter um histórico dos gastos realizados por cada veículo.

## 🎯 Objetivo

Facilitar o controle dos gastos da frota, permitindo registrar cada serviço ou despesa e posteriormente gerar relatórios por:

* Veículo
* Período
* Tipo de serviço
* Fornecedor
* Categoria de gasto

O sistema será desenvolvido como uma **API REST**, permitindo que futuramente um frontend consuma os dados do backend.

## 🚧 Status do projeto

**Em desenvolvimento**

Atualmente, o projeto está na fase inicial de estruturação do backend e configuração do banco de dados.

## 🛠️ Tecnologias

* Java 21
* Spring Boot 4
* Spring Web
* Spring Data JPA
* Spring Security
* Bean Validation
* Lombok
* PostgreSQL
* Hibernate
* Maven

## 🏗️ Arquitetura

O backend seguirá uma arquitetura baseada em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
PostgreSQL
```

### Controller

Responsável por receber as requisições HTTP e disponibilizar os endpoints da API.

### Service

Responsável pelas regras de negócio e validações do sistema.

### Repository

Responsável pela comunicação entre a aplicação e o banco de dados através do Spring Data JPA.

### Entity

Representa as entidades persistidas no banco de dados.

### DTO

Responsável por controlar os dados que entram e saem da API, evitando expor diretamente as entidades.

## 📊 Estrutura do sistema

O domínio principal do sistema será organizado em torno dos veículos e seus lançamentos.

```text
                    SISTEMA DE FROTAS
                           │
                           ▼
                       VEÍCULO
                           │
                           ▼
                      LANÇAMENTO
                           │
             ┌─────────────┼─────────────┐
             ▼             ▼             ▼
        ABASTECIMENTO   LAVAGEM      MANUTENÇÃO
             │             │             │
             └─────────────┼─────────────┘
                           │
                           ▼
                     NOTA FISCAL
                           │
                           ▼
                       FORNECEDOR
                           │
                           ▼
                       RELATÓRIOS
```

## 🚗 Veículos

Cada veículo possuirá informações para identificação e controle da frota.

Exemplos de informações:

```text
- Placa
- Marca
- Modelo
- Ano
- Status
```

## ⛽ Abastecimentos

Os abastecimentos serão registrados a partir das notas fiscais emitidas pelo fornecedor.

Possíveis informações:

```text
- Veículo
- Data
- Nota fiscal
- Fornecedor
- Tipo de combustível
- Quantidade de litros
- Valor
- Quilometragem
```

## 🧽 Lavagens

Registro das lavagens realizadas nos veículos.

Possíveis informações:

```text
- Veículo
- Data
- Nota fiscal
- Fornecedor
- Tipo de lavagem
- Valor
```

## 🔧 Manutenções

Registro dos serviços e despesas relacionados à manutenção dos veículos.

Possíveis informações:

```text
- Veículo
- Data
- Nota fiscal
- Fornecedor
- Tipo de manutenção
- Descrição
- Valor
- Quilometragem
```

## 🧾 Notas fiscais

Cada lançamento poderá estar relacionado à sua respectiva nota fiscal, permitindo manter um histórico dos documentos utilizados para registrar os gastos.

```text
Nota Fiscal
├── Número
├── Série
├── Data de emissão
├── Valor
└── Fornecedor
```

## 🏢 Fornecedores

Cadastro dos estabelecimentos responsáveis pelos serviços e produtos utilizados pela frota.

Exemplos:

```text
- Postos de combustível
- Oficinas
- Lava-jatos
- Empresas de peças
```

## 📈 Relatórios

O sistema deverá permitir a geração de relatórios para análise dos gastos da frota.

Exemplos:

```text
Gastos por veículo
Gastos por período
Gastos com combustível
Gastos com manutenção
Gastos com lavagem
Gastos por fornecedor
Custo total da frota
```

Futuramente também poderão ser adicionados indicadores como:

```text
Consumo médio de combustível
Custo por quilômetro
Custo mensal por veículo
Comparativo entre períodos
```

## 🔐 Segurança

O projeto utilizará **Spring Security** para implementar autenticação e autorização.

A estrutura de usuários e permissões será definida conforme a evolução do sistema.

## 🗄️ Banco de dados

O projeto utiliza PostgreSQL.

Banco utilizado durante o desenvolvimento:

```text
frota_db
```

Configuração básica:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/frota_db
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
```

Durante o desenvolvimento, o Hibernate poderá ser utilizado para atualização automática do esquema:

```properties
spring.jpa.hibernate.ddl-auto=update
```

## 📁 Estrutura do projeto

A estrutura planejada para o backend:

```text
src/
└── main/
    └── java/
        └── com.example.relatoriosFrota/
            ├── controller/
            ├── service/
            ├── repository/
            ├── entity/
            ├── dto/
            │   ├── request/
            │   └── response/
            ├── enums/
            ├── exception/
            └── RelatoriosFrotaApplication.java
```

## 🚀 Próximas etapas

* [x] Criar projeto Spring Boot
* [x] Configurar PostgreSQL
* [x] Configurar Spring Data JPA
* [x] Testar conexão com o banco
* [ ] Criar entidade `Veiculo`
* [ ] Criar entidade `Fornecedor`
* [ ] Criar entidade `NotaFiscal`
* [ ] Criar estrutura de lançamentos
* [ ] Implementar abastecimentos
* [ ] Implementar lavagens
* [ ] Implementar manutenções
* [ ] Criar DTOs
* [ ] Criar Services
* [ ] Criar Controllers
* [ ] Implementar autenticação
* [ ] Implementar autorização
* [ ] Criar endpoints de relatórios
* [ ] Criar frontend
* [ ] Integrar frontend com a API

## 📌 Sobre o projeto

Este projeto está sendo desenvolvido com foco em aprendizado e aplicação prática de **Java, Spring Boot, Spring Data JPA, PostgreSQL e desenvolvimento de APIs REST**.
