package eksamenfeb2013;

public class Lotteri
{
    private int loddpris;
    private double rødekors;   //0.1 tilsvarer 10% til Røde Kors
    private  int antallSolgte = 0; //Antall solgte lodd
    private  int sumLoddsalg;  //Summen det er solgt lodd for i hele kroner
    private Lodd[] loddbok;
    private Gevinst[] gevinster;
    private boolean trekningForetatt = false;

    /*
    < Konstruktør som mottar parametre for rødekorsandelen og loddprisen,
    samt to parametre lengdene for arrayene. >*/
    public Lotteri(double rødekors, int loddpris, int antallLodd, int antallGevinster){
        this.rødekors = rødekors;
        this.loddpris = loddpris;
        loddbok = new Lodd[antallLodd];
        gevinster = new Gevinst[antallGevinster];
    }

    //< get-metoder for antallSolgte og loddpris >
    public int getAntallSolgte(){
        return antallSolgte;
    }

    public int getLoddpris(){
        return loddpris;
    }

    public String loddsalg(String navn, String adr, String mobil, int antall){
        /*
        < Metoden skal registrere salg av det antall lodd som loddkjøperen
        ønsker å kjøpe, under forutsetning av at det er nok usolgte lodd
        igjen (dvs. nok ledig plass i arrayen). Paramtrene gir opplysninger
        om loddkjøperens navn, adresse og mobilnummer, samt hvor mange lodd
        vedkommende skal ha. Datafeltene antallSolgte og sumLoddsalg skal
        oppdateres, slik at det til enhver tid holdes rede på hvor mange
        lodd som er solgt og hvor mye det er solgt lodd for. Metoden skal
        returnene en tekst med informasjon om loddene som kjøpes, samt
        opplysninger om hvor mye loddkjøperen skal betale. Hvis salget ikke
        lar seg gjennomføre (fordi det ikke er nok lodd igjen)  skal metoden
        returnere informasjon om det. >*/
        int i = 0;
        for (; i < antall; i++) {
            if (antallSolgte >= loddbok.length){
                return "Fikk solgt: " + i + " lodd" + " men " + "Kan ikke selge flere lodd " + " kunde må betale: " + (i * loddpris);
            }
            loddbok[antallSolgte] = new Lodd(navn,adr,mobil);
            antallSolgte++;
            sumLoddsalg += loddpris;
        }

        return "Kunde må betale: " + (i*loddpris);
    }

    public int rødekorsAndel(){
        /*
        < Metoden returnerer den andelen av loddsalget skal skal gå til Røde Kors.
            Beløpet skal returneres i hele kroner. >*/
        return (int)(sumLoddsalg*(rødekors));
    }

    public void beregnGevinster(){
        /*
        < Metoden skal opprette gevinster (antallet gevinster er lik lengden på
        gevinst-arrayen) og beregne størrelsen på dem etter følgende regler:
        Etter at Røde Kors-andelen er trukket fra inntektene av loddsalget, skal
        50% gå til 1.gevinsten, mens resten av beløpet skal fordeles de
        resterende gevinstene. (Hver gevinst skal representeres som et Gevinst-
            objekt i arrayen gevinster.) >*/
        int gevinst = (int)(sumLoddsalg - (sumLoddsalg *rødekors));
        Gevinst førstePlass = new Gevinst(gevinst/2, 0);
        gevinst -= førstePlass.getGevinst();
        gevinster[0] = førstePlass;
        for (int i = 1; i < gevinster.length; i++) {
            gevinster[i] = new Gevinst((gevinst / gevinster.length), i);
        }
    }

    public String gevinstprognoser(){
        /*
        < Metoden skal returnere informasjon om hvor mye det er solgt lodd for og
        hvor stor andel som skal gå til Røde Kors, samt gi en oversikt over hva
        de forskjellige gevinstene lyder på. Det er en forutsetning at det er
        solgt flere lodd enn det er gevinster. Hvis ikke, skal metoden returnere
        informasjon om at det er solgt for få lodd til at gevinstprognoser kan
        beregnes. >*/

        String utGevinster = "";
        for (Gevinst enGevinst : gevinster){
            utGevinster += enGevinst.getGevinst() + " ";
        }

        if (antallSolgte > gevinster.length){
            return "Det er solgt lodd for: " + sumLoddsalg + "\n" +
                    "Antallet som går til røde kors: " + sumLoddsalg *(rødekors) + "\n" +
                    "Gevinter: " + utGevinster;
        }
        return "Det er solgt for få lodd";
    }

    public void trekning(){
        /*
        < Metoden skal beregne gevinster og foreta en trekning.
        Følgende instruksjon returnerer indeksen til et av loddene i loddboka:*/
        beregnGevinster();

        for (int i = 0; i < gevinster.length; i++) {
            int indeks = (int) ( Math.random() * antallSolgte );
            //System.out.println(indeks);

            loddbok[indeks].setVinnerlodd();
            gevinster[i].setVinnerlodd(loddbok[indeks]);
        }
        trekningForetatt = true;
    }

    public String vinnerliste(){
        /*
        < Denne metoden skal foreta trekningen ved at metoden over blir kalt,
            under forutsetning av at det er solgt flere lodd enn det er gevinster
        og at trekningen ikke allerede er foretatt. Metoden skal så returnere
        en liste over hvilke lodd som har vunnet hvilke gevinster, og hvem de
        heldige vinnerne er. Hvis det ikke er solgt nok lodd, skal metoden
        returnere informasjon om at det er solgt for få lodd til å foreta
        trekningen. >*/
        if ((antallSolgte < gevinster.length) && (trekningForetatt)){
            return "Ikke solgt nok lodd, eller det er allerde gjort en trekning";
        }
        trekning();
        String utTeks = "";
        for (Gevinst enGevins : gevinster){
            if (enGevins.getVinnerlodd() != null){
                utTeks += enGevins.getVinnerlodd().toString() + "\n" + "Vinner: " + enGevins.getGevinst()+ "\n" + "\n";
            }
        }
        return utTeks;
    }
}// end of class Lotteri
