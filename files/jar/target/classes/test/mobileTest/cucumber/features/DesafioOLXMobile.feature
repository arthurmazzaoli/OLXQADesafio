# language: pt

Funcionalidade: Pesquisa de produto
  Como um usuário Android, acesso o aplicativo OLX e pesquiso um produto

  Cenario: Pesquisar produto
    Dado que o campo estado esteja visivel na tela inicial do aplicativo
    E eu pressione o botão estado
    Entao sou direcionato para a lista de estados
    Quando clico em Rio de Janeiro
    Entao sou direcionado para a listagem de regioes e DDD
    Quando clico em DDD Rio de Janeiro e regiao
    Entao o sistema exibe a mensagem "Selecione aqui a cidade e bairros desejados"
    Quando clico em OK
    E clico na lupa de pesquisa
    E digito o "ford fusion"
    Entao sou direcionado para a listagem de produtos