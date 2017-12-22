public class Fibonacci {
    // rekursive Funktion zur Berechnung der Fibonacci-Sequenz an der Stelle 'index'
    public static int berechneFuerIndex(int index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        }
        return berechneFuerIndex(index - 1) + berechneFuerIndex(index - 2);
    }
}