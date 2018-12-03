package eksamenfeb2014;

import java.text.DateFormat;
import java.util.Calendar;

public class LangtidsParkering extends Parkering
{
    private static double døgnpris = 100;
    private static  double parkerinsBot = 1000;
    private static final int MAXTID = 2;

    LangtidsParkering(String bilnr, Calendar starttid, int plass) {
        super(bilnr, starttid, plass);
    }

    public static double getDøgnpris() {
        return døgnpris;
    }

    public static double getParkerinsBot() {
        return parkerinsBot;
    }

    public static int getMAXTID() {
        return MAXTID;
    }

    public int antallDager(Calendar sluttTid) {
        long avstand = Math.abs(sluttTid.getTime().getTime() - getStarttid().getTime().getTime());
        return (int)avstand / 3600000 / 24;
    }

    public double parkeringsBot( Calendar d) {
        return antallDager(d) > MAXTID ? parkerinsBot : 0;
    }

    public String kvittering(Calendar sluttTid) {
        DateFormat df = DateFormat.getInstance();
        String endTime = df.format( sluttTid.getTime() );

        return toString() + "Bilen ble hentet: " + endTime + "\n" +
                "Prisen ble " + avgift(sluttTid);
    }

    @Override
    public double getPris() {
        return døgnpris;
    }

    @Override
    public double avgift(Calendar d) {
        return døgnpris + (antallDager(d) * døgnpris) + parkeringsBot(d);
    }

    @Override
    public int getMakstid() {
        return MAXTID;
    }



} // end of class LangtidsParkering
