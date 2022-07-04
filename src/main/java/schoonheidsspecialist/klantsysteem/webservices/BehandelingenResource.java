package schoonheidsspecialist.klantsysteem.webservices;
import schoonheidsspecialist.klantsysteem.model.Behandeling;
import schoonheidsspecialist.klantsysteem.model.Klant;
import schoonheidsspecialist.klantsysteem.model.SchoonheidsSpecialist;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("behandelingen")
public class BehandelingenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBehandelingen(){
        SchoonheidsSpecialist schoonheidsSpecialist = SchoonheidsSpecialist.getSchoonheidsSpecialist();
        ArrayList<Behandeling> lijstje = new ArrayList<Behandeling>();
        System.out.println(schoonheidsSpecialist.getmijnBehandelingen());
        for (Behandeling behandeling : schoonheidsSpecialist.getmijnBehandelingenGesorteerd()){
            lijstje.add(behandeling);
        }
        System.out.println(lijstje);
        return Response.ok(lijstje).build();
    }
}
