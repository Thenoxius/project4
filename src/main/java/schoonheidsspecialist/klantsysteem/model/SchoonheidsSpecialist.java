package schoonheidsspecialist.klantsysteem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class SchoonheidsSpecialist implements Serializable {
    private String loginNaam;
    private String wachtwoord;
    private ArrayList<Klant> mijnKlanten = new ArrayList<>();

    private static SchoonheidsSpecialist mijnZaak = new SchoonheidsSpecialist();

    public static SchoonheidsSpecialist getSchoonheidsSpecialist() {
        return mijnZaak;
    }

    public static void setSchoonheidsSpecialist(SchoonheidsSpecialist schoonheidsSpecialist) {mijnZaak = schoonheidsSpecialist;
    }

    public String getLoginNaam() {
        return loginNaam;
    }

    public void setWachtwoord(String oudWachtwoord, String nieuwWachtwoord) {
        if(this.wachtwoord.equals(oudWachtwoord)){
            wachtwoord = nieuwWachtwoord;
        }
    }

    public ArrayList<Klant> getMijnKlanten() {
        return mijnKlanten;
    }

    public void addKlant(Klant klant){
        if (!mijnKlanten.contains(klant)){
            mijnKlanten.add(klant);
        }
    }

    public double maakEindafrekening(LocalDate begindatum, LocalDate einddatum){
        double totaalkosten = 0;
        for (Klant klant : mijnKlanten){
            totaalkosten += klant.maakRekening(begindatum, einddatum);
        }
        return totaalkosten;
    }

    private SchoonheidsSpecialist(){
        addKlant(new Klant("Thomas van Rens",(LocalDate.of(1960, 5, 13)), "0681716632", "keizerstraat 10B", "Gouda", "2801NL"));
        addKlant(new Klant("Simone Abel",(LocalDate.of(1964, 9, 2)), "0610434758", "Steinsedijk 7a", "Haastrecht", "2851SL"));
    }

}
