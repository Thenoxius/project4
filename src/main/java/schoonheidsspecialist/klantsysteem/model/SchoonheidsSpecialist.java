package schoonheidsspecialist.klantsysteem.model;

import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;


public class SchoonheidsSpecialist implements Serializable {
    private  List<Klant> mijnKlanten = new ArrayList<Klant>();

    private List<Behandeling> mijnBehandelingen = new ArrayList<>();

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
        mijnBehandelingen.add(new Behandeling((LocalDate.of(2022, 8, 8)), LocalTime.of( 14, 33, 48), LocalTime.of( 16, 33, 48), getKlant("Thomas van Rens").getNaam(), "massage" ));
        mijnBehandelingen.add(new Behandeling((LocalDate.of(2022, 8, 9)), LocalTime.of( 14, 33, 48), LocalTime.of( 16, 33, 48), getKlant("Simone Abel").getNaam(), "massage" ));
        mijnBehandelingen.add(new Behandeling((LocalDate.of(2022, 8, 10)), LocalTime.of( 14, 33, 48), LocalTime.of( 16, 33, 48), getKlant("Sanne Vondracek").getNaam(), "massage" ));

    }
    public  void addKlant(Klant klant){
        if (!mijnKlanten.contains(klant)){

            mijnKlanten.add(klant);
        }
    }
    public List<Klant> getMijnKlanten() {
        return mijnKlanten;
    }

    public Klant getKlant(String name){
        for (Klant klant: mijnKlanten){
            if (klant.getNaam().equals(name)){
                return klant;
            }
        }
        return null;
    }
    public  void addBehandeling(Behandeling behandeling){
        if (!mijnBehandelingen.contains(behandeling)){

            mijnBehandelingen.add(behandeling);
        }
    }
    public List<Behandeling> getmijnBehandelingen() {
        return mijnBehandelingen;
    }

    public List<Behandeling> getmijnBehandelingenGesorteerd() {

        Comparator <Behandeling> dateVerglijker = Comparator.comparing(Behandeling::getBehandelDatum);

        List<Behandeling> alle = getmijnBehandelingen();
        Collections.sort(alle, dateVerglijker);

        return alle;
    }


    public  boolean removeKlant(String name) {
        for (Klant klant1 : mijnKlanten) {
            if (klant1.getNaam().equals(name)) {
                mijnKlanten.remove(klant1);
                return true;
            }



        }return false;
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
