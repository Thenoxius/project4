package schoonheidsspecialist.klantsysteem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Klant implements Serializable {
    private String naam;
    private String geboorteDatum;
    private String telefoonNummer;
    private String straat;
    private String woonPlaats;
    private String postcode;
    /*
    private ArrayList<String> huidkenmerken = new ArrayList<>();;
    private ArrayList<Product> gekochteProducten = new ArrayList<>();;
    private ArrayList<Behandeling> mijnBehandelingen = new ArrayList<>();;
    private ArrayList<FamilieLidVanKlant> familieVan = new ArrayList<>();;
*/
    public Klant(String naam, String geboorteDatum, String telefoonNummer, String straat, String woonPlaats, String postcode) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.telefoonNummer = telefoonNummer;
        this.straat = straat;
        this.woonPlaats = woonPlaats;
        this.postcode = postcode;
    }


    /*public static boolean removeKlant(String naam, String geboorteDatum, String telefoonNummer, String straat, String woonPlaats, String postcode) {
        Klant klant = new Klant(naam, geboorteDatum, telefoonNummer, straat, woonPlaats, postcode);
        if (alleKlanten.contains(klant)) {
            alleKlanten.remove(klant);
            SchoonheidsSpecialist.getMijnKlanten().remove(klant);
            return true;
        }
        return false;
    }*/

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonPlaats() {
        return woonPlaats;
    }

    public void setWoonPlaats(String woonPlaats) {
        this.woonPlaats = woonPlaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String toString() {
        String s = "naam: "+ naam + " geboortedatum: " + geboorteDatum + " telefoonnummer: " + telefoonNummer + " woont op adres: " + straat + " " + postcode + " " + woonPlaats + "\n";
        return s;
    }
/*
    public ArrayList<String> getHuidkenmerken() {
        return huidkenmerken;
    }

    public void addHuidkenmerken(String kenmerk) {
        huidkenmerken.add(kenmerk);
    }

    public void removeHuidkenmerk(String kenmerk) {
        for (String huidkenmerk : huidkenmerken){
            if (huidkenmerk.equals(kenmerk)){
                huidkenmerken.remove(huidkenmerk);
            }
        }
    }

    public void koop(Product product, LocalDate aanschafDatum, int aantalStuks){
        this.gekochteProducten.add(product);
        for (Product aangekocht : gekochteProducten){
            if (aangekocht.equals(product)){
                aangekocht.setAanschafDatum(aanschafDatum);
                aangekocht.verhoogAantalgekocht(aantalStuks);
            }
        }
        product.setAantalBesschikbaar((product.getAantalBesschikbaar()-aantalStuks));

    }

    public void addBehandeling(Behandeling behandeling){
        mijnBehandelingen.add(behandeling);
    }

    public ArrayList getBehandelingen(){
        return mijnBehandelingen;
    }

    public void addFamilieLid(FamilieLidVanKlant fam){
        familieVan.add(fam);
    }

    public ArrayList getFamilieVan(){
        return familieVan;
    }

    @Override
    public String toString() {
        String s = "naam: "+ naam + " geboortedatum: " + geboorteDatum + " telefoonnummer: " + telefoonNummer + " woont op adres: " + straat + " " + postcode + " " + woonPlaats + "\n";
        if (!gekochteProducten.isEmpty()){
            s+="en heeft de volgende producten gekocht:\n";
            for (Product product: gekochteProducten)
                s += product;
        }
        return s;
    }

    public double maakRekening(LocalDate beginDatum, LocalDate eindDatum){
        ArrayList<Behandeling> eindafrekeningBehandelingen = new ArrayList<>();
        for (Behandeling behandeling : mijnBehandelingen){
            if (behandeling.getBehandelDatum().isBefore(eindDatum) && behandeling.getBehandelDatum().isAfter(beginDatum)){
                eindafrekeningBehandelingen.add(behandeling);
            }
        }
        double totaalkosten = 0;
        for (Behandeling behandeling : eindafrekeningBehandelingen){
            totaalkosten += behandeling.getTotaalPrijs();
        }
        ArrayList<Product> eindafrekeningproducten = new ArrayList<>();
        for (Product product : gekochteProducten){
            if (product.getAanschafDatum().isBefore(eindDatum) && product.getAanschafDatum().isAfter(beginDatum)){
                eindafrekeningproducten.add(product);
            }
        }
        for (Product product : eindafrekeningproducten){
            totaalkosten += (product.getProductPrijs() * product.getAantalGekocht());
        }
        return totaalkosten;
    }
    public ArrayList getGekochteProducten(){
        return gekochteProducten;
    }*/
}
