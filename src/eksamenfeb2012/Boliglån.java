package eksamenfeb2012;

public abstract class Boliglån
{
    private static long nestenr = 11001500000L;
    private static double basisrente = 0.029; // dvs. 2.9 %
    private static double rentetillegg = 0.005; // dvs. 0.5 %
    private static final double SEKSTIPROSENT = 0.6;
    // NB! Datafeltene over skal ikke initialiseres av konstruktøren.

    private long lånenr;
    private String navn;
    private double lånebeløp;
    private double restlån;
    private int verditakst;
    private int nedbetalingstid;  // i antall hele år
    private double rente;  // eks. 0.04 tilsvarer 4%
    public static int uniktLånenummer = 0;

    /*
    < Konstruktør med parametre som gir startverdier for dataene som
    skal registreres for hvert lån, med unntak av lånenummer og rente.
    Lånet skal tildeles et unikt lånenummer som skal genereres automatisk.
    Lånenumrene skal ha verdier fra og med 11001500001 og oppover.
    Lånets rente skal bestemmes på grunnlag av lånebeløp og verditakst,
    se metoden under. >*/
    Boliglån(String navn,double lånebeløp,  int verditakst, int nedbetalingstid){
        this.navn = navn;
        this.lånebeløp = lånebeløp;
        this.restlån = lånebeløp;
        this.verditakst = verditakst;
        this.nedbetalingstid = nedbetalingstid;

        this.lånenr = 1100150000 + uniktLånenummer++;

        this.rente = bestemRente(lånebeløp, verditakst);
    }

    public static double bestemRente(double beløp, double takst){
        double sikkerhet;
        if ( takst > 0 )
            sikkerhet = beløp / takst;
        else
            return basisrente + rentetillegg;
        if ( sikkerhet <= SEKSTIPROSENT )
            return basisrente;
        else
            return basisrente + rentetillegg;
    }


    //< get-metoder for datafeltene lånenr, navn, lånebeløp, restlån,
    //verditakst, nedbetalingstid og rente. >


    public long getLånenr() {
        return lånenr;
    }

    public String getNavn() {
        return navn;
    }

    public double getLånebeløp() {
        return lånebeløp;
    }

    public double getRestlån() {
        return restlån;
    }

    public boolean nedbetal(double beløp){
        /*< Metoden skal redusere restlånet med  beløpet som parameteren angir,
            under forutsetning av at det er mindre eller lik restlånet.
            Hvis så er tilfelle skal  metoden returnere true, i motsatt fall
        skal den returnere false. >*/
        if (restlån>=beløp){
            restlån -= beløp;
            return true;
        }
        return false;
    }

    abstract public String kontoutskrift();
} // end of class Boliglån
