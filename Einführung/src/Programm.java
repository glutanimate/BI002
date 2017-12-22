// Klassendefinition
public class Programm
// geschweifte Klammern eröffnen Block (=logische Einheit)
{    
    // Konstruktor
    public Programm()
    {
    }


    public int calculate(int a)
    {
       /*
       for (int i = 1; i < 1000; i++) {
           a = a + 2;
           System.out.println("Zwischenergebnis: " + i + ": " + a);
       }
       */
       
       int k = 0;
       while (k < 20) {
           System.out.println("Zwischenergebnis: " + (k + k) );
           k = k + 3;
       }
        
       return a;

    }
    
    
}
