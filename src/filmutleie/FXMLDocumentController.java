package filmutleie;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

class Film{
    public String tittel;
    public double utLeiePris;
    public Person leidAv;

    Film(String tittel, double utLeiePris, Person leidAv){
        this.tittel = tittel;
        this.utLeiePris = utLeiePris;
        this.leidAv = leidAv;
    }

}

class Person{
    public String navn;
    public String telefonnr;

    Person(String navn, String telefonnr){
        this.navn = navn;
        this.telefonnr = telefonnr;
    }
}

class FilmUtleie{

    // instansier arrayet her
    ArrayList<Film> filmArray = new ArrayList<>();

    int[] array = new int[10];

        FilmUtleie() {
        // legg inn filmene som skal være til utleie her
        // to filmer holder
        filmArray.add(new Film("Film1" , 10.90, null));
        filmArray.add(new Film("Film2" , 10.00, null));

    }

    public String leiUt(String navn, String telefonnr, String tittel){
        // sjekk om filmen finnes og at den ikke er leid ut (at leidAv er null)
        // returner meldinger om det var vellykket utleie
        // om ikke filmen fantes
        // eller om filmen fantes men den var utleid

        for (Film enkeltFilm : filmArray){
            if (enkeltFilm.tittel.equals(tittel)){
                if (enkeltFilm.leidAv == null){
                    Person nyPerson = new Person(navn, telefonnr);
                    enkeltFilm.leidAv = nyPerson;
                    return  "Vellykket, filmen ble leid til " + nyPerson.navn;
                }
                else return "Filmen finnes men er leid";
            }
        }

        return "Filmen finnes ikke";

    }

    public String leverInn(String tittel){
        // sjekk om filmen finnes og at den er utleid (at det er et personobjekt på leidAv)
        // dersom dette nullstill person-pekeren i filmen og returner at den ble levert
        // returner feilmelding dersom filmen ikke finnes
        // returner også feilmelding dersom filmen finnes med ikke er utleid
        for (Film enkeltFilm : filmArray){
            if (enkeltFilm.tittel.equals(tittel)){
                if (enkeltFilm.leidAv != null){
                    enkeltFilm.leidAv = null;
                    return  "Vellykket, filmen er ikke leid til noen";
                }
                else return "Filmen finnes men er ikke leid";
            }
        }

        return "Filmen finnes ikke";
    }

    @Override
    public String toString(){
        // løp igjennom hele registrert og formater

        String s = "";
        for (Film enkeltFilm : filmArray){

            if (enkeltFilm.leidAv != null){
                s += "Tittel: " +  enkeltFilm.tittel + " Leid av " + enkeltFilm.leidAv.navn + "\n";
            }
            else{
                s += "Tittel: " +  enkeltFilm.tittel + " Leid av " + enkeltFilm.leidAv + "\n";
            }
        }

        return s;
    }
}


public class FXMLDocumentController {

    FilmUtleie filmUtleie = new FilmUtleie();

    @FXML
    private TextField txtKundeNavn;

    @FXML
    private TextField txtKundeTelefon;

    @FXML
    private TextField txtFilmTittel;

    @FXML
    private Label lblOversikt;

    @FXML
    void leiUt(ActionEvent event) {
        // kall leiUt og legg resultatet i oversikts-labelen



        lblOversikt.setText(filmUtleie.leiUt(txtKundeNavn.getText(), txtFilmTittel.getText(), txtFilmTittel.getText()));
    }

    @FXML
    void leverInn(ActionEvent event) {
        // kall lever inn og legg resultatet i oversikts-labelen
        lblOversikt.setText(filmUtleie.leverInn(txtFilmTittel.getText()));
    }

    @FXML
    void visUtleie(ActionEvent event) {
        // kall toString metoden og legg resultatet i oversikts-labelen
        lblOversikt.setText(filmUtleie.toString());
    }
}