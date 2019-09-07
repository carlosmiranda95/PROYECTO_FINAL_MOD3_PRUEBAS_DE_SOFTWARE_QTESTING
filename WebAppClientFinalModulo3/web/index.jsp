<%-- 
    Document   : index
    Created on : 06-09-2019, 01:57:06 AM
    Author     : Carlos Miranda Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <center>
                <form>
                    <div class="row">
                        <div class="col-sm-4">
                            <label for="txtmonto">Monto de Dinero</label>
                            <input type="number" class="form-control" id="txtmonto" placeholder="Monto">
                        </div>
                        <div class="col-sm-4">
                            <label id="lblrespuesta">Respuesta</label>
                        </div>
                    </div>
                    <br><br>
                    <div class="row">
                        <div class="col-sm-4">
                            <button id="btnconsultar" type="button" class="btn btn-success">Consultar</button>
                        </div>
                        <div class="col-sm-4">
                            <button id="btndepositar" type="button" class="btn btn-primary">Depositar</button>
                        </div>
                        <div class="col-sm-4">
                            <button id="btnretirar" type="button" class="btn btn-warning">Retirar</button>
                        </div>

                    </div>

                </form>
            </center>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
    <script>
        $("#btnconsultar").click(function(){
            
            $.ajax({
                    url: "http://localhost:8080/ApiRestProyectoFinalModulo3/webresources/wallet/getbalance",
                    type: 'POST',
                    data: {
                    },
                    success: function (data) {
                        debugger;
                        $("#lblrespuesta").html(JSON.stringify(data));
                    },
                    error: function (xhr) {
                        alert("Something seems Wrong");
                    }
                });
        });
        $("#btndepositar").click(function(){
            
            $.ajax({
                    url: "http://localhost:8080/ApiRestProyectoFinalModulo3/webresources/wallet/cashin",
                    type: 'POST',
                    data: {
                        monto: $("#txtmonto").val()
                    },
                    success: function (data) {
                        debugger;
                        $("#lblrespuesta").html(JSON.stringify(data));
                    },
                    error: function (xhr) {
                        alert("Something seems Wrong");
                    }
                });
        });
        $("#btnretirar").click(function(){
            
            $.ajax({
                    url: "http://localhost:8080/ApiRestProyectoFinalModulo3/webresources/wallet/cashout",
                    type: 'POST',
                    data: {
                        monto:$("#txtmonto").val()
                    },
                    success: function (data) {
                        debugger;
                        $("#lblrespuesta").html(JSON.stringify(data));
                    },
                    error: function (xhr) {
                        alert("Something seems Wrong");
                    }
                });
        });
    </script>
</html>

