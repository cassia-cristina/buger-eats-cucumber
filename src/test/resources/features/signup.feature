#language:pt

Funcionalidade: Validar cadastro de entregador
  Como futuro entregador da BugerEats
  Usuario precisa preencher os dados pessoais, endereco e metodo de entrega
  Para que seu cadastro seja enviado com sucesso

  @cadastroValido
  Cenario: Enviar dados de cadastro com sucesso
    Dado que esteja na pagina da BugerEats
    E for realizado um clique em Cadastre-se para fazer entregas
    Quando os seguintes dados forem informados
      | nome        | Cassia Pereira    |
      | cpf         | 00000001212       |
      | email       | cassia1@gmail.com |
      | whatsapp    | 62999999999       |
      | cep         | 04730-050         |
      | numero      | s/n               |
      | complemento | qd 50 lt 33       |
      | metodoEntr  | Bike Elétrica     |
    E for realizado um clique em Buscar CEP
    E for selecionado um arquivo para a foto CNH
    E o formulario for submetido
    Entao deve mostrar mensagem de dados recebidos com sucesso

  @cepValido
  Cenario: Ao buscar CEP deve encontrar o endereco correto
    Dado que esteja na pagina da BugerEats
    E for realizado um clique em Cadastre-se para fazer entregas
    Quando os seguintes dados forem informados
      | nome        | Cassia Pereira    |
      | cpf         | 00000001212       |
      | email       | cassia1@gmail.com |
      | whatsapp    | 62999999999       |
      | cep         | 04730-050         |
      | numero      | s/n               |
      | complemento | qd 50 lt 33       |
      | metodoEntr  | Moto              |
    E for realizado um clique em Buscar CEP
    Entao o endereco deve ser preenchido da seguinte forma
      | rua      | Rua Centro Africana |
      | bairro   | Várzea de Baixo     |
      | cidadeUf | São Paulo/SP        |

  @camposInvalidos
  Esquema do Cenario: Enviar dados de cadastro com <identificacao>
    Dado que esteja na pagina da BugerEats
    E for realizado um clique em Cadastre-se para fazer entregas
    Quando os seguintes dados forem informados
      | nome        | <nome>   |
      | cpf         | <cpf>    |
      | email       | <email>  |
      | whatsapp    | <whats>  |
      | cep         | <cep>    |
      | numero      | <numero> |
      | complemento | <compl>  |
      | metodoEntr  | <method> |
    E for realizado um clique em Buscar CEP
    E for selecionado um arquivo para a foto CNH
    E o formulario for submetido
    Entao deve mostrar uma mensagem de erro
      | mensagem | <mensagem> |
    Exemplos:
      | identificacao  | nome          | cpf         | email            | whats       | cep       | numero | compl       | method        | mensagem                          |
      | cpf invalido   | Cassia Santos | 0000A001212 | cassia@gmail.com | 62999999999 | 04730-050 | s/n    | qd 50 lt 33 | Bike Elétrica | Oops! CPF invalido                |
      | email invalido | Cassia Santos | 00000001212 | cassia.c.com.br  | 62999999999 | 04730-050 | s/n    | qd 50 lt 33 | Moto          | Oops! Email com formato invalido. |

  @camposObrigatorios
  Esquema do Cenario: Enviar dados de cadastro com <identificacao>
    Dado que esteja na pagina da BugerEats
    E for realizado um clique em Cadastre-se para fazer entregas
    Quando o formulario for submetido
    Entao deve mostrar uma mensagem para cada campo obrigatorio
      | campo    | <campo>    |
      | mensagem | <mensagem> |
    Exemplos:
      | identificacao         | campo          | mensagem                                   |
      | nome nao informado    | fullName       | E necessario informar o nome               |
      | cpf nao informado     | cpf            | E necessario informar o CPF                |
      | email nao informado   | email          | E necessario informar o email              |
      | cep nao informado     | postalcode     | E necessario informar o CEP                |
      | numero nao informado  | address-number | E necessario informar o numero do endereco |
      | metodo nao informado  | method         | Selecione o metodo de entrega              |
      | cnh nao nao informada | cnh            | Adicione uma foto da sua CNH               |