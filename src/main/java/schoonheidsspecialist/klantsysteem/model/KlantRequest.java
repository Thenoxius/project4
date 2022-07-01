package schoonheidsspecialist.klantsysteem.model;

import java.time.LocalDate;

public class KlantRequest {
    private String naam;
    private String geboorteDatum;
    private String telefoonNummer;
    private String straat;
    private String woonPlaats;
    private String postcode;
    public String getnaam() {
        return naam;
    }

    public void setnaam(String naam) {
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


}
