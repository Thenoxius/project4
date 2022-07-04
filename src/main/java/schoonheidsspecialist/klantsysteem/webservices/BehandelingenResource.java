package schoonheidsspecialist.klantsysteem.webservices;
import schoonheidsspecialist.klantsysteem.model.Behandeling;
import schoonheidsspecialist.klantsysteem.model.SchoonheidsSpecialist;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;

@Path("behandelingen")
public class BehandelingenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBehandelingen(){
        SchoonheidsSpecialist schoonheidsSpecialist = SchoonheidsSpecialist.getSchoonheidsSpecialist();
        ArrayList<Behandeling> behandelingen = new ArrayList<Behandeling>();
        for (Behandeling behandeling : schoonheidsSpecialist.getmijnBehandelingenGesorteerd()){
            behandelingen.add(behandeling);
        }
        return Response.ok(behandelingen).build();
    }
}
