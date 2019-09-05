/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apirestproyectofinalmodulo3;

import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import persistence.SQLiteConnectionWallet;

/**
 * REST Web Service
 *
 * @author Carlos Miranda Rocha
 */
@Path("wallet")
public class ApiRestWallet {

    @Context
    private UriInfo context;
    SQLiteConnectionWallet objConnectionSql;
    /**
     * Creates a new instance of ApiRestWallet
     */
    public ApiRestWallet() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.apirestproyectofinalmodulo3.ApiRestWallet
     * @return an instance of java.lang.String
     */
    
    /**
     * PUT method for updating or creating an instance of ApiRestWallet
     * @param content representation for the resource
     */
    @POST
    @Path("cashin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cashIn(@FormParam("monto") double monto) {
        String message = "{\"codigo\": \"code\",\"entrada\": \"saldowallet\",\"saldo\": \"balance\"}";
        message = message.replaceAll("code","0");
        message = message.replaceAll("saldowallet",Double.toString(monto));
        message = message.replaceAll("balance",Double.toString(monto));
        return Response
          .status(Response.Status.OK)
          .entity(message)
          .type(MediaType.APPLICATION_JSON)
          .build();
    }
    
    @POST
    @Path("cashout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cashOut(@FormParam("monto") double monto) throws SQLException, ClassNotFoundException {
        objConnectionSql = new SQLiteConnectionWallet();
        String message = "{\"codigo\": \"code\",\"retiro\": \"retirowallet\",\"saldo\": \"saldowallet\"}";
        message = message.replaceAll("code","0");
        message = message.replaceAll("retirowallet",Double.toString(monto));
        message = message.replaceAll("saldowallet",objConnectionSql.cashOut(monto));
        return Response
          .status(Response.Status.OK)
          .entity(message)
          .type(MediaType.APPLICATION_JSON)
          .build();
    }
    
    @POST
    @Path("getbalance")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBalance() throws SQLException, ClassNotFoundException {
        objConnectionSql = new SQLiteConnectionWallet();
        String message = "{\"codigo\": \"code\",\"saldo\": \"saldowallet\"}";
        message = message.replaceAll("code","0");
        message = message.replaceAll("saldowallet",objConnectionSql.getBalance());
        return Response
          .status(Response.Status.OK)
          .entity(message)
          .type(MediaType.APPLICATION_JSON)
          .build();
    }
}
