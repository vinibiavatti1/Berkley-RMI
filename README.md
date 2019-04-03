# FURB - Trabalho Berkeley com RMI
Trabalho de Sistemas Distribuídos - Berkeley

## Execução
Para realizar a execução do projeto, a variável de ambiente <b>CLASSPATH</b> preicsa estar definida com o seguinte valor:
- <b>.;%JAVA_HOME%\lib</b> (Não esquecer do ponto inicial)

Após a configuração da variável de ambiente, o rmiregistry.exe precisa estar em execução. Para isto, basta abrir um prompt (cmd) no diretório <b>%JAVA_HOME%\lib</b> e digitar o comando <b>start rmiregistry.exe</b>.

Para executar o projeto, basta abri-lo em uma IDE e executar a classe <b>MainServidor</b>. No console irá retornar uma mensagem afirmando se os servidors 1 e 2 estão iniciados. Após isto, executar a classe <b>MainCliente</b> que irá acessar os dados dos servidores 1 e 2, e gerar o novo horário com base no horário deles.

## Exemplo de Saída
```
Horário Local: 05:10:05
Conexão com Servidor 1 estabelecida com sucesso.
Horário Servidor 1: 07:30:10
Conexão com Servidor 2 estabelecida com sucesso.
Horário Servidor 2: 09:20:15
Média: 07:20:10
Horários atualizados
Horario Local: 07:20:10
Horario Servidor 1: 07:20:10
Horario Servidor 2: 07:20:10
```

## Alunos
- Vinícius
- Alexandre
- Bryan
