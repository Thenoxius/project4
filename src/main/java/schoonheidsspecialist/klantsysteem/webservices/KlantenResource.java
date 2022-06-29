package schoonheidsspecialist.klantsysteem.webservices;

import schoonheidsspecialist.klantsysteem.model.Klant;
import schoonheidsspecialist.klantsysteem.model.SchoonheidsSpecialist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/klantbestand")
public class KlantenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKlanten(){
        ArrayList<Klant> lijstje =SchoonheidsSpecialist.getMijnKlanten();
        return Response.ok(lijstje).build();
    }
}
