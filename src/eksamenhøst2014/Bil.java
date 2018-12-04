package eksamenhøst2014;

import java.util.Arrays;

public class Bil {
    private String kjennetegn;
    private int registreringsår;
    private Reparer[] reparasjoner;
    private int antReparasjoner = 0;  // antall registrerte reparasjoner

    Bil(int registreringsår){
        if (registreringsår < 2000) reparasjoner = new Reparer[25];
        else if ((registreringsår >= 2000) && (registreringsår < 2010)) reparasjoner = new Reparer[10];
        else reparasjoner = new Reparer[15];

    }

    public String getKjennetegn()
    {
        return kjennetegn;
    }

    public boolean regReparasjon(Reparer rep)
    {
        int i = 0;

        while (reparasjoner[i] != null) i++;

        if (i == reparasjoner.length - 1){
            return false;
        }

        reparasjoner[i] = rep;
        rep.oppdragsnummer = i;
        return true;
    }

    public Reparer finnReparasjon(int nummer)
    {
        for (Reparer rep :reparasjoner){
            if (rep != null){
                if (rep.oppdragsnummer == nummer){
                    return rep;
                }
            }
        }
        return null;
    }

    public boolean erEUgodkjent()
    {
        //Sjekker om bilen er EU-godkjent. Det er tilfelle dersom alle
        // registrerte reparasjoner som er EU-krav er ferdig utført.

        boolean eu_godkjent = true;
        for (Reparer rep : reparasjoner){
            if (rep != null){
                if (!rep.getEu_krav()) eu_godkjent = false;
            }
        }

        return eu_godkjent;
    }

    @Override
    public String toString() {


        int antallIkkeNullVerdier = 0;
        while (reparasjoner[antallIkkeNullVerdier] != null){
            antallIkkeNullVerdier ++ ;
        }
        Reparer[] utArray = new Reparer[antallIkkeNullVerdier];

        for (int i = 0; i < antallIkkeNullVerdier; i++) {
            utArray[i] = reparasjoner[i];
        }

        return "Bil{" +
                "kjennetegn='" + kjennetegn + '\'' +
                ", registreringsår=" + registreringsår +
                ", reparasjoner=" + Arrays.toString(utArray) +
                ", antReparasjoner=" + antReparasjoner +
                '}' + "\n";
    }

}

