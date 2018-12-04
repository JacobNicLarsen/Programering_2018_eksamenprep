package eksamenfeb2013;

public class Gevinst {
    private Lodd vinnerlodd = null;
    private int gevinst;
    private int gevinstNummer;

    public Gevinst(int gevinst, int gevinstNummer){
        this.gevinst = gevinst;
        this.gevinstNummer = gevinstNummer;
    }

    public void setVinnerlodd(Lodd vinnerlodd){
        this.vinnerlodd = vinnerlodd;
    }

    public Lodd getVinnerlodd(){
        return vinnerlodd;
    }

    public int getGevinst(){
        return gevinst;
    }
}
