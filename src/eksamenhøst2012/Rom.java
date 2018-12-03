package eksamenhøst2012;

import javax.swing.*;

public class Rom
{
    private int romNr;
    private int status = LEDIG;
    private Beboer beboer; // hvis beboer == null er rommet ledig
    private JTextArea display;
    private String arkiv = "";
    public static final int LEDIG = 0, INNE = 1, UTE = 2, BESØK = 3;

    public Rom(int nr)
    {

        /*< initialisering - skal IKKE programmeres. >
        oppdaterRomStatus("", LEDIG);*/
    }

    //< get-metoder for romNr, arkiv og beboer - skal IKKE programmeres. >


    public int getRomNr() {
        return romNr;
    }

    public Beboer getBeboer() {
        return beboer;
    }

    public String getArkiv() {
        return arkiv;
    }

    public String status()
    {
        /*< Metoden skal returnere er tekst som tilsvarer rommets status,
            dvs. "LEDIG", "INNE", "UTE" eller "BESØK". >*/
        switch (status){
            case LEDIG: return "LEDIG";
            case INNE: return "INNE";
            case UTE: return "UTE";
            case BESØK: return "BESØK";
            default: return "Burde ikke intreffe";
        }
    }

    public boolean ledig()
    {
        /*< Hvis rommet er ledig skal metoden returnere true,
            og i motsatt fall skal den returnere false. >*/

        if (status == LEDIG) return true;
        return false;
    }

    public void oppdaterRomStatus(String melding, int st)
    {
        /*< Metoden skal oppdatere rommets status med den nye verdien som
        parameteren "st" angir. Hvis rommet er bebodd, skal det i
        beboerens loggbok opprettes en rapport som inneholder informasjon
        om den nye statusen etterfulgt av meldingen som parameteren
        "melding" inneholder. På displayet skal beboerens navn og personnummer,
            samt rommets nye status, skrives. Hvis rommet er ledig skal
        det kun stå teksten "LEDIG" på  displayet.
        (Se bilde av brukergrensesnittet på side 8.) >*/
        if (beboer != null){
            beboer.nyRapport("Ny romstatus: " + status + melding);
        }
        status = st;
    }

    public boolean  flyttInn( Beboer ny)
    {
        /*< Hvis rommet er ledig skal det registreres at en ny beboer
        flytter inn, og romstatusen skal så oppdateres.(Se metoden over.)
        Hvis innflyttingen lot seg gjøre, skal metoden returnere true.
            I motsatt fall skal den returnere false. Du kan anta ny != null. >*/
        if (status == LEDIG){
            beboer = ny;
            return true;
        }
        return false;
    }

    public void flyttUt()
    {
        /*< Metoden skal lagre beboerens logg i arkivet, deretter
        ledigstille rommet og endre dets status til LEDIG.
        Den nye statusen skal skrives på displayet. >*/
        if (!ledig()){
            arkiv +=beboer.loggbok();
            status = LEDIG;
            beboer = null;
        }
    }

    public String gårUt(String s)
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalArgumentException("IKKe laget enda");
    }

    public String gårInn( String s)
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalArgumentException("IKKe laget enda");
    }

    public String fårBesøk( String melding, String g )
    {
        /*< Hvis beboeren er inne, skal metoden registrere at vedkommende
        har besøk og hvem vedkommende har besøk av. Parameteren "g" angir
        gjestens navn. Besøket skal loggføres med meldingen som parameteren
        "melding" inneholder og rommets status og display skal oppdateres.
        Beboeren kan imidlertid ikke ta imot besøk hvis vedkommende er
        ute eller allerede har besøk. Metoden skal enten returnere en tekst
        med informasjon om at besøket er registrert, eller en tekst som
        forklarer hvorfor besøket ikke lar seg gjennomføre. >*/
        throw new IllegalArgumentException("IKKe laget enda");
    }

    public String besøkSlutt( String melding )
    {
        /*< Metoden skal registrere at besøket er avsluttet, og rommets status
        og display skal oppdateres. Forutsetningen er imidlertid at
        vedkommende virkelig har besøk. Metoden skal enten returnere en tekst
        med informasjon om at besøket er avsluttet, eller en tekst som
        forklarer at beboeren ikke har hatt besøk. >*/
        throw new IllegalArgumentException("IKKe laget enda");
    }
} // end of class Rom
