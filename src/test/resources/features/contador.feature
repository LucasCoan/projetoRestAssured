Feature: Validando se Contador é Incrementado de Forma Correta

  @contador
  Scenario: Deve incrementar contador
    Given que o valor do contador e 15
    When o usuario incrementar em 3
    Then o valor do contador deve ser 18

  @contador
  Scenario: Deve incrementar contador
    Given que o valor do contador e 123
    When o usuario incrementar em 35
    Then o valor do contador deve ser 158

  @entrega
  Scenario: Deve calcular atraso na entrega
    Given que a entrega e dia 05/04/2018
    When a entrega atrasar em 2 dias
    Then a entrega sera efetuada em "07/04/2018"

