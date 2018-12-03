package eksamenhøst2012;

public class Romregister
{
    private Rom[] rommene;

    public Romregister( Rom[] r )
    {
        rommene = r;
    }

    public String beboerLogg( long pnr )
    {
        /*< Metoden skal returnere loggboken til beboeren med personnummer
        lik den innkomne parameteren "pnr", under forutsetning av
        at vedkommende bor på institusjonen. Hvis det ikke er tilfelle
        skal metoden returnere teksten "Ukjent personnummer". >*/
        for (Rom etRom : rommene){
            if (etRom.getBeboer()!= null) {
                if (etRom.getBeboer().getpNr() == pnr) {
                    return etRom.getBeboer().toString();
                }
            }
        }
        return "Ukjent personnummer";
    }

    public Rom finnRom( long pnr )
    {
        /*< Metoden skal returnere en referanse til rommet som beboeren med
        personnummer lik den innkomne parameteren "pnr" bor på.
        Hvis et slikt rom ikke finnes skal metoden returnere null. >*/
        for (Rom etRom : rommene){
            if (!etRom.ledig()){
                if (etRom.getBeboer().getpNr() == pnr){
                    return etRom;
                }
            }
        }
        return null;
    }

    public Beboer finnBeboer( long pnr )
    {
        /*< Metoden returnerer en referanse til beboeren med  personnummer
        lik den innkomne parameteren "pnr". Hvis en slik beboer ikke
        finnes returnerer metoden null.
            NB! Denne metoden skal IKKE programmeres. >*/
        throw new IllegalStateException("Ikke laget enda");
    }

    public String nyBeboer( String navn, long pnr )
    {
        /*< Metoden skal innlosjere en ny beboer, med navn og personnr som
        parametrene "navn" og "pnr",  angir. Forutsetningen er imidlertid
        at det finnes et ledig rom og at vedkommende ikke allerede bor på
        institusjonen. Hvis innflyttingen gikk bra, skal metoden returnere
        en tekst med beboerens navn og opplysninger om hvilket rom
        vedkommende har flyttet inn på. Hvis vedkommende allerede bor på
        institusjonen skal teksten som returneres fortelle hvilket rom
        vedkommende allerede bor på. Hvis ingen rom er ledige skal det
        returneres informasjon om det. >*/
        throw new IllegalStateException("Ikke laget enda");
    }

    public String utflytting( long nr )
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalStateException("Ikke laget enda");
    }

    public String ut( long pnr, String s)
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalStateException("Ikke laget enda");
    }

    public String inn( long pnr, String s )
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalStateException("Ikke laget enda");
    }

    public String besøkInn( long pnr, String melding, String gjest )
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalStateException("Ikke laget enda");
    }

    public String besøkAvsluttet( long pnr, String melding )
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalStateException("Ikke laget enda");
    }

    public String visArkiv()
    {
        //< Metoden skal IKKE programmeres. >
        throw new IllegalStateException("Ikke laget enda");
    }
} // end of class Romregister
