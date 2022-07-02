package schoonheidsspecialist.klantsysteem.webservices;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import schoonheidsspecialist.klantsysteem.model.SchoonheidsSpecialist;

import java.io.*;

public class PersistenceManager {
    private final static String ENDPOINT = "https://thomasvanrens.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2022-08-04T04:05:36Z&st=2022-06-19T20:05:36Z&spr=https,http&sig=cIGaNseA36IYg0IN3sVvY5UhBABZMmwMv8pKllHSQ%2FI%3D";
    private final static String CONTAINER = "testschoonheid";
    private static BlobContainerClient blobcontainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void loadWorldFromAzure() throws IOException, ClassNotFoundException {
        if (blobcontainer.exists()) {
            BlobClient blob = blobcontainer.getBlobClient("schoonheidsspecialistblob");
            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                System.out.println("er is een blob gevonden en geladen");
                SchoonheidsSpecialist loadedSchoonheidsSpecialist = (SchoonheidsSpecialist) ois.readObject();
                System.out.println(loadedSchoonheidsSpecialist.toString());
                SchoonheidsSpecialist.setSchoonheidsSpecialist(loadedSchoonheidsSpecialist);
                System.out.println(SchoonheidsSpecialist.getSchoonheidsSpecialist().toString());
                ois.close();
            }
        }
    }

    public static void saveWorldToAzure () throws IOException {
        if (!blobcontainer.exists()){
            blobcontainer.create();
        }
        BlobClient blob = blobcontainer.getBlobClient("schoonheidsspecialistblob");
        SchoonheidsSpecialist schoonheidsSpecialisttosave = SchoonheidsSpecialist.getSchoonheidsSpecialist();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(schoonheidsSpecialisttosave);

        byte[] bytex = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytex);
        blob.upload(bais, bytex.length, true);
        System.out.println("blob is ge-upload");
        System.out.println(schoonheidsSpecialisttosave.toString());
        oos.close();
    }
}
