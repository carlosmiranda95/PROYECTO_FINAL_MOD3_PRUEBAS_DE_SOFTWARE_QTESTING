Feature: Depositar dinero en la billetera
   Como un cliente de API WEB (no humano) prueba de escritura
   Requiero Depositar dinero en la billetera

  Scenario: Depositar dinero en la billetera
   Given el monto de dinero 100
    When Preparo la solicitud del doposito
    Then Hago un request POST hacia el url cashin con los datos
    Then Recibo http status 200 como una respuesta de hacer el deposito