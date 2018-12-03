package eksamenhøst2013;

public class Pasientregister
{
    private Pasient[] pasienter;

    public Pasientregister( Pasient[] p )
    {
        pasienter =  p;
    }

    public boolean nyPasient( Pasient p )
    {
        //< Metoden setter, hvis mulig, inn Pasient-objektet p på første ledige
        //plass i arrayen. Returverdien indikerer om dette var mulig eller ikke.
        //NB! Denne metoden skal du ikke programmere! >
        for (int i = 0; i < pasienter.length; i++) {
            if (pasienter[i] == null){
                pasienter[i] = p;
                return true;
            }
        }
        return false;
    }
    public Pasient finnPasient( String dato,  String navn )
    {
        //< Metoden returnerer, hvis mulig, Pasient-objektet med
        //fødselsdato og  navn lik parametrene dato og navn.
        //Hvis et slikt objekt ikke finnes returnerer metoden null.
        //    NB! Denne metoden skal du ikke programmere! >
        throw new IllegalStateException("Ikke laget enda");
    }

    public Pasient[] finnPasient( String dato )
    {
        //< Metoden skal returnere array som inneholder alle pasientene
        //som har fødselsdato lik parameteren dato. Arrayens lengde skal
        //være nøyaktig lik det antall Pasient-objekter som har en slik
        //fødselsdato. Dvs. I arrayen som returneres skal ingen
        //array-elementer være lik null.) Hvis det ikke finnes noen
        //pasienter med denne fødselsdatoen, skal metoden returnere null. >

        int teller = 0;
        for (int i = 0; i < pasienter.length; i++) {
            if (pasienter[i] != null && pasienter[i].getFødselsdato().equals(dato)){
                teller++;
            }
        }

        Pasient[] utArray = new Pasient[teller];

        int utArrayindeks = 0;
        for (int i = 0; i < pasienter.length; i++) {
            if (pasienter[i] != null){
                if (pasienter[i].getFødselsdato().equals(dato)){
                    utArray[utArrayindeks++] = pasienter[i];
                }
            }
        }

        return utArray;
    }
} // end of class Pasientregister
