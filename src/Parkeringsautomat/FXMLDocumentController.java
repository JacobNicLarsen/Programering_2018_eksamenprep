package Parkeringsautomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class Bil{
    public String bilNummer;
    public Date startTid;
    public int plass;
    public boolean kortTid; // true = korttids parkering

    public Bil(String bilNummer, Date startTid, boolean kortTid) {
        // konstruktør
        this.bilNummer = bilNummer;
        this.startTid = startTid;
        this.kortTid = kortTid;
    }


    public String formaterKvittering(){
        // formater kvitteringen etter oppgitt format
        String s;
        Date nå = new Date();
        String startDatoTid = new SimpleDateFormat("dd.MM.YYYY HH:mm").format(nå);
        String sluttDatoTid = new SimpleDateFormat("dd.MM.YYYY HH:mm").format(startTid);

        s = "Kvittering for bilnummer: " + bilNummer + "\n"
                + "Start tid: " + startDatoTid + " til " + startDatoTid + "\n"
                + "Betalt: " + avgift();

        return s;
    }

    public double getPris(){
        // returner 10 eller 20 kroner avhengig av kortTid eller ikke
        return kortTid ? 10 : 20;
    }

    public double avgift(){
        // regner ut tiden som er gått i timer og ganger med prisen
        Date nå = new Date();
        long varighet = nå.getTime() - startTid.getTime();

        return getPris() * (float) (varighet / 3600000) + getPris();
    }
}

class Parkeringshus{
    // opprett arrayet av biler
    private final int MAKS_KAPASITET = 20;
    Bil[] bilArray = new Bil[MAKS_KAPASITET];

    public void reserverPlass(Bil enBil){
        // legg bilen i arrayet
        int ledigplass = 0;
        while (bilArray[ledigplass] != null) ledigplass ++;

        if (ledigplass > MAKS_KAPASITET) throw new IllegalStateException("Parkeringsplassen er full");
        bilArray[ledigplass] = enBil;
        enBil.plass = ledigplass;
    }

    public String frigjørPlass(String bilNummeret){
        /*
         ** må finne bilen i arrayet
         ** når den er funnet slett den fra arrayet
         ** og formater kvitteringen som returneres
         ** dersom bilen ikke finnes skal man returnere en passenede tekst
         */

        int i = 0;
        String s = "Fant ikke bilen";

        for (; i < bilArray.length - 1; i++) {

            if (bilArray[i] != null){
                if (bilArray[i].bilNummer.equals(bilNummeret)){
                    s = bilArray[i].formaterKvittering();
                    bilArray[i] = null;
                    return s;
                }
            }
        }
        return s;
    }
}



public class FXMLDocumentController {

    Parkeringshus parkeringshus = new Parkeringshus();

    @FXML
    private Label lblAvgift;

    @FXML
    private TextField txtBilnummer;

    @FXML
    void kjørUt(ActionEvent event) {
        // kall frigjør plass og legg ut kvitteringen i lblAvgift

        String ut = "";
        try{
            ut = parkeringshus.frigjørPlass(txtBilnummer.getText());
        }catch (Exception e){
            ut = "Feil";
        }

        lblAvgift.setText(ut);
        System.out.println(Arrays.toString(parkeringshus.bilArray));
    }

    @FXML
    void regKorttid(ActionEvent event) {
        // opprett en bil
        // og kall på reserver plass

        String bilnummer;

        try{
            bilnummer = txtBilnummer.getText();
        }catch (Exception e){
            throw new IllegalArgumentException("Må skrive inn et korrekt bilnummer");
        }

        Date nå = new Date();
        Bil nybil = new Bil(bilnummer,nå, true);

        parkeringshus.reserverPlass(nybil);
        lblAvgift.setText("Bil lagit til med korttidsparkering");
        System.out.println(Arrays.toString(parkeringshus.bilArray));
    }

    @FXML
    void regLangtid(ActionEvent event) {
        // opprett en bil
        // og kall på reserver plass

        String bilnummer;

        try{
            bilnummer = txtBilnummer.getText();
        }catch (Exception e){
            throw new IllegalArgumentException("Må skrive inn et korrekt bilnummer");
        }


        Date nå = new Date();
        Bil nybil = new Bil(bilnummer,nå, false);

        parkeringshus.reserverPlass(nybil);
        lblAvgift.setText("Bil lagit til med korttidsparkering");
        System.out.println(Arrays.toString(parkeringshus.bilArray));
    }
}