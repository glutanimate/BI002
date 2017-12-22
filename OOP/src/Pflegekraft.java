public class Pflegekraft extends Mensch {
    // Konstruktor, sofern Eltern identifiziert
    public Pflegekraft (String name, String vorname, Mensch vater, Mensch mutter) {
        super(name, vorname, vater, mutter);
    }

    // Konstruktor, sofern Waise oder Adam/Eva
    public Pflegekraft (String name, String vorname) {
        super(name, vorname);
    }
}
