package schoonheidsspecialist.klantsysteem.webservices;
import schoonheidsspecialist.klantsysteem.model.SchoonheidsSpecialist;
import schoonheidsspecialist.klantsysteem.model.Klant;
import schoonheidsspecialist.klantsysteem.model.KlantRequest;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("klantbestand")
public class KlantenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKlanten(){
        SchoonheidsSpecialist schoonheidsSpecialist = SchoonheidsSpecialist.getSchoonheidsSpecialist();
        ArrayList<Klant> klanten = new ArrayList<Klant>();
        for (Klant klant : schoonheidsSpecialist.getMijnKlanten()){
            klanten.add(klant);
        }
        return Response.ok(klanten).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKlantDetails(@PathParam("name") String name){
        SchoonheidsSpecialist schoonheidsSpecialist = SchoonheidsSpecialist.getSchoonheidsSpecialist();
        for (Klant klant : schoonheidsSpecialist.getMijnKlanten()){
            if (klant.getNaam().equals(name)){
                return Response.ok(klant).build();
            }
        }
        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShopper(KlantRequest klantRequest) {
        SchoonheidsSpecialist schoonheidsSpecialist = SchoonheidsSpecialist.getSchoonheidsSpecialist();
        Klant nieuweKlant = new Klant(klantRequest.getnaam(), klantRequest.getGeboorteDatum(), klantRequest.getTelefoonNummer(), klantRequest.getStraat(), klantRequest.getWoonPlaats(), klantRequest.getPostcode());
        System.out.println(nieuweKlant);
        schoonheidsSpecialist.addKlant(nieuweKlant);
        System.out.println(schoonheidsSpecialist);
        return Response.ok(nieuweKlant).build();
    }

    @DELETE
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteShopper(@PathParam("name") String name) {
        SchoonheidsSpecialist schoonheidsSpecialist = SchoonheidsSpecialist.getSchoonheidsSpecialist();
        return schoonheidsSpecialist.removeKlant(name)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
