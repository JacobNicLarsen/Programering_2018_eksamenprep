package eksamenfeb2012;

public class Låneregister
{
    public static final int KAPASITET = 4;
    public static final int SERIE = 1;
    public static final int ANNUITET = 2;

    private Boliglån[] kontoer = new Boliglån[ KAPASITET ];

    public int getIndeks( long lånenr )
    {
        /*< Metoden skal returnere arrayindeksen til boliglånsobjektet
        med samme lånenummeret som parameteren angir. Hvis et slikt
        ikke finnes i arrayen, skal metoden returnere -1. >*/
        for (int i = 0; i < kontoer.length; i++) {
            if (kontoer[i] != null && kontoer[i].getLånenr() == lånenr){
                return i;
            }
        }
        return -1;
    }

    public Boliglån finnKonto( long nr)
    {
        /*< Metoden returnerer (en referanse til) boliglånsobjektet med samme
        lånenummeret som parameteren angir. Hvis et slikt ikke finnes, returnerer
        metoden null. NB! Skal IKKE programmeres, men du får bruk for den senere. >*/
        throw new IllegalStateException("Ikke laget enda");
    }


    public double getRestlån( long lånenr )
    {
        /*< Metoden returnerer restlånet til boliglånet med samme lånenummeret
        som parameteren angir. Hvis et slikt ikke finnes i registeret, skal
        metoden returnere 0.0 >*/
        throw new IllegalStateException("Ikke laget enda");
    }

    public Boliglån nyttLån( String navn, double beløp, int år, int takst, int type )
    {
        /*< Metoden tar imot låntakerens navn, lånebeløpet, antall år, verditakst
        og lånetype som parameter. Hvis lånetypen er lik SERIE skal et objekt
        av typen Serielån opprettes, og hvis lånetypen er ANNUITET skal et objekt
        av  typen Annuitetslån opprettes. Det  nye låneobjektet skal så settes
        inn i arrayen på første ledige plass. Metoden skal til slutt returnere
            (en referanse til) det nye objektet. Hvis arrayen er full, eller parameteren
        type er forskjellig fra både SERIE og ANNUITET, skal metoden returnere null. >*/
        int i = 0;
        while (kontoer[i] != null){
            i++;
            if (i >= kontoer.length) return null;
        }

        if (type == SERIE){
            return null;
        }
        else if (type == ANNUITET){
            return kontoer[i] = new Annuitetslån(navn, beløp,takst, år);

        }
        else return null;
    }

    public String[] oversiktAlleLån()
    {
        /*< Metoden skal returnere en array av tekststrenger med opplysninger
        om alle boliglån i registeret. Hvert element i arrayen skal inneholde
        informasjon om hvert enkelt boliglån (dvs. låntakerens navn, lånenr,
            type lån, restlån samt utgifter for lånet neste år.). >*/
        throw new IllegalStateException("Ikke laget enda");
    }

    public boolean nedbetal( long lånenr, double beløp )
    {
        /*< Metoden skal nedbetale boliglånet, med samme lånenummer som parameteren
        lånenr, med det beløp som parameteren beløp angir, under forutsetning av
        at dette lånet finnes i registeret. Returverdien skal angi om dette lot
        seg gjøre  eller ikke. Hvis hele lånet er innfridd, skal boliglåneobjektet
        i tillegg slettes. >*/
        throw new IllegalStateException("Ikke laget enda");
    }
} // end of class Låneregister
