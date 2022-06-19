package schoonheidsspecialist.setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("schoonheidsspecialist.klantsysteem.webservices");
    }
}
