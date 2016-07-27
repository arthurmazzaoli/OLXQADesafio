# desafioQA

Objetivo

Verificar suas habilidades em definir cenários de testes e em programação, necessárias para automatização dos testes.
Regras

Pode usar qualquer linguagem de programação;

Seu programa deve fazer o seguinte:
Acessar o site da OLX e criar a estrutura para a escrita dos testes automatizados em BDD
Criar testes funcionais (Cenários para Web e Mobile sites)
Exibir relatório de execução em HTML
Criar ou utilizar alguma API já existente e criar pelo menos 2 cenários de testes para ela (Um GET e um POST).
Adicionar uma rotina para execução dos testes automaticamente
Vamos executar seu programa em um Mac OS X ou alguma distribuição Linux. Para isso, forneça um arquivo README explicando:
como executar os testes.

-----------------------------------------------------------------------------------------------------------------------------------------

INSTRUÇÕES

A pasta files/jar contém todo o conteúdo gerado pela compilação do Maven, basta executar o jar DesafioQA-1.0.jar em um sistema operacional Windows, MacOS ou qualquer outra distribuição linux.

TESTES ANDROID

1 - Realizar download e instalar o JDK 1.8;

2 - Criar as váriáveis de ambiente JAVA_HOME e o PATH;

3 - Realizar Download e instalar o Android SDK;

4 - Criar a váriavel de ambiente do ANDROID_HOME;

5 - Acessar o SDK Manager na pasta de instalação do passo 3 e atualizar o Android;
   5.1 Abrir o SDK Manager;
   5.2 Selecionar as opções 
   Ramificação Tools: Android SDK Tool, Android SDK Platform-tools e Android SDK Build-tools (desmarcar todas as outras opções desta ramificação Tools);
   Ramificação Android 4.4.2 (Api 19) : SDK Platform e ARM EABI v7a System Image;
   Selecionar o botão Install packages;
   
6 - Realizar o download e instalar o Appium (http://appium.io/);

7 - Realizar download das bibliotecas do Appium;
    7.1 Acessar site Appium (http://appium.io/)
    7.2 Selecionar Documentation > Master
    7.3 Selecionar Java Bindings
    7.4 Realizar download Java_Client
    
8 - Na pasta de instalação do Android SDK, acessar o AVD Manager;
    8.1 Criar o dispositivo virutal do Android com as seguintes configurações
    
 AVD NAME: Nexus
 DEVICE: Nexus 4
 TARGET: Android 4.4.2 - API Level 19
 CPU/ABI:ARM(armeabi-v7a)
 Memory RAM: 1907
 Internal Storage: 512
