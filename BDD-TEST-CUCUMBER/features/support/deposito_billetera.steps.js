const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

let monto = 0;
let httpOptions = {};
let walletResponse = undefined;

Given('el monto de dinero {int}', function (pmonto) {
  monto = pmonto;
  urlEndpoint = "http://localhost:8080/ApiRestProyectoFinalModulo3/webresources/wallet/cashin";
});

When('Preparo la solicitud del doposito', function () {
  console.log('DONE');
  httpOptions = {
    method: 'POST',
    uri: urlEndpoint,
     form: {
        monto: monto
    },
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    resolveWithFullResponse: true
  };
});

Then('Hago un request POST hacia el url cashin con los datos', async function () {
  await httpClient(httpOptions)
    .then(function(response) {
      walletResponse = response;
    })
    .catch(function(error) {
      walletResponse = error;
    });
});

Then('Recibo http status {int} como una respuesta de hacer el deposito', function (httpStatus) {
  expect(walletResponse.statusCode).to.eql(httpStatus);
});
