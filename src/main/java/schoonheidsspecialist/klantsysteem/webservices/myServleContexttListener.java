package schoonheidsspecialist.klantsysteem.webservices;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class myServleContexttListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            PersistenceManager.loadWorldFromAzure();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("er is een ioexception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("er is een printstacktrace");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            PersistenceManager.saveWorldToAzure();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
