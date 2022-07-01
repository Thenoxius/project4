package schoonheidsspecialist.klantsysteem.webservices;
import schoonheidsspecialist.klantsysteem.model.SchoonheidsSpecialist;
import schoonheidsspecialist.klantsysteem.model.Klant;
import schoonheidsspecialist.klantsysteem.model.KlantRequest;
import schoonheidsspecialist.klantsysteem.model.SchoonheidsSpecialist;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("klantbestand")
public class KlantenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKlanten(){
        ArrayList<Klant> klanten =SchoonheidsSpecialist.getMijnKlanten();
        return Response.ok(klanten).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShopper(KlantRequest klantRequest) {
        SchoonheidsSpecialist schoonheidsSpecialist = SchoonheidsSpecialist.getSchoonheidsSpecialist();
        Klant nieuweKlant = new Klant(klantRequest.getnaam(), klantRequest.getGeboorteDatum(), klantRequest.getTelefoonNummer(), klantRequest.getStraat(), klantRequest.getWoonPlaats(), klantRequest.getPostcode());
        System.out.println(nieuweKlant);
        schoonheidsSpecialist.addKlant(nieuweKlant);
        return Response.ok(nieuweKlant).build();
    }
}
