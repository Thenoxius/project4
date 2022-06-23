package schoonheidsspecialist.klantsysteem.security;

import schoonheidsspecialist.klantsysteem.model.MyUser;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
public class MySecurityContext implements SecurityContext {
    private MyUser user;
    private String scheme;
    public MySecurityContext(MyUser user, String scheme) {
        this.user = user;
        this.scheme = scheme;
    }
    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }
    @Override
    public boolean isUserInRole(String s) {
        if (user.getRole() != null) {
            System.out.printf("%s equals %s", s, user.getRole());
            return s.equals(user.getRole());
        }
        return false;
    }
    @GET
    @Path("/calender")
    @RolesAllowed("admin")

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }
    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}
