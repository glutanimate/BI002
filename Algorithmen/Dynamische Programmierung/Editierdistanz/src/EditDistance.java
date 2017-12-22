
public class EditDistance { // Definiere eine neue Klasse namens 'EditDistance' mit öffentlichen Zugriffsrechten.
    
    // Jedes Paar geschweifter Klammern grenzt jeweils einen eigenen Programmblock ab.
    // Momentan befinden wir uns im Programmblock der 'EditDistance' Klassendefinition.
    
    public EditDistance() {} // Definiere den Konstruktor der Klasse 'EditDistance'.
                             // In diesem Fall kommen wir ohne Argumente und zusätzliche Anweisungen aus.

    public int distance(String a, String b) // Definiere eine neue Instanzmethode 'distance' mit öffentlichen Zugriffsrechten.
                                            // Aufgabe der Methode ist die Berechnung der minimalen Editierdistanz zweier Zeichenketten.
                                            //
                                            // Dazu weist sie folgende Eigenschaften auf:
                                            //  - Argumente: zwei Variablen 'a', 'b', die jeweils Daten vom Typ 'String' aufnehmen
                                            //    (Klasse aus Javas Standardbibliothek, die für Zeichenketten genutzt wird) 
                                            //  - Datentyp des Rückgabewertes: 'int' (primitiver Datentyp, der ganzzahlige Zahlen innerhalb
                                            //    bestimmter Grenzen annehmen kann).

    {
        
        // === Deklaration und Initialisierung der Editierdistanz-Matrix ===

        // Das im Folgenden initialisierte Datenfeld erlaubt uns Teilergebnisse im Sinne der dynamischen Programmierung zwischenzuspeichern.
        // Es ermöglicht daher eine weitaus effizientere Berechnung der minimalen Editierdistanz als über die
        // konventionelle rekursive Herangehensweise.

        //                         ↓ jede einzelne Programmanweisung innerhalb eines Programmblockes muss durch ein Semikolon abgeschlossen werden.
        int zeilen = a.length() + 1;  // Deklariere die lokale Variable 'zeilen' als 'int'-Variable und weise ihr das Ergebnis
                                      // des Rechentermes zu, der rechts vom Zuweisungsoperator '=' steht.
                                      // In diesem Falle nutzen wir die 'String.length()'-Methode, um die Länge der 'a' zugewiesenen
                                      // Zeichenkette zu bestimmen, und inkrementieren diesen Wert um 1.
                                      // Der resultierende Wert entspricht der Zahl der Zeilen, die wir im Folgenden für unsere
                                      // Editierdistanz-Matrix benötigen werden

        int spalten = b.length() + 1; // Wiederhole den gleichen Vorgang wie oben für die Zahl der Spalten 'spalten'.
        

        int[][] matrix = new int[zeilen][spalten]; // Deklariere eine lokale Variable 'matrix', der zweidimensionale 'int'-Datenfelder (=Arrays)
                                                   // zugewiesen werden können und initialisiere sie mit einem neu erstellten 
                                                   // zweidimensionalen 'int'-Array der Zeilen- und Spaltenlänge 'zeilen' und 'spalten'.
        

        // === Initialisierung der Anfangswerte der Editierdistanz-Matrix ===

        // # Initialisierung der ersten Spalte #
        for (int i = 0; i < zeilen; i++) // Nutze das Schlüsselwort 'for', um eine Zählschleife mit den folgenden Eigenschaften anzusetzen
                                         // (definiert im folgenden dreiteiligen '()'-Block):
                                         // - Initialisierungsklausel: Deklariere die Zählvariable 'i' als 'int' und setze sie auf 0
                                         // - Abbruchbedingung: Breche die Zählschleife ab, sobald der Boole'sche Ausdruck 'i < zeilen'
                                         //   nicht mehr erfüllt ist. D.h. iteriere ausgehend von 'i = 0' nur so oft, 
                                         //   wie Zeilen vorhanden sind.
                                         // - Iterationsteil: Inkrementiere die Zählvariable 'i' zu Beginn jeder neuen Iteration um 1
        { // Geschweifte Klammern leiten Anweisungsblock der Zählschleife ein
            matrix[i][0] = i; // Weise der 0. Spalte der i. Zeile den Wert von i zu.
        }
        
        // # Initialisierung der ersten Zeile #
        for (int j = 0; j < spalten; j++) // Wiederhole den gleichen Vorgang wie oben für die Zahl der Spalten 'spalten' unter
                                          // der Verwendung der Zählvariable 'j'.
        {
            matrix[0][j] = j; // Weise der j. Spalte der 0. Zeile den Wert von j zu.
        }

        
        // === Deklaration und Initialisierung lokaler Variablen für die folgenden Zählschleifen ===
        
        int zusatzKosten = 0; // Deklariere und initialisiere die Variable 'zusatzKosten' auf 0. Bezeichnet die Zusatzkosten für eine Punktmutation.
        int insertion = 0; // Wie oben. Bezeichnet die Kosten für eine Insertion
        int deletion = 0; // Wie oben. Bezeichnet die Kosten für eine Deletion
        int punktmutation = 0; // Wie oben. Bezeichnet die Kosten für eine Punktmutation
        int lokaleDistanz = 0; // Wie oben. Bezeichnet die lokale minimale Editierdistanz der betrachteten Teilzeichenketten
        
        
        // === Iterativer Algorithmus zur Bestimmung der minimalen Editierdistanz ausgehend von den oben definierten Anfangswerten ===

        // # Nutze eine Zählschleife, um über alle bisher nicht ausgefüllten Zeilen der Editierdistanz-Matrix zu iterieren: #
        for (int i = 1; i < zeilen; i++) { // Im Gegensatz zur Initialisierung der Anfangswerte gehen wir diesmal 
                                           // vom Zeilenindex i = 1 aus (d.h. der zweiten Zeile).
            
            char charA = a.charAt(i - 1); // Deklariere eine lokale Variable 'charA', der Daten vom Typ 'char' zugewiesen werden können (d.h.
                                          // einzelne Unicode-Charaktere). Initialisiere sie auf den Rückgabewert der 'String.charAt()' Methode
                                          // rechts des Zuweisungsoperators.
                                          // 
                                          // In diesem Fall wollen wir den (i-1)-ten Buchstaben der 'a'-zugewiesenen Zeichenkette erhalten. Die
                                          // Dekrementierung um eins ist notwendig, da die Spaltenzahl der Editiermatrix die Buchstabenzahl 
                                          // um eins übersteigt.
                                          // 
                                          // Wir können die Zuweisung von 'charA' bereits an dieser Stelle in der Schleifenstruktur durchführen,
                                          // da 'charA' über alle folgenden Spalten hinweg im aktuellen Iterationszyklus konstant bleibt.
            
            // # Nutze eine zweite, verschachtelte Zählschleife, um über alle bisher nicht ausgefüllten Spalten der Editierdistanz-Matrix zu iterieren: #
            for (int j = 1; j < spalten; j++) { // Im Gegensatz zur Initialisierung der Anfangswerte gehen wir diesmal
                                                // vom Spaltenindex i = 1 aus (d.h. der zweiten Spalte).
                
                char charB = b.charAt(j - 1); // Wie zuvor für 'a', deklarieren und initialisieren wir nun eine Variable, um den korrespondierenden Buchstaben
                                              // der 'b'-zugewiesenen Vergleichszeichenkette zwischenzuspeichern.
                
                // # Überprüfe, ob für eine Punktmutation zusätzliche Kosten anfallen: #

                if (charA == charB) // Nutze eine bedingte Anweisung (Schlüsselwort 'if'), um zu überprüfen, ob beide Zeichenketten 
                                    // an den aktuellen Positionen jeweils den gleichen Buchstaben aufweisen 
                                    // (Boole'scher Ausdruck 'charA == charB')
                // Sollte dies der Fall sein, so führe den folgenen Programmblock aus:
                {
                    zusatzKosten = 0; // Setze 'zusatzKosten' auf 0.
                } 
                // Ansonsten führe den Programmblock aus, der auf das Schlüsselwort 'else' folgt:
                else {
                    zusatzKosten = 1; // Setze 'zusatzKosten' auf 1.
                }
                
                // # Bestimme die Kosten für die drei möglichen Operationen am Ende der aktuellen Teilzeichenketten: #
                
                insertion = matrix[i-1][j] + 1; // Rufe den vorberechneten Array-Wert eine Zeile über dem aktuellen Index [i][j]
                                                // ab, füge 1 hinzu, weise ihn der Insertionskostenvariable 'insertion' zu.
                deletion = matrix[i][j-1] + 1; // Rufe den vorberechneten Array-Wert eine Spalte links des aktuellen Indizes [i][j]
                                               // ab, füge 1 hinzu, weise ihn der Deletionskostenvariable 'deletion' zu.
                punktmutation = matrix[i-1][j-1] + zusatzKosten; // Rufe den vorberechneten Array-Wert diagonal links oben des aktuellen Indizes [i][j]
                                                                 // ab, füge den Wert von 'zusatzKosten' hinzu, 
                                                                 // weise ihn der Punktmutationskostenvariable 'deletion' zu
                
                // # Finde die minimalen Kosten unter den gegebenen Optionen und aktualisiere die Editierdistanz-Matrix: #

                lokaleDistanz = minimum(insertion, deletion, punktmutation); // Weise 'lokaleDistanz' den Rückgabewert der rechtsseitig 
                                                                             // aufgerufenen Editdistance.minimum() Methode zu.
                                                                             // Zur Bestimmung des Minimums werden die drei 'int'-Variablen
                                                                             // 'insertion', 'deletion' und 'punktmutation' als Argumente
                                                                             // an die minimum() Methode weitergegeben.
                
                matrix[i][j] = lokaleDistanz; // Weise dem zweidimensionalen Datenfeld 'matrix' an Position [i][j] den Wert
                                              // von 'lokaleDistanz' zu.
                
            }
        }
        

        // === Optional: Gib fertiggestellte Editierdistanz-Matrix in Standardausgabe aus ===

        // Es wäre effizienter, die Standardausgabe zeitgleich mit den obigen Zählschleifen auszufüllen, aber
        // der Klarheit halber sind die Anweisungen hier gesondert aufgeführt.

        for (int i = 0; i < zeilen; i++) { // Iteriere über Zeilen...
            
            for (int j = 0; j < spalten; j++) { // ...und Spalten des Datenfeldes
                System.out.print(" " + matrix[i][j]); // Gib Feldwert als Leerzeichen-begrenzten String in der Standardausgabe aus.
            }
            
            System.out.println(""); // Füge am Ende jeder Zeile einen Zeilenumbruch hinzu.
        }
        System.out.println(""); // Füge zum Abschluss einen zusätzlichen Zeilenumbruch hinzu.
        

        // === Ausgabe des Ergebnisses ===

        return lokaleDistanz; // Die zuletzt berechnete minimale Teildistanz entspricht der minimalen Editierdistanz
                              // der vollständigen Zeichenketten. Daher können wir sie hier als Rückgabewert zurückgeben.
        
    }
    
    public int minimum(int wert1, int wert2, int wert3) // Definiere eine neue Instanzmethode 'minimum' mit öffentlichen Zugriffsrechten.
                                                        // Aufgabe der Methode ist die Ermittlung des Minimalwertes dreier ganzer Zahlen.
                                                        //
                                                        // Dazu weist sie folgende Eigenschaften auf:
                                                        //  - Argumente: drei Variablen 'wert1', 'wert2', 'wert3' mit dem Datentyp 'int'
                                                        //  - Datentyp des Rückgabewertes: 'int'
    {   
        int out = wert1; // Deklariere eine Variable 'out' vom Datentyp 'int' und weise ihr den Wert von 'wert1' zu
        if (wert2 < out) { // Überprüfe mittels einer bedingten Anweisung, ob der Wert von 'wert2' kleiner als der von 'out' ist
            out = wert2;   // Falls ja, weise 'out' den neuen Wert 'wert2' zu.
        }
        if (wert3 < out) { // Wie zuvor, aber diesmal mit 'wert3'
            out = wert3;
        }
        return out; // Gib den Minimalwert 'out' als Rückgabewert zurück
    }
}
