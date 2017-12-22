import java.util.Date; // Import aus Standardbibliothek

// Klassendeklaration:
public class Mensch {

    private String vorname;
    private String name; // Klasse String 
    private Mensch vater;
    private Mensch mutter;

    private Date gebdat;

    // Konstruktor, sofern Eltern identifiziert
    public Mensch (String name, String vorname, Mensch vater, Mensch mutter) {
        // Instanzvariablen:      
        // 'this' ist nur a.G. der gleichnamigen Argumente des Konstruktors notwendig
        // Typischerweise verweidet man in Java die Nutzung von 'this', indem man die
        // Argumente anders benennt. 'this' sei hier nur zum Vergleich mit Python
        // genutzt.
        this.name = name;
        this.vorname = vorname;
        this.vater = vater;
        this.mutter = mutter;
    }

    // Konstruktor, sofern Waise oder Adam/Eva
    public Mensch (String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String nenneName() {
        return vorname + " " + name;
    }

    public String nenneStammbaum() {
        if (vater == null || mutter == null ||
                vater.zeigMutter() == null || mutter.zeigMutter() == null) {
            return "Familienstammbaum unvollständig";
        }

        return  "Mutter: " + nenneMutter() + "\n" +
                "Vater: " + nenneVater() + "\n" +
                "Großvater väterlicherseits: " + vater.zeigVater().nenneName() + "\n" +
                "Großmutter väterlicherseits: " + vater.zeigMutter().nenneName() + "\n" +
                "Großvater mütterlicherseits: " + mutter.zeigVater().nenneName() + "\n" +
                "Großmutter mütterlicherseits: " + mutter.zeigMutter().nenneName() + "\n";

    }

    public Mensch zeigMutter() {
        return mutter;
    }
    public Mensch zeigVater() {
        return vater;
    }

    public String nenneMutter() {
        if (mutter == null) {
            return "Keine Mutter bekannt";
        }
        return mutter.nenneName();
    }

    public String nenneVater() {
        if (vater == null) {
            return "Kein Vater bekannt";
        }
        return vater.nenneName();
    }

    public void gebAm(String dat) {
        Date d = new Date(dat);
        gebdat = d;
    }

    public Date wieAltBistDu() {
        // TODO: Alter berechnen
        return gebdat;
    }
}
