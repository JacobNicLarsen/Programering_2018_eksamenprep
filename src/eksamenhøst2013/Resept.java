package eksamenhøst2013;

import java.util.Calendar;

public class Resept
{
    private boolean utlevert = false;
    private String tekst;
    private Calendar dato;
    //private Pasient pasient;
    //private Lege lege;
    private int nr;
    private static int nesteNr = 0;

    /*
    < Konstruktøren mottar reseptens tekst, legen og pasienten som parametre.
    Resepten blir tildelt et unikt nummer, datoen for opprettelsen
    av resepten blir registert, i tillegg til at annen nødvendig initialisering
    blir foretatt. >
    */
    Resept(String tekst, int nr){
        this.tekst = tekst;
    }

    public int getNr(){
        return nr;
    }


    /*
  < get-metoder for datafeltene nr og utlevert >

    public void registrerUtlevert()
    {
    < Metoden registrerer at den medisinen resepten foreskriver er utlevert. >
    }
*/
    public String toString()
    {
        return tekst;
    }

}  // end of class Resept
