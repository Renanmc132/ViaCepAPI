🇧🇷 ViaCepAPI





Aplicação Java para consulta de endereços brasileiros através da API pública do ViaCEP, com desserialização dos dados retornados em objetos Java e geração de um arquivo JSON formatado.

📌 Sobre o Projeto

O ViaCepAPI é um projeto desenvolvido em Java com o objetivo de praticar o consumo de APIs REST, requisições HTTP, desserialização de JSON e manipulação de arquivos.

A aplicação recebe um CEP informado pelo usuário, realiza uma requisição para o serviço ViaCEP e converte a resposta JSON em um objeto Java. Em seguida, os dados consultados são serializados novamente e armazenados em um arquivo .json.

O projeto é uma implementação simples e didática para demonstrar o fluxo:

Usuário
   │
   │ Informa o CEP
   ▼
Aplicação Java
   │
   │ Requisição HTTP
   ▼
ViaCEP
   │
   │ JSON
   ▼
Gson
   │
   │ Objeto CEP
   ▼
Arquivo JSON


Observação: apesar do nome ViaCepAPI, o projeto atualmente funciona como uma aplicação Java cliente que consome a API do ViaCEP. Ele não disponibiliza uma API REST própria com endpoints como /api/cep/{cep}.

✨ Funcionalidades
🔎 Solicitação de um CEP através de uma interface gráfica simples.
🌐 Consumo da API pública do ViaCEP.
📡 Realização de requisições HTTP utilizando o HttpClient nativo do Java.
🔄 Conversão da resposta JSON para um record Java.
📄 Serialização dos dados consultados para JSON.
💾 Geração automática de um arquivo .json com os dados do endereço.
🧹 Formatação do JSON utilizando o Gson com Pretty Printing.
🛠️ Tecnologias Utilizadas
Tecnologia	Utilização
Java
	Linguagem principal
Java HttpClient
	Comunicação HTTP com o ViaCEP
Gson
	Conversão entre objetos Java e JSON
Swing
	Interface gráfica para entrada do CEP
Git
	Controle de versão
GitHub
	Hospedagem do código
API utilizada

O projeto utiliza o serviço gratuito ViaCEP
.

A consulta de um CEP segue o formato:

https://viacep.com.br/ws/{CEP}/json/


Exemplo:

https://viacep.com.br/ws/01001000/json/

📋 Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

JDK 17 ou superior
Git
IntelliJ IDEA ou outra IDE compatível com Java
Dependência Gson 2.10.1

O projeto atualmente não possui pom.xml ou build.gradle. A configuração da dependência Gson é feita através da configuração do projeto/IDE.

🚀 Instalação
1. Clone o repositório
git clone https://github.com/Renanmc132/ViaCepAPI.git

2. Acesse o diretório
cd ViaCepAPI

3. Abra o projeto na IDE

Abra a pasta do projeto no IntelliJ IDEA.

A estrutura principal encontrada no projeto é semelhante a:

ViaCepAPI/
├── src/
│   └── br/
│       └── com/
│           └── Renanmc132/
│               ├── classes/
│               │   ├── Arquivo.java
│               │   ├── CEP.java
│               │   └── ConsultaAPI.java
│               │
│               └── main/
│                   └── Main.java
│
├── .gitignore
└── CEPtoJson.iml

4. Configure o Gson

O projeto utiliza o Gson 2.10.1 para trabalhar com JSON.

Adicione o arquivo gson-2.10.1.jar ao classpath do projeto ou configure a dependência pela sua IDE.

No IntelliJ IDEA:

File
 └── Project Structure
      └── Modules
           └── Dependencies
                └── + JARs or directories


Selecione o arquivo:

gson-2.10.1.jar

5. Execute a aplicação

A classe principal está localizada em:

src/br/com/Renanmc132/main/Main.java


Importante: a implementação atual do Main possui o método de entrada sem a assinatura convencional public static void main(String[] args). Para executar como uma aplicação Java padrão pela IDE, recomenda-se utilizar:

public static void main(String[] args) throws IOException, InterruptedException {
    // código da aplicação
}


Depois disso, execute a classe Main pela sua IDE.

💻 Como Usar

Ao iniciar a aplicação, será exibida uma caixa de diálogo solicitando o CEP:

Qual seu CEP?


Informe um CEP brasileiro, por exemplo:

01001000


A aplicação realizará uma requisição para:

https://viacep.com.br/ws/01001000/json/


Após a consulta, os dados retornados serão convertidos para o modelo CEP e um arquivo JSON será criado no diretório de execução.

Exemplo:

01001000.json

🌐 Consulta ao ViaCEP

A requisição utilizada internamente pelo projeto segue o padrão:

GET https://viacep.com.br/ws/{CEP}/json/

Exemplo
GET https://viacep.com.br/ws/01001000/json/

Resposta esperada
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}


A aplicação atualmente utiliza apenas parte dessas informações no modelo CEP, mantendo os campos cep, logradouro, bairro, estado e uf.

📄 JSON Gerado

Depois da consulta, a classe responsável pela persistência cria um arquivo utilizando o CEP como nome.

Exemplo:

01001000.json


O conteúdo é formatado de maneira legível:

{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "estado": "São Paulo",
  "uf": "SP"
}

🧩 Estrutura do Código
Main.java

Responsável pelo fluxo principal da aplicação:

Solicita o CEP ao usuário.
Instancia a classe de consulta.
Realiza a busca.
Solicita a criação do arquivo JSON.
Exibe uma mensagem de sucesso.
ConsultaAPI.java

Responsável pela comunicação com o ViaCEP.

A classe utiliza:

HttpClient
HttpRequest
HttpResponse
URI


para realizar a requisição HTTP.

CEP.java

Representa os dados retornados pela consulta.

O projeto utiliza um record Java:

public record CEP(
    String cep,
    String logradouro,
    String bairro,
    String estado,
    String uf
) {
}

Arquivo.java

Responsável por transformar o objeto CEP em JSON e gravá-lo em um arquivo.

O Gson é configurado com Pretty Printing para melhorar a legibilidade do arquivo gerado.

GitHub: @Renanmc132
Repositório: ViaCepAPI
📄 Licença

Este projeto não possui atualmente um arquivo LICENSE declarado no repositório.

Caso o projeto seja disponibilizado oficialmente como código aberto, recomenda-se adicionar um arquivo de licença na raiz do projeto, como a MIT License, caso essa seja a licença escolhida pelo autor.

⭐ Apoie o Projeto

Se este projeto foi útil para você ou ajudou nos seus estudos de Java, considere deixar uma ⭐ no repositório:

https://github.com/Renanmc132/ViaCepAPI

<p align="center"> Desenvolvido com ☕ Java e 💻 dedicação por <strong>Renanmc132</strong>. </p>
