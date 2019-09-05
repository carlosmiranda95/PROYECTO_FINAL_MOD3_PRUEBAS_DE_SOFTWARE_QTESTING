/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apirestproyectofinalmodulo3;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Carlos Miranda Rocha
 */
@Path("wallet")
public class ApiRestWallet {

    @Context
    private UriInfo context;

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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cashIn(String content) {
        return Response
          .status(Response.Status.OK)
          .entity("")
          .type(MediaType.APPLICATION_JSON)
          .build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cashOut(String content) {
        return Response
          .status(Response.Status.OK)
          .entity("")
          .type(MediaType.APPLICATION_JSON)
          .build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBalance(String content) {
        return Response
          .status(Response.Status.OK)
          .entity("")
          .type(MediaType.APPLICATION_JSON)
          .build();
    }
}
