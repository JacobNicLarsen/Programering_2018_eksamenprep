package eksamenfeb2014;

import java.text.DateFormat;
import java.util.Calendar;

public abstract class Parkering {
    private String bilnr; //bilens registreringsnummer
    private Calendar starttid; //starttidspunkt for parkeringen (Hint: Bruk Calendar-klassen)
    private int plass; //nummeret for parkeringsplassen til bilen
    public static final int KORTTID = 1, LANGTID = 2;

    Parkering(String bilnr, Calendar starttid, int plass){
        this.bilnr = bilnr;
        this.starttid = starttid;
        this.plass = plass;
    }

    public abstract String kvittering( Calendar d );
    public abstract double getPris();
    public abstract double avgift( Calendar d );
    public abstract int getMakstid();

    public String getBilnr(){ return bilnr;}
    public Calendar getStarttid(){return  starttid;}
    public int getPlass(){return plass;}

    @Override
    public String toString(){
        DateFormat df = DateFormat.getInstance();
        String startTime = df.format( starttid.getTime() );

        return "Bilnummer: " + bilnr + "\n"
                + "Starttid: " + startTime + "\n"
                + "Plass: " + plass + "\n";
    }
}
