package eksamenhøst2013;

public class Lege extends Person {

    private boolean lisens;
    private Resept[] resepts;
    private final int MAKS_RESEPT = 10;
    private int antallResepter = 0;

    public Lege(String navn, String fødselsdato, boolean lisens){
        super(navn, fødselsdato);
        this.lisens = lisens;
        resepts = new Resept[MAKS_RESEPT];
    }

    public boolean getLisens(){
        return lisens;
    }

    public String nyResept( Resept r )
    {
        /*
        < Metoden mottar en resept som parameter og setter den, om mulig,
            inn i arrayen av resepter. Hvis dette gikk bra, skal metoden returnere
        informasjon om selve resepten, og i motsatt fall skal den returnere
        informasjon om at det ikke var plass i arrayen. >*/
        for (int i = 0; i < resepts.length; i++) {
            if (resepts[i] == null){
                resepts[i] = r;
                antallResepter++;
                return "resepten ble lagt til i systemet";
            }
        }
        return "Ikke plass til flere resepter";
    }

    public String utskrevneResepter()
    {
        /*
        < Metoden skal returnere en tekst som inneholder informasjon om
        alle reseptene legen har skrevet ut. Reseptene skal skrives ut i
        omvendt kronologisk rekkefølge slik at de nyeste reseptene kommer
        første og de eldste sist. Hvis legen ikke har skrevet ut noen
        resepter, skal metoden returnere informasjon om det. >*/
        String ut = "";
        for (int i = resepts.length - 1; i >= 0; i--) {
            if (resepts[i] != null) {
                ut += resepts[i].toString() + "\n";
            }
        }

        return ut;
    }


    @Override
    public String toString(){
        String ut = "";
        for (Resept enResept : resepts){
            if (enResept != null){
                ut += resepts;
                ut += "\n";
            }
        }

        return super.toString() + " har lisens: " + lisens + "\n" +
                utskrevneResepter();
    }
}
