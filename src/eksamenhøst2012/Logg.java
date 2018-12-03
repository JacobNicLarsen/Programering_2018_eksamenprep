package eksamenhøst2012;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Logg
{
    private String[] rapporter;
    private int antall;   // antall rapporter som til enhver tid er lagret i arrayen
    public static final int ARRAYLENGDE = 100;
    public static final int UTVIDELSE = 10;

    public Logg(){
        rapporter = new String[ARRAYLENGDE];
    }

    public String toString()
    {

        /*
        < Metoden skal returnere en tekst som inneholder alle rapportene
        i arrayen, slik at den nyeste rapporten står først og den
        eldste sist, dvs i omvendt kronologisk  rekkefølge.
        Det skal være et linjeskift mellom hver rapport. >*/
        String ut ="";
        for (int i = rapporter.length - 1; i > 0; i--) {
            if (rapporter[i] != null){
                ut += rapporter[i];
                ut += "\n";
            }
        }
        return ut;
    }

    public void utvidArray()
    {

        /*
        < Metoden skal utvide arrayen "rapporter" med så mange elementer
        som konstanten UTVIDELSE angir. >*/

        String[] utArray = new String[rapporter.length + UTVIDELSE];
        for (int i = 0; i < rapporter.length; i++) {
            utArray[i] = rapporter[i];
        }

        rapporter = utArray;
    }

    public void nyRapport( String melding )
    {

        Calendar dato = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance();
        String rapport = "\nDato: " + df.format(dato.getTime());

        /*< Metoden skal opprette en rapport, med teksten som den innkomne
        parameteren "melding" inneholder. Rapporten skal starte med dagens dato,
        og lagres i arrayen "rapporter". Hvis arrayen er full, skal den utvides
        med så mange elementer som konstanten UTVIDELSE angir, før rapporten den nye
        settes inn. >*/

        int i = antall + 1;
        if (i >= rapporter.length - 1){
            utvidArray();
        }

        rapporter[i] = rapport + " melding inneholder: " +  melding + "\n";
        antall++;
    }
} // end of class Logg