const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const { Builder, By, Key, until } = require('selenium-webdriver');

let monto = 0;
let chromeDriver = undefined;

Given('Dado el monto {int} para retirar de mi billetera', function (int) {
  monto = int;
});

When('Navego a la pagina principal', async function () {
  chromeDriver = await new Builder().forBrowser('chrome').build();
  await chromeDriver.get('http://localhost:8080/WebAppClientFinalModulo3');
});

When('Llenar el campo de monto', async function () {
  await chromeDriver.findElement(By.name('txtmonto')).sendKeys(monto);
});

When('Hacer click en el boton retirar', async function () {
  await chromeDriver.findElement(By.name('btnretirar')).click();
});

Then('Se debe mostrar la respuesta {string}', async function (expected) {
  await chromeDriver.findElement(By.name('lblrespuesta'))
    .getText().then(function (text) {
      showText = text;
    });

  expect(showText).to.eql(expected);
  await chromeDriver.quit();
});
