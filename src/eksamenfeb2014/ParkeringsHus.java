package eksamenfeb2014;

import java.util.Calendar;

public class ParkeringsHus {
    private Parkering [] plasser = new Parkering[MAX + 1];
    public static final int MAX = 200;
    private double inntjening;

    public Parkering parker(String bilnr, int type) {
        /*
        Et kall på denne metoden registrerer en parkering. Parameteren
        bilnr inneholder registreringsnummeret til en bil, mens
        parameteren type angir hvilken type parkering det gjelder.
        (Hint! Se konstantene i klassen Parkering.) Hvis det er ledig
        plass skal metoden foreta parkering av den type som ønskes og
        returnere en referanse (peker) til objektet som inneholder data
        om parkeringen. Hvis ikke det er ledig plass skal metoden
        returnere null. >*/

        int ledigplass = 1;
        while (plasser[ledigplass] != null){
            ledigplass ++;
        }

        if (ledigplass > MAX - 1) return null;

        if (type == Parkering.KORTTID){
            plasser[ledigplass] = new KorttidsParkering(bilnr, Calendar.getInstance(), ledigplass);
        }
        else if (type == Parkering.LANGTID){
            plasser[ledigplass] = new LangtidsParkering(bilnr, Calendar.getInstance(), ledigplass);
        }
        else{
            throw new IllegalArgumentException("Må velge enten langtid- eller korttid- parkering");
        }

        return plasser[ledigplass];
    }

    public Parkering[] getPlasser(){
        return plasser;
    }

    public int plassnr( String bilnr )
    {
        /*
        < Metoden skal returnere nummeret til parkeringsplassen som bil med
        registreringsnummer lik parameteren bilnr er parkert på. Metoden
        skal returnere 0 i tilfelle bilen ikke finnes i parkeringshuset. >*/
        for (Parkering bil : plasser){
            if (bil != null){
                if (bil.getBilnr().equals(bilnr)) return bil.getPlass();
            }
        }
        return 0;
    }

    public String bilInfo( String bilnr ) {
        /*
        < Ut fra bilens bilnr, som parameteren angir, skal metoden returnere
        info om bilens nummer, hvilken plass den står på og når den ble
        parkert, under forutsetning av at den  finnes i parkeringshuset.
        I motsatt fall skal metoden returnere null. >*/

        int plass = plassnr(bilnr);

        if (plass == 0) return "Fant ikke bilen i parkeringshuset";
        return plasser[plass].toString();
    }

    public double avgift(String bilnr, Calendar d)
    {
        /*
        < Returverdien til metoden over skal fortelle hvor mye bilen med
        gitt registreringsnummer må betale i avgift fram til tidspunktet
        gitt ved parameteren d. Returverdi 0.0 skal indikere at bilen
        ikke finnes i parkeringshuset. >*/

        int plass = plassnr(bilnr);
        if (plass == 0) return 0.0;
        return plasser[plass].avgift(d);
    }

    public String hentBil(String bilnr, Calendar d )
    {
        /*
        < Parameteren bilnr inneholder registreringsnummeret til en bil
        og parameteren d er tidspunktet for når denne blir hentet fra
        parkeringshuset. Metoden skal sørge for at plassen som bilen
        stod på nå blir ledig. Den skal også registrere at beløpet i
        parkeringsautomaten blir økt med den avgiften som blir betalt
        for denne parkeringen. Den returnerte teksten skal inneholde
        kvittering for parkeringen, dvs. type parkering, bilens nummer,
            plass, tidspunkter for inn- og utkjøring, samt parkeringsavgift.
            Dersom bilen ikke finnes i parkeringshuset, skal metoden isteden
        returnere melding om dette. >*/
        int plass = plassnr(bilnr);
        if (plass == 0) return "Fant ikke bilen i parkeringshuset";

        String utTekst = plasser[plass].kvittering(d);
        inntjening += plasser[plass].avgift(d);
        plasser[plass] = null;

        return utTekst;
    }

    public Parkering[] bortTauing( Calendar d )
    {
        /*
        < Metoden skal returnere en array av Parkering-objekter
        tilsvarende de bilene som har overskredet maksimal
        parkeringstid på det tidspunkt parameteren d angir.
        NB! Denne metoden skal ikke slette objektene fra systemet.  >*/

        Parkering[] borttauedeBiler = new Parkering[MAX];


        int indeks = 0;
        for (Parkering enBil : plasser){
            if (enBil != null){
                if ((d.getTime().getTime() - enBil.getStarttid().getTime().getTime() > enBil.getMakstid())){
                    borttauedeBiler[indeks++] = enBil;}
            }
        }

        return borttauedeBiler;
    }

    public void fjernBilene(Parkering[] fjernes)
    {
        /*
        < Metoden skal sørge for at bilene som rent fysisk er tauet bort også
        blir fjernet fra datasystemet. Arrayen som metoden mottar som parameter
        inneholder informasjon om disse og metoden skal frigjøre (stille ledig)
        de tilhørende parkeringsplassene. >*/

        for (Parkering enBil : fjernes){
            plasser[enBil.getPlass()] = null;
        }
    }

    public double inntjeningsInfo() {
        /*
        < Metoden skal returnere inntjeningen, dvs. parkeringsinntektene. >*/
        return inntjening;
    }

    public int beholdning(){
        int antall = 0;
        for (Parkering parkering : plasser){
            if (parkering != null) antall++;
        }
        return antall;
    }

} // end of class ParkeringsHus