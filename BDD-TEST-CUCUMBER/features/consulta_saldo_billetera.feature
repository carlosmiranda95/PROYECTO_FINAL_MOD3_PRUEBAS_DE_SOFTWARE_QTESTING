Feature: Consultar el saldo de mi billetera
   Como un cliente de API WEB (no humano) prueba de integracion solo lectura
   Requiero Consultar el saldo de mi billetera

  Scenario: Consulta de Saldo
   Given el endpoint wallet
    When Preparo la solicitud
    Then Hago un request POST hacia el url getbalance
    Then Recibo una respuesta con http status 200