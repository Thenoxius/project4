package schoonheidsspecialist.klantsysteem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;


public class SchoonheidsSpecialist implements Serializable {
    private static List<Klant> mijnKlanten = new ArrayList<Klant>();

    private static SchoonheidsSpecialist mijnZaak = new SchoonheidsSpecialist();

    public static SchoonheidsSpecialist getSchoonheidsSpecialist() {
        return mijnZaak;
    }

    public static void setSchoonheidsSpecialist(SchoonheidsSpecialist schoonheidsSpecialist) {mijnZaak = schoonheidsSpecialist;
    }
    private SchoonheidsSpecialist(){
        mijnKlanten.add(new Klant("Thomas van Rens","04/12/1991", "0681716632", "keizerstraat 10B", "Gouda", "2801NL"));
        mijnKlanten.add(new Klant("Simone Abel","02/09/1964", "0610434758", "Steinsedijk 7a", "Haastrecht", "2851SL"));
        mijnKlanten.add(new Klant("Sanne Vondracek","28/04/1987", "0681765955", "keizerstraat 10B", "Gouda", "2801NL"));
    }
    public static void addKlant(Klant klant){
        if (!mijnKlanten.contains(klant)){

            mijnKlanten.add(klant);
        }
    }
    public List<Klant> getMijnKlanten() {
        return mijnKlanten;
    }



    public String toString() {
        String s =  "mijnzaak heeft de volgende klanten\n";
        for (Klant klant : mijnKlanten){
            s+= klant.getNaam() + "\n";
        }
        return s;
    }

/*
    public double maakEindafrekening(LocalDate begindatum, LocalDate einddatum){
        double totaalkosten = 0;
        for (Klant klant : mijnKlanten){
            totaalkosten += klant.maakRekening(begindatum, einddatum);
        }
        return totaalkosten;
    }*/



}
