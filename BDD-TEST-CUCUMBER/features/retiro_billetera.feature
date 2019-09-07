Feature: Retirar dinero de la billetera
 Como Usuario Final (humano)
 Quiero Retirar dinero de mi billetera

 Scenario: Retiro de dinero
  Given Dado el monto 50 para retirar de mi billetera
   When Navego a la pagina principal 
     And Llenar el campo de monto
     And Hacer click en el boton retirar
     Then Se debe mostrar la respuesta {"codigo":"0","retiro":"50.0","saldo":"200.0"}