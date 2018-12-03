package eksamenfeb2014;

import java.text.DateFormat;
import java.util.Calendar;

public class KorttidsParkering extends Parkering
{
    private static double timepris = 10;        //Pris pr. påbegynt time
    private static double parkeringsbot = 500;  //Skal betales dersom maksimal
    //parkeringstid overskrides
    public static final int MAXTID = 24;       //Maksimal tillatte parkeringstid

    KorttidsParkering(String bilnr, Calendar starttid, int plass){
        super(bilnr,starttid,plass);
    }

    @Override
    public double getPris(){return timepris;}

    public int antallTimer(Calendar sluttTid)
    {
        long avstand = Math.abs( sluttTid.getTime().getTime() - getStarttid().getTime().getTime());
        return (int)avstand / 3600000;
    }

    public double parkeringsBot(Calendar d)
    {
        return antallTimer(d) > MAXTID ? parkeringsbot : 0;
    }

    public double avgift(Calendar d) {
        return timepris + (antallTimer(d) * timepris) + parkeringsBot(d);
    }

    @Override
    public int getMakstid() {
        return MAXTID;
    }

    public String kvittering(Calendar sluttTid) {
        DateFormat df = DateFormat.getInstance();
        String endTime = df.format( sluttTid.getTime() );

        return toString() + "Bilen ble hentet: " + endTime + "\n" +
                "Prisen ble " + avgift(sluttTid);
    }


    public static int getMAXTID() {
        return MAXTID;
    }

} // end of class KorttidsParkering
