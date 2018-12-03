package eksamenhøst2013;

public class Pasient extends Person{
    private Resept[] resepter;
    private int antall = 0;
    private final int MAX = 100;

    /*< Konstruktør som mottar pasientens navn og fødselsdato
        som parametre og foretar nødvendig initialisering. >*/
    Pasient(String navn, String personnummer){
        super(navn, personnummer);
        resepter = new Resept[MAX];
    }



    public boolean nyResept( Resept ny  ){
        for (int i = 0; i < resepter.length; i++) {
            if (resepter[i] == null){
                resepter[i] = ny;
                return true;
            }
        }
        return false;
    }

    public Resept finnResept( int n ){
        //< Metoden returnerer resepten med reseptnummer lik parameteren n.
        //Hvis en slik ikke finnes, skal metoden returnere null. >
        for (Resept enResept : resepter){
            if (enResept != null){
                if (enResept.getNr() == n){
                    return enResept;
                }
            }
        }
        return null;
    }

    public String toString() {
        //< Metoden skal returnere all informasjon om pasienten og
        //vedkommendes resepter. Det skal fremgå av teksten om
        //medisinene reseptene foreskriver  er utlevert eller ikke,
        //samt hvor mange resepter som ikke er avhentet. >
        String utRep = "";
        for (Resept enResept : resepter){
            if (enResept != null){
                utRep += enResept.toString();
                utRep += "\n";
            }
        }

        return super.toString()+ "\n" + utRep;
    }
} // end of class Pasient
