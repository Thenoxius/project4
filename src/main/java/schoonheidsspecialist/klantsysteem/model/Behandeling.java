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
    private String klant;

    private String behandelingType;


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




    public String getKlant() {
        return klant;
    }

    public String getBehandelingType() {
    return behandelingType;
}

    public void setBehandelingType(String behandelingType) {
        this.behandelingType = behandelingType;
    }

    public String toString(){
        String s = getKlant() + " : " + getBehandelDatum();
        return s;
    }
}
