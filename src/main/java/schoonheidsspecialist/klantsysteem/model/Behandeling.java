package schoonheidsspecialist.klantsysteem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Behandeling implements Serializable {
    private LocalDate behandelDatum;
    private LocalDateTime beginTijd;
    private LocalDateTime eindTijd;
    private double totaalPrijs;
    private Klant klant;
    private ArrayList<String> opmerkingen;

    public Behandeling(LocalDate behandelDatum, LocalDateTime beginTijd, LocalDateTime eindTijd) {
        this.behandelDatum = behandelDatum;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.klant = klant;
    }

    public LocalDate getBehandelDatum() {
        return behandelDatum;
    }

    public void setBehandelDatum(LocalDate behandelDatum) {
        this.behandelDatum = behandelDatum;
    }

    public LocalDateTime getBeginTijd() {
        return beginTijd;
    }

    public void setBeginTijd(LocalDateTime beginTijd) {
        this.beginTijd = beginTijd;
    }

    public LocalDateTime getEindTijd() {
        return eindTijd;
    }

    public void setEindTijd(LocalDateTime eindTijd) {
        this.eindTijd = eindTijd;
    }

    public double getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(double totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }

    public Klant getKlant() {
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
}
