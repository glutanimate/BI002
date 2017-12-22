

public class Stack
{
    private Listenelement anfang;

    public Stack() {}
    
    public void push(char in) {
        Listenelement l = new Listenelement(in);
        if (anfang == null) {
            anfang = l;
        } else {
            l.setzeNachfolger(anfang);
            anfang = l;
        }
    }
    
    public char pull() {
        char out = anfang.gibNutzDaten();
        anfang = anfang.nachfolger();
        return out;
    }
    

}
