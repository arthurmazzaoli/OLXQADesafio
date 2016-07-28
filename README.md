# desafioQA

Objetivo

Verificar suas habilidades em definir cenários de testes e em programação, necessárias para automatização dos testes.

Regras:

- Pode usar qualquer linguagem de programação;

- Seu programa deve fazer o seguinte:

- Acessar o site da OLX e criar a estrutura para a escrita dos testes automatizados em BDD

- Criar testes funcionais (Cenários para Web e Mobile sites)

- Exibir relatório de execução em HTML

- Criar ou utilizar alguma API já existente e criar pelo menos 2 cenários de testes para ela (Um GET e um POST).

- Adicionar uma rotina para execução dos testes automaticamente

- Vamos executar seu programa em um Mac OS X ou alguma distribuição Linux. Para isso, forneça um arquivo README explicando:
como executar os testes.

--------------------------------------------------------------------------------------------------------------------------------------

-----------------
TESTES WEB e REST
-----------------

A pasta files/jar contém todo o conteúdo gerado pela compilação do Maven, basta executar o jar DesafioQA-1.0.jar em um sistema operacional Windows, MacOS ou qualquer outra distribuição linux.

Ao executar, irá carregar um form com um console e 3 botões: Testes Rest, Testes Web e Testes Mobile.

![screen shot](http://arthurmazza.azurewebsites.net/form.png)

Após a execução de cada teste, ele irá logar o resultado no console.

--------------
TESTES ANDROID
--------------

1 - Realizar download do Genymotion com Virtual box e realizar sua instalação;
    1.1 - Acessar https://www.genymotion.com/;
    
2 - Realizar download e instalar o JDK;

3 - Criar as váriáveis de ambiente JAVA_HOME e o PATH;

4 - Realizar Download e instalar o Android SDK;

5 - Criar a váriavel de ambiente do ANDROID_HOME;

6 - Acessar o SDK Manager na pasta de instalação do passo 3 e atualizar o Android;
   6.1 Abrir o SDK Manager;
   6.2 Selecionar as opções 
      6.2.1 Ramificação Tools: Android SDK Tool, Android SDK Platform-tools e Android SDK Build-tools (desmarcar todas as outras opções desta ramificação Tools);
      6.2.2 Ramificação Android 4.4.2 (Api 19) : SDK Platform e ARM EABI v7a System Image;
      6.2.3 Selecionar o botão Install packages;
   
7 - Realizar o download e instalar o Appium (http://appium.io/);

8 - Realizar download das bibliotecas do Appium;
    8.1 Acessar site Appium (http://appium.io/)
    8.2 Selecionar Documentation > Master
    8.3 Selecionar Java Bindings
    8.4 Realizar download Java_Client
 
9 - Na pasta de instalação do Android SDK, acessar o AVD Manager;
    9.1 Criar o dispositivo virutal do Android com as seguintes configurações
    
 AVD NAME: Nexus
 DEVICE: Nexus 4
 TARGET: Android 4.4.2 - API Level 19
 CPU/ABI:ARM(armeabi-v7a)
 Memory RAM: 1907
 Internal Storage: 512
 
----------
RELATÓRIOS
----------

 
 O relatório de execução da aplicação WEB, é salvo na pasta: files\jar\target\Destination\web.
 
 O relatório de execução da aplicação Mobile, é salvo na pasta: files\jar\target\Destination\mobile.
 
 Para visualizar, basta abrir o arquivo index.html dentro de cada diretório. 
