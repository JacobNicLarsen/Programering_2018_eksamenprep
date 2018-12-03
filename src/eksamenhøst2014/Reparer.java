package eksamenhøst2014;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reparer{

    private String oppdragsdato;
    private String repareres;
    public boolean eu_krav;
    public int oppdragsnummer;
    private boolean ferdig;

    Reparer(String repareres, boolean eu_krav){

        Calendar oppdragsdato = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat( "dd.MM.yy");
        String s = df.format(oppdragsdato.getTime());

        this.oppdragsdato = s;
        this.repareres = repareres;
        this.ferdig = false;
        this.eu_krav = false;
    }

    @Override
    public String toString(){
        return "Oppdragsnummer " + oppdragsnummer + " Oppgavebeskrivelse " + repareres + " Dato: " + oppdragsdato;
    }

    public int getOppdragsnummer() {
        return oppdragsnummer;
    }

    public boolean getFerdig(){
        return ferdig;
    }

    public void setFerdig(){
        ferdig = true;
    }

    public void setEu_krav(){
        this.eu_krav = true;
    }

    public boolean getEu_krav(){
        return eu_krav;
    }
}