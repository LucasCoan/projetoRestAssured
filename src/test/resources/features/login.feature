Feature: Validando os cenarios da api ServeRest

  @serveRest
  Scenario Outline: Validando a API de Login com Sucesso
    Given que o usuario efetua o login enviando o "<payload>"
#    Then  deve receber um status code <statusCode>
#    And o campo authorization "<authorization>" nao pode ser nulo

    Examples:
      | statusCode | payload    |  |
      | 200        | login.json |  |