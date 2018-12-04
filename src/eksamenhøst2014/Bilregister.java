package eksamenhøst2014;

public class Bilregister {
    private Bil[] bilregister; // NB! Arrayen kan inneholde null-pekere!

    // Denne konstruktøren skal du ikke programmere.
    public Bilregister( int kapasitet ) {
            //< Foretar nødvendig initialisering. Parameteren angir hvor mange
            //biler verkstedet skal ha kapasitet til å registrere for reparasjoner.
    }

    private Bil finnBil( String kjennetegn ) {
            //< Returnerer bil med kjennetegn lik parameterens verdi dersom
            //denne finnes i registeret, returner null ellers. >
        for (Bil enBil : bilregister){
            if (enBil.getKjennetegn().equals(kjennetegn)) return enBil;
        }
        return null;
    }

    private Reparer finnReparasjon( int nummer ) {
        //< Finner og returnerer reparasjonen med det oppdragsnummer som
        //parameteren angir. Returnerer null i tilfelle den ikke finnes. >

        for (Bil e : bilregister){
            if (e.finnReparasjon(nummer).equals(nummer)){
                return e.finnReparasjon(nummer);
            }
        }
        return null;
    }

    public String registrerBil( Bil ny )
    {
        //Registrerer en ny bil i registeret, i tilfelle det er plass og
        //det ikke allerede er registrert en bil med samme kjennetegn.
        //Returverdien skal gi opplysninger om  utfallet av registreringen.
        int i = 0;
        while (bilregister[i] != null){
            i++;
        }

        if (i > bilregister.length - 1){
            return "Ikke mer plass i registeret";
        }

        bilregister[i] = ny;

        return "Bil ble vellykket satt inn i regiseret";
    }

    public String nyReparasjon( String kjennetegn, String beskrivelse, boolean erEUkrav )
    {
        //Finner bil med mottatt kjennetegn og registrerer oppdrag på en ny
        //reparasjon på denne. Returnerer passende tilbakemelding, også for det
        //tilfellet at bilen ikke finnes i registeret, eller det ikke er
        //kapasitet til å legge inn flere reparasjoner på den.

        Bil nyBil = finnBil(kjennetegn);

        try{
            Reparer nyRep = new Reparer(beskrivelse, erEUkrav);
            nyBil.regReparasjon(nyRep);
        }catch (Exception e){
            return "Feil i registrering";
        }

        return "Bil " + nyBil.getKjennetegn() + " Registrerte ny reprasjon ";
    }

    public String sjekkEUgodkjenning( String kjennetegn )
    {
        //Sjekker om bilen med mottatt kjennetegn er EU-godkjent eller ikke
        //og returnerer opplysninger om dette. Hvis bilen ikke finnes
        //registrert i registeret skal det returneres opplysninger om det.
        int i = 0;
        while (bilregister[i] != null){
            if (bilregister[i].getKjennetegn().equals(kjennetegn)){
                if (bilregister[i].erEUgodkjent()){
                    return "Bilen er EU Godkjent";
                }
                else return "Bilen er ikke eu godkjent";
            }
        }
        return "Fant ikke bilen i registeret";
    }


    public boolean settReparasjonUtført( int nummer )
    {
        //Registrerer at den reparasjon det mottas oppdragsnummer for er ferdig
        //utført. Returverdien indikerer om reparasjonen ble funnet i registeret.

        throw new IllegalArgumentException("Dette gir legit ingen mening");
    }

    // Denne metoden skal du ikke programmere.
    public String bilinfo( String kjennetegn )
    {
        //Returnerer informasjon om bil med kjennetegn lik parameterens verdi
        //dersom denne finnes i registeret, returnerer ellers informasjon
        //om at den ikke finnes.
        throw new IllegalArgumentException("Ikke laget");
    }

    // Denne metoden skal du ikke programmere.
    public String visReparasjon( int nummer )
    {
        //Returnerer alle registrerte opplysninger om reparasjonen med det
        //oppdragsnummer som parameteren angir. Returnerer null dersom den ikke
        //finnes.
        throw new IllegalArgumentException("Ikke laget enda");
    }
}
