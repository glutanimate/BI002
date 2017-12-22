import java.util.Date;

public class Arzt extends Mensch {

    Date approbDat;

    // Konstruktor, sofern Eltern identifiziert
    public Arzt (String name, String vorname, Mensch vater, Mensch mutter) {
        super(name, vorname, vater, mutter);
    }

    // Konstruktor, sofern Waise oder Adam/Eva
    public Arzt (String name, String vorname) {
        super(name, vorname);
    }

    public void approbiertAm (String dat) {
        Date d = new Date(dat);
        approbDat = d;
    }
}
