$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DesafioOLX.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: pt"
    }
  ],
  "line": 3,
  "name": "Validar login do usuario",
  "description": "Como um usuario previamente cadastrado, eu acesso a tela de login do site OLX",
  "id": "validar-login-do-usuario",
  "keyword": "Funcionalidade"
});
formatter.before({
  "duration": 4062899375,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Acessar tela de login",
  "description": "",
  "id": "validar-login-do-usuario;acessar-tela-de-login",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 7,
  "name": "que eu esteja na tela inicial \"http://www.olx.com.br/\"",
  "keyword": "Dado "
});
formatter.step({
  "line": 8,
  "name": "exista o campo Minha conta no inicio da pagina",
  "keyword": "E "
});
formatter.step({
  "line": 9,
  "name": "eu clico no botao Minha conta",
  "keyword": "Quando "
});
formatter.step({
  "line": 10,
  "name": "sou direcionado para a tela de login \"https://www3.olx.com.br/account/form_login\"",
  "keyword": "Entao "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.olx.com.br/",
      "offset": 31
    }
  ],
  "location": "Step_DesafioOLX.acessarTelaInicial(String)"
});
formatter.result({
  "duration": 4999197293,
  "status": "passed"
});
formatter.match({
  "location": "Step_DesafioOLX.verificarExistenciaCampoMinhaConta()"
});
formatter.result({
  "duration": 704318622,
  "status": "passed"
});
formatter.match({
  "location": "Step_DesafioOLX.pressionarBotaoMinhaConta()"
});
formatter.result({
  "duration": 121170678,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www3.olx.com.br/account/form_login",
      "offset": 38
    }
  ],
  "location": "Step_DesafioOLX.validarDirecionamentoTelaLogin(String)"
});
formatter.result({
  "duration": 9281641919,
  "status": "passed"
});
formatter.before({
  "duration": 18389,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Logar no sistema",
  "description": "",
  "id": "validar-login-do-usuario;logar-no-sistema",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 13,
  "name": "que na tela de login, os campos email e senha estejam visiveis",
  "keyword": "Dado "
});
formatter.step({
  "line": 14,
  "name": "eu preencho o \"desafioolxqa@gmail.com\" valido",
  "keyword": "Quando "
});
formatter.step({
  "line": 15,
  "name": "preencho a \"12344321\" valida",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "Pressiono o botao Entrar",
  "keyword": "E "
});
formatter.step({
  "line": 17,
  "name": "eu sou direcionado para tela incial do usuario OLX",
  "keyword": "Entao "
});
formatter.match({
  "location": "Step_DesafioOLX.VerificarExistenciaCampoLoginSenha()"
});
formatter.result({
  "duration": 122261196,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "desafioolxqa@gmail.com",
      "offset": 15
    }
  ],
  "location": "Step_DesafioOLX.preencherEmail(String)"
});
formatter.result({
  "duration": 158224346,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "12344321",
      "offset": 12
    }
  ],
  "location": "Step_DesafioOLX.preencherSenha(String)"
});
formatter.result({
  "duration": 108758871,
  "status": "passed"
});
formatter.match({
  "location": "Step_DesafioOLX.PressionaBotaoEntrar()"
});
formatter.result({
  "duration": 162110011,
  "status": "passed"
});
formatter.match({
  "location": "Step_DesafioOLX.verificarDirecionamentoTelaUsuarioLogado()"
});
formatter.result({
  "duration": 10667589117,
  "status": "passed"
});
});