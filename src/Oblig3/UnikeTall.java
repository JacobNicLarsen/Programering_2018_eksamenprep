package Oblig3;

import javax.swing.*;

public class UnikeTall{
   /* Deklarasjon av array for lagring av tilfeldige heltall
     og andre nødvendige variabler og/eller konstanter.  */
   private int[] tilfeldigtallArray;

   public int[] getTilfeldigtallArray(){
       return tilfeldigtallArray;
   }

   /* Konstruktør som mottar arrayens lengde som parameter og
     oppretter arrayen.  */
   public UnikeTall(int antallTall){
       tilfeldigtallArray = new int[antallTall];
   }

   /* Metode som skal undersøke om et gitt tall finnes i arrayen fra før.
     Tallet det letes etter skal mottas som parameter.
     Metoden skal returnere true hvis tallet finnes i arrayen.
     Hvis ikke skal metoden returnere false. */

   public boolean finnesIArrayen(int tall){
       for (int etTall : tilfeldigtallArray){
           if (etTall == tall){
               return true;
           }
       }
       return false;
   }

   /* Metode som skal fylle arrayen med tilfeldige tall mellom 100 og 999,
     begge grenser inkludert. Metoden skal gjøre dette på en måte
     som sikrer at alle tallene er forskjellige. Metoden skal ikke ha
     parametre og heller ikke returnere noen verdi.  */

   public void fyllArray(){
       for (int i = 0; i < tilfeldigtallArray.length; i++) {
           int nyttTall = (int)(Math.random() * 900) + 100;
           while (finnesIArrayen(nyttTall)){
               nyttTall = (int)(Math.random() * 10) + 100;
           }
           tilfeldigtallArray[i] = nyttTall;
       }
   }


    // Metode som finner og returnerer det minste tallet i arrayen.
    public int minsteTall(){
       int minsteTall = tilfeldigtallArray[0];

       for (int i = 0; i < tilfeldigtallArray.length - 1; i++){
           if (tilfeldigtallArray[i] < minsteTall){
               minsteTall = tilfeldigtallArray[i];
           }
       }

       return minsteTall;
    }

    // Metode som finner og returnerer det største tallet i arrayen.
    public int largestNumber(){
       int largestNumer = tilfeldigtallArray[0];

       for (int i = 0; i < tilfeldigtallArray.length - 1; i++){
           if (tilfeldigtallArray[i] > largestNumer){
               largestNumer = tilfeldigtallArray[i];
           }
       }

       return largestNumer;
    }

   /*  Metode som beregner og returnerer den gjennomstnittlige verdien
     (double-verdi) av tallene i arrayen.  */
   public double avarage(){
       double avarage = 0;

       for (int i = 0; i < tilfeldigtallArray.length - 1; i++) {
           avarage += tilfeldigtallArray[i];
       }

       return avarage/tilfeldigtallArray.length;
   }

   /* Metode som returnerer den heltallsverdien som ligger nærmest
     gjennomsnittverdien. Hint! Her kan du bruke Math.abs(...) som
     returnerer absoluttverdien til uttrykket mellom parentesene. */

   public int mathAbs(){
       int differanse = (int)Math.abs(tilfeldigtallArray[0] - avarage());
       int tall = tilfeldigtallArray[0];

       for (int i = 1; i < tilfeldigtallArray.length; i++) {
           int nyDifferanse = (int)Math.abs(tilfeldigtallArray[i] - avarage());
           if (nyDifferanse<differanse){
               differanse = nyDifferanse;
               tall = tilfeldigtallArray[i];
           }
       }
       return tall;
   }

   /* Metode som viser tallene i arrayen i en meldngsboks.
     I tillegg skal det, i meldingsboks, skrives ut
     opplysninger om hvilket tall som er minst, hvilket som er størst,
     hva som er gjennomsnittsverdien, og hvilken heltallsverdi som
     er nærmest gjennomnittet, jfr bildet over. Gjennomsnittverdien
     skal skrives ut med en desimal. Bruk gjerne String.format til dette.
     Legg inn mellomrom mellom tallene og skriv ut et passende antall tall
     per linje. */
   public void visInfo(){
       String ut = "";
       for (int i = 0; i < tilfeldigtallArray.length; i++) {
           if (i % 8 == 0) ut += "\n";
           ut += tilfeldigtallArray[i] + ", ";
       }

       ut += "\n";
       ut += "Minste tall: " + minsteTall() + "\n";
       ut += "Største tall: " + largestNumber() + "\n";
       ut += "Gjennomsnitt: " + String.format("%1$,.2f", avarage()) + "\n";
       ut += "Tall nærmest gjennomsnitt: " + mathAbs();

       JOptionPane.showMessageDialog(null, ut);
   }
}
