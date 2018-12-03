package eksamenhøst2012;

public class Beboer
{
    private String navn;
    private long pNr;  // personnummer
    private Rom rom;  // Klassen Rom  er beskrevet i oppgave 3
    private Logg loggbok;
    private String gjest;

    public Beboer(String n, long nr, Rom r )
    {
        /*< Konstruktøren oppretter loggboken og initialiserer datafeltene.
        Konstruktøren skal IKKE programmeres. >*/

        this.navn = n;
        this.pNr = nr;
        this.rom = r;

        loggbok = new Logg();
    }

    //< get-metoder for navn, pNr og rom >
    public String getNavn(){
        return navn;
    }

    public long getpNr(){
        return pNr;
    }

    public Rom getRom(){
        return rom;
    }

    //< set-metode for gjest >
    public void setGjest(String gjest){
        this.gjest = gjest;
    }

    public void slettGjest()
    {
        gjest = null;
    }

    public void nyRapport( String rapport )
    {
        /*< Metoden skal sette rapporten, som den mottar som parameter,
        inn i loggboken. Hvis beboeren har en gjest på besøk, skal
        gjestens navn også tas med i rapporten. >*/

        if (gjest != null) rapport += "gjest: " + gjest;

        loggbok.nyRapport(rapport);
    }

    public String toString()
    {
        /*< Metoden skal returnere beboerens navn og personnummer i form
        av en tekst. >*/
        return "Beboerens navn: " + navn + "\n" + "Personnummer: " + pNr;
    }

    public String loggbok()
    {
        /*< Metoden skal returnere en tekst som starter med beboerens navn,
        personnummer og romnummer, etterfulgt av alle rapportene i loggboken. >*/
        return toString()  + loggbok.toString();
    }
} // end of class Beboer
