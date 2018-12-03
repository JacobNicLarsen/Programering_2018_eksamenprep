package Oblig2;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

class Tallspill
{
    // Nødvendige attributter.
    private int tall = nyttTall();
    private int antallGjett = 0;

    public int nyttTall() {
        // Trekker og returnerer et slumptall mellom 0 og 200.
        // Tips bruk : (int) (Math.random() * 201), random-metoden gir verdier mellom 0 og 1
        return (int)(Math.random() * 201);
    }

    public void visMelding(String melding){
        // Viser parameterens innhold i en meldingsboks.
        JOptionPane.showMessageDialog(null, melding);
    }

    private void forLite( int tall ){
    /* Viser melding om at parameterens verdi er for
       lite tall og ber spilleren prøve igjen. */
    JOptionPane.showMessageDialog(null, tall + " er for lite");
    }

    private void forStort( int tall ) {
    /* Viser melding om at parameterens verdi er for
      stort tall og ber spilleren prøve igjen. */
    JOptionPane.showMessageDialog(null, tall + " er for stort");
    }

    public void avsluttRunde( int antall, int gjetning ) {
    /* Viser melding om at det ble gjettet riktig
      og antall gjetninger som ble brukt.
      Parametrene gir opplysninger om dette. */
    JOptionPane.showMessageDialog(null, gjetning + " er riktig gjennt, du brukte " + antall + " forsøk");
    }

    public void kjørSpill() {
    /* Kjører en spillrunde ved å trekke et tall,
      nullstille tellevariabel, innhente gjentatte
      gjetninger fra bruker inntil det gjettes riktig.
      Når det skjer, avsluttes runden med passe
      meldinger til spilleren. */
    }
}
