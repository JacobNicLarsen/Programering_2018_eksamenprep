package eksamenfeb2012;

import java.util.ArrayList;

public class Annuitetslån extends Boliglån
{
    private double kostnadPrÅr;

    /*
    < Konstruktør med parametre som mottar startverdier for dataene som skal
    registreres for lånet, med unntakt av lånenummer og renter.
    Det må også beregnes hva lånet vil koste pr år. >*/

    Annuitetslån(String navn,double lånebeløp, int verditakst, int nedbetalingstid){
        super(navn, lånebeløp, verditakst, nedbetalingstid);
        kostnadPrÅr = beregnKostnadPrÅr(lånebeløp, nedbetalingstid, verditakst);
    }

    public static double beregnKostnadPrÅr( double lånebeløp, int år, int takst )
    {
        double rentefot = bestemRente( lånebeløp, takst );
        double q = 1 + rentefot;
        double qn = Math.pow( q, år );
        return lånebeløp * qn * ( q - 1 ) / ( qn - 1 );
    }

    public static double totalkostnad( double lånebeløp, int år, int  takst )
    {
        //< Metoden skal returnere summen av renter og avdrag som skal betales gjennom
        //hele nedbetalingsperioden.(Tips: Bruk metoden over.) >
        return beregnKostnadPrÅr(lånebeløp,år, takst ) * år;
    }

    @Override
    public boolean nedbetal( double beløp )
    {
        /*
        < Metoden skal redefineres slik at den i tillegg til å nedbetale lånet med
        beløpet som parameteren angir, også tildeler datafeltet kostnadPrÅr ny verdi,
            ved at annuitetslånets kostnad pr år beregnes på nytt. (Se metoden over).
        Den nye beregningen skal baseres på den restlånet som nå gjennstår.
            Returverdien angir om nedbetalingen har funnet sted eller ikke. >*/
        if (getRestlån()>=beløp){
            return true;
        }
        return false;
    }

    public String kontoutskrift()
    {
        //< Metoden skal returnere en tekst som inneholder låntakerens navn, lånenr,
        //    type lån, restlån samt utgifter for lånet neste år. >
        return "Navn: " + this.getNavn() + "\n" +
                "Lånenummer " + this.getLånenr() + "\n" +
                "Type lån: " + "Annutetslån" + "\n" +
                "Restlån" + this.getRestlån() + "\n" +
                "Utgifter for neste år: " + kostnadPrÅr;
    }

    public static String[] betalingsplan( double lånebeløp, int år, int takst )
    {
        //< Metoden genererer og returnerer en nedbetalingsplan annuitetslån. Hvert
        //String-element i arrayen som returneres fra metoden tilsvarer en linje
        // i betalingsplanen som er vist på bildet i oppgave 4.
        // NB! Skal ikke programmeres! >
        throw new IllegalArgumentException("Ikke programert");

    }
} // end of class Annuitetslån
