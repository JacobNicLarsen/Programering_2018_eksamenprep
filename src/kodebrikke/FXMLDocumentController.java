package kodebrikke;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

class KodeGenerator {
    private int[] kodeArray;
    private Random r = new Random();
    private int nyKodeIndeks = 0;

    public KodeGenerator(int antall) {
        /* opprett array
           kall genererKoder for å legge kodene inn i arrayet */
        this.kodeArray = new int[antall];
        genererKoder();
    }

    private void genererKoder() {
        /* Fyller  kodeArray med tilfeldige, 6-sifrede tall.
           NB! Det laveste mulige tallet skal være 100000, og det høyeste 999999. */
        for (int i = 0; i < kodeArray.length; i++) {
            kodeArray[i] = r.nextInt(900000) + 100000;
        }
    }

    public String nyKode(int maksAntall) {
        // returnerer ny kode fra arrayet eller en feilmelding ved array-slutt
        if (nyKodeIndeks < maksAntall){
            return Integer.toString(kodeArray[nyKodeIndeks++]);
        }
        return "Maks antall";
    }

    public String formaterBrukteKoder() {
        /* løp igjennom arrayet og formater kodene med \n i mellom
            kodene fra og med 0 til nyKodeIndeks er "brukte" koder */
        String ut = "";
        for (int i = 0; i < nyKodeIndeks - 1; i++) {
            ut += kodeArray[i] + "\n";
        }

        return ut;
    }
}

public class FXMLDocumentController {

    private final int MAKS_ANTALL = 10;
    KodeGenerator kodeGenerator = new KodeGenerator(MAKS_ANTALL);

    @FXML
    private Label lblGamleKoder;

    @FXML
    private Label lblNyKode;

    @FXML
    void gamleKoder(ActionEvent event) {
        // kall til formaterBrukteKoder og legg resultatet i lblGamleKoder

       String utStreng = kodeGenerator.formaterBrukteKoder();

        lblGamleKoder.setText(utStreng);
    }

    @FXML
    void nyKode(ActionEvent event) {
        // kall til nyKode og legg resultat i lblNykode

        String utStreng = kodeGenerator.nyKode(MAKS_ANTALL);

        lblNyKode.setText(utStreng);
    }
}