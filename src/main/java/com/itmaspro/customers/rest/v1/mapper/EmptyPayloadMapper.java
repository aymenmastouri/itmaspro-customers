package com.itmaspro.customers.rest.v1.mapper;

import com.itmaspro.customers.logic.exceptions.EmptyPayloadException;
import com.itmaspro.general.domain.models.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;
@Provider
public class EmptyPayloadMapper implements ExceptionMapper<EmptyPayloadException>{
    @Override public Response toResponse(EmptyPayloadException exception)
    {
        ApiError error = new ApiError(UUID.randomUUID(),400,"resource.empty.payload");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
