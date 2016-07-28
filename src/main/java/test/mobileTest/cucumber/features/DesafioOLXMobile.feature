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
    Entao sou direcionado para a tela de ofertas
    E digito o "ford fusion"
    E pressiono o botao buscar
    Entao sou direcionado para a listagem de produtos