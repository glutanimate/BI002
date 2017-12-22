public class Patient extends Mensch {
    private Pflegekraft pfleger;
    private Arzt arzt;

    private String patID;

    // Konstruktor, sofern Eltern identifiziert
    public Patient(String name, String vorname, Mensch vater,
                   Mensch mutter) {
        super(name, vorname, vater, mutter);
    }

    // Konstruktor, sofern Waise oder Adam/Eva
    public Patient(String name, String vorname) {
        super(name, vorname);
    }

    // Da sich das betreuende Personal im Gegensatz zu Name, Vorname, Eltern ändern kann,
    // nutzen wir Setter anstatt das Personal bereits im Konstruktor zuzuweisen:
    public void weiseArztZu(Arzt arzt){
        this.arzt = arzt;
    }

    public void weisePflegerZu(Pflegekraft pfleger){
        this.pfleger = pfleger;
    }

    public String nenneArzt() {
        if (arzt == null) {
            return "Derzeit ist kein Arzt zugewiesen.";
        }
        return arzt.nenneName();
    }

    public String nennePfleger() {
        if (pfleger == null) {
            return "Derzeit ist keine Pflegekraft zugewiesen.";
        }
        return pfleger.nenneName();
    }

    public void setzeID(String patID) {
        this.patID = patID;
    }
}
