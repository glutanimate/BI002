

public class Queue
{
    private Listenelement anfang;
    private Listenelement ende;

    public Queue() {}
    
    public void enqueue(char in) {
        Listenelement l = new Listenelement(in);
        if (anfang == null) {
            anfang = l;
        } else {
            ende.setzeNachfolger(l);
        }
        ende = l;
    }
    
    public char dequeue() {
        Listenelement l = anfang;
        anfang = anfang.nachfolger();
        return l.gibNutzDaten();
    }
    

}
