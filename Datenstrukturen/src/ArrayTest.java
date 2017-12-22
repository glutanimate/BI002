
public class ArrayTest
{
    private int[][] intFeld;

    public ArrayTest()
    {
        intFeld = new int[20][10]; // definiere zweidimensionalen Array, der jeweils int Werte beherbergt
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 11; j++) {
                intFeld[i-1][j-1] = i + j;
            }
        }
    }
   

    public int gibtHeraus(int position1, int position2) {
        return intFeld[position1][position2]; // gebe Wert an Indexposition aus
    }
    
    public void legHinein(int input, int position1, int position2) {
        intFeld[position1][position2] = input; // setze Wert an Indexposition
    }
    
    
}
