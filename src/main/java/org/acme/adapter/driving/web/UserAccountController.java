package org.acme.adapter.driving.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.application.port.driving.UserAccountUseCase;
import org.acme.domain.dto.UserAccountRequest;
import org.acme.domain.dto.UserAccountResponse;
import org.acme.domain.model.UserAccount;
import org.bson.types.ObjectId;

import java.net.URI;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserAccountController {

    @Inject
    UserAccountUseCase userAccountUseCase;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUserAccount(UserAccountRequest userAccountRequest){

        UserAccount userAccount = userAccountUseCase.createAccount(userAccountRequest);
        return Response.created(URI.create(userAccount.id().toString())).entity(userAccount).build();

    }

    @PUT
    @Path("/update/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserAccount(@PathParam("userId") String userId, UserAccountRequest userAccountRequest){

        ObjectId id = new ObjectId(userId);
        UserAccount userAccount = userAccountUseCase.updateAccount(id, userAccountRequest);
        return Response.ok(userAccount).build();

    }

    @GET
    @Path("/by-email")
    public Response findByEmail(@QueryParam("email") String email){

        UserAccountResponse userAccountResponse = userAccountUseCase.findByEmail(email);
        return Response.ok(userAccountResponse).build();

    }

    @GET
    @Path("/all")
    public Response findAllUserAccount(){

        List<UserAccountResponse> userAccountResponses = userAccountUseCase.findAll();
        return Response.ok(userAccountResponses).build();

    }

    @DELETE
    @Path("/delete/{userId}")
    public Response deleteUserAccount(@PathParam("userId") String userId){

        ObjectId id = new ObjectId(userId);
        boolean isDeleted = userAccountUseCase.delete(id);
        return isDeleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();

    }

}
