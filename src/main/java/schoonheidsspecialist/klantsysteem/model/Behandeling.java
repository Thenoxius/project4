package schoonheidsspecialist.klantsysteem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Behandeling implements Serializable {
    private LocalDate behandelDatum;
    private LocalTime beginTijd;
    private LocalTime eindTijd;
    private double totaalPrijs;
    private String klant;

    private String behandelingType;
    private ArrayList<String> opmerkingen;

    public Behandeling(LocalDate behandelDatum, LocalTime beginTijd, LocalTime eindTijd, String klant, String behandelingType) {
        this.behandelDatum = behandelDatum;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.klant = klant;
        this.behandelingType = behandelingType;
    }

    public LocalDate getBehandelDatum() {
        return behandelDatum;
    }

    public void setBehandelDatum(LocalDate behandelDatum) {
        this.behandelDatum = behandelDatum;
    }

    public LocalTime getBeginTijd() {
        return beginTijd;
    }

    public void setBeginTijd(LocalTime beginTijd) {
        this.beginTijd = beginTijd;
    }

    public LocalTime getEindTijd() {
        return eindTijd;
    }


    public void setEindTijd(LocalTime eindTijd) {
        this.eindTijd = eindTijd;
    }

    public double getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(double totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }

    public String getKlant() {
        return klant;
    }
/*
    public void setKlant(Klant klant) {
        this.klant = klant;
        klant.addBehandeling(this);
    }*/

    public void addOpmerking(String opmerking){
        opmerkingen.add(opmerking);
    }

    public String toString(){
        String s = getKlant() + " : " + getBehandelDatum();
        return s;
    }
}
