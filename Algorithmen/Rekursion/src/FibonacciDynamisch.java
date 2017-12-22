import java.util.HashMap;

public class FibonacciDynamisch {

    // die statisch initialisierte Hashmap erlaubt uns bei mehreren Invokationen
    // der Klasse Rechenzeit zu sparen, da auf vorher berechnete Werte
    // im aktuellen Programmzyklus zurückgegriffen werden kann
    private static HashMap<Integer, Integer> vorwerte = new HashMap<>();

    // statischer Initialisierer
    static {
        vorwerte.put(0,0);
        vorwerte.put(1,1);
    }

    public static int berechneFuerIndex(int index) {
        if (vorwerte.containsKey(index)) {
            return vorwerte.get(index);
        }
        int neu = berechneFuerIndex(index - 1) + berechneFuerIndex(index - 2);
        vorwerte.put(index, neu);
        return neu;
    }

    public static void listeVorwerte() {
        System.out.println("Bisher berechnete Werte: " + vorwerte);
    }
}
