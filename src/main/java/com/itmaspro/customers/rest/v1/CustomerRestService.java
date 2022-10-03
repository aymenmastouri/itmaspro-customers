package com.itmaspro.customers.rest.v1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itmaspro.customers.logic.UcFindCustomer;
import com.itmaspro.customers.logic.UcManageCustomer;
import com.itmaspro.general.domain.models.CustomerDto;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class CustomerRestService
{
    @Inject
    private UcFindCustomer ucFindCustomer;
    @Inject
    private UcManageCustomer ucManageCustomer;

    @GET
    public Response getCustomers(@QueryParam("limit") Integer limit,
                                 @QueryParam("offset") Integer offset) {
        return Response.ok(ucFindCustomer.findCustomers(limit, offset))
                .header("X-Total-Count", 0).build();
    }

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") String id) {

        return Response.ok(ucFindCustomer.findCustomerById(id)).build();
    }

    @POST
    public Response createCustomer(CustomerDto newCustomer){
        return Response.ok(ucManageCustomer.createCustomer(newCustomer)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") String id, CustomerDto updatedCustomer){

        return Response.ok(ucManageCustomer.updateCustomer(id, updatedCustomer)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") String id){

        ucManageCustomer.deleteCustomerById(id);

        return Response.noContent().build();
    }
	
}
