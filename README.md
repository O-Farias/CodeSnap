# CodeSnap

![QR Code](/github-profile-qrcode.png)

## Descrição

**CodeSnap** é uma aplicação Java Spring Boot que permite gerar códigos QR personalizados de forma eficiente. Com suporte para validação de dados e controle de dimensões, a aplicação pode ser usada em diversos cenários, como redirecionamento para links, compartilhamento de informações e muito mais.

---

## Funcionalidades

- **Geração de Códigos QR:** Personalize os tamanhos e os dados para gerar QR Codes de alta qualidade.
- **Validação de Dados:** Garante que os dados fornecidos são válidos antes de gerar o QR Code.
- **API RESTful:** Endpoints simples para integração com outras aplicações.
- **Testes Automatizados:** Cobertura de testes para validação das funcionalidades principais.

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.1.4**
- **ZXing (Zebra Crossing)** para geração de QR Codes
- **JUnit 5** para testes

---

## Como Configurar o Projeto

### Pré-requisitos

- **Java 21** ou superior
- **Maven** instalado
- Uma IDE ou editor de texto como IntelliJ IDEA ou VSCode

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/O-Farias/CodeSnap.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd CodeSnap
   ```

3. Instale as dependências e compile o projeto:

   ```bash
   mvn clean install
   ```

4. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

---

## Estrutura do Projeto

```plaintext
CodeSnap/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/codesnap/
│   │   │       ├── CodeSnapApplication.java
│   │   │       ├── controller/
│   │   │       │   └── QRCodeController.java
│   │   │       ├── service/
│   │   │       │   └── QRCodeService.java
│   │   │       └── util/
│   │   │           └── QRCodeGenerator.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/codesnap/
│       │       ├── QRCodeControllerTest.java
│       │       └── QRCodeServiceTest.java
│       └── resources/
├── pom.xml
└── README.md
```

---

## Endpoints Disponíveis

### **Geração de QR Code**

- **URL:** `/qrcode/generate`
- **Método:** `POST`
- **Descrição:** Gera um QR Code com os dados fornecidos.

#### Corpo da Requisição

```json
{
  "data": "https://github.com/O-Farias",
  "width": 300,
  "height": 300
}
```

#### Resposta de Sucesso

- **Status:** `200 OK`
- **Content-Type:** `image/png`

---

## Testando com cURL

### Exemplo de Requisição:

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     -d '{
       "data": "https://github.com/O-Farias",
       "width": 300,
       "height": 300
     }' \
     http://localhost:8080/qrcode/generate --output qrcode.png
```

### Resultado:

O arquivo `qrcode.png` será salvo no diretório atual.

---

## Testes Automatizados

Os testes são realizados utilizando **JUnit 5** e podem ser executados com o Maven:

```bash
mvn test
```

### Cobertura de Testes

- **QRCodeServiceTest:** Valida a geração de QR Codes com entradas válidas e inválidas.
- **QRCodeControllerTest:** Valida o comportamento dos endpoints REST.

---

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para a sua feature ou correção:

   ```bash
   git checkout -b minha-feature
   ```

3. Faça os commits:

   ```bash
   git commit -m "Adiciona nova feature"
   ```

4. Envie suas alterações:

   ```bash
   git push origin minha-feature
   ```

5. Abra um Pull Request.

---

## Licença

Este projeto está licenciado sob a **MIT License**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.



