const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

let urlEndpoint = "";
let httpOptions = {};
let walletResponse = undefined;

Given('el endpoint wallet', function () {
  urlEndpoint = "http://localhost:8080/ApiRestProyectoFinalModulo3/webresources/wallet/getbalance";
});

When('Preparo la solicitud', function () {
  console.log('DONE');
  httpOptions = {
    method: 'POST',
    uri: urlEndpoint,
    json: true,
    body: null,
    resolveWithFullResponse: true
  };
});

Then('Hago un request POST hacia el url getbalance', async function () {
  await httpClient(httpOptions)
    .then(function(response) {
      walletResponse = response;
    })
    .catch(function(error) {
      walletResponse = error;
    });
});

Then('Recibo una respuesta con http status {int}', function (httpStatus) {
  expect(walletResponse.statusCode).to.eql(httpStatus);
});
