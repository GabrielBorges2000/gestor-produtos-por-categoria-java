# Sistema de Cadastro de Produtos e Categorias

Projeto desenvolvido em **Java 17** durante um **nano curso da FIAP**.  
O sistema permite o cadastro e gerenciamento de produtos e categorias por meio de um menu simples baseado em `JOptionPane`.

---

## ✅ Funcionalidades

- Criar nova **categoria**
- Criar novo **produto**
- Atualizar um **produto existente**
- Buscar **produto por ID**
- Buscar **produto por categoria**
- Encerrar o sistema

---

## 🛠️ Tecnologias e Ferramentas

- Java 17
- Visual Studio Code
- Swing (`JOptionPane`) para interação com o usuário
- Organização por pacotes: `model`, `repository`, `view`

---

## 📁 Estrutura do Projeto

```
Produtos/
├── .vscode/
│   └── settings.json
├── README.md
├── bin/
│   └── main/java/br/com/codeborges/produtos/
│       ├── Main.class
│       ├── model/
│       │   ├── Category.class
│       │   ├── Option.class
│       │   └── Product.class
│       ├── repository/
│       │   ├── CategoryColletionRepository.class
│       │   └── ProductColletionRepository.class
│       └── view/
│           ├── CategoryView.class
│           ├── OptionView.class
│           └── ProductView.class
├── lib/
└── src/
    └── main/java/br/com/codeborges/produtos/
        ├── Main.java
        ├── model/
        │   ├── Category.java
        │   ├── Option.java
        │   └── Product.java
        ├── repository/
        │   ├── CategoryColletionRepository.java
        │   └── ProductColletionRepository.java
        └── view/
            ├── CategoryView.java
            ├── OptionView.java
            └── ProductView.java
```

---

## ▶️ Como Compilar e Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/GabrielBorges2000/gestor-produtos-por-categoria-java.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd gestor-produtos-por-categoria-java
   ```
3. No terminal, compile os arquivos Java:

```bash
javac -d bin src/main/java/br/com/codeborges/produtos/**/*.java
```

4. No terminalm execute o programa com o comando:

```bash
java -cp bin main.java.br.com.codeborges.produtos.Main
```

## Uso
Ao executar, será exibido um menu para seleção das operações listadas acima. Siga as instruções na tela para interagir com o sistema.

Autor
Gabriel Borges
Curso Nano FIAP

Licença
Projeto aberto para estudo e aprimoramento pessoal.
