package eksamenfeb2013;

public class Lodd {
    private int loddNr;
    public static int hjelpevariabel;
    private boolean vinnerlodd = false;
    private String loddkjøperNavn;
    private String loddkjøperEpost;
    private String loddkjøperMobilnummer;

    public Lodd(String loddkjøperNavn, String loddkjøperEpost, String loddkjøperMobilnummer){
        this.loddkjøperNavn = loddkjøperNavn;
        this.loddkjøperEpost = loddkjøperEpost;
        this.loddkjøperMobilnummer = loddkjøperMobilnummer;
        this.loddNr = hjelpevariabel++;
    }

    public int getLoddNr(){
        return loddNr;
    }

    public void setVinnerlodd(){
        vinnerlodd = true;
    }

    public boolean erVinnerLodd(){
        return vinnerlodd;
    }

    @Override
    public String toString(){
        return "LoddNr: " + loddNr + "\n" +
                "Eier: " + loddkjøperNavn + "\n" +
                "Mobilnummer: " + loddkjøperMobilnummer + "\n" +
                "E-Post: " + loddkjøperEpost;
    }
}
