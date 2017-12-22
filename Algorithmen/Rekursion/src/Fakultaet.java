
public class Fakultaet
{

    public static void Fakultaet() {}
    
    public static int fakultaet(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (n * fakultaet(n - 1));
        }
    }

}
