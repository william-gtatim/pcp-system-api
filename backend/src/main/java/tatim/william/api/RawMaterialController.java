package tatim.william.api;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tatim.william.application.rawmaterial.CreateRawMaterialUseCase;
import tatim.william.application.rawmaterial.RawMaterialService;
import tatim.william.application.rawmaterial.dtos.RawMaterialRequest;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("raw-materials")
public class RawMaterialController {
    @Inject
    RawMaterialService service;
    @Inject
    CreateRawMaterialUseCase createService;

    @GET
    public Response list(){
        return Response.ok(service.list()).build();
    }

    @POST
    public Response post(@Valid RawMaterialRequest dto){
        return Response.ok(createService.create(dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        service.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response update(
            @PathParam("id") Long id,
            @Valid RawMaterialRequest dto
    ){
        return Response.ok(service.update(dto, id)).build();
    }
}
