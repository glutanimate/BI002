

public class VerketteListe
{
    private Listenelement anfang;

    public VerketteListe() {}
    
    public void add(char in) {
        Listenelement l = new Listenelement(in);
        if (anfang == null) {
            anfang = l;
        } else {
            Listenelement temp = anfang;
            while (temp.nachfolger() != null) {
                temp = temp.nachfolger(); // pointer wird immer neu zugewiesen
            }
            temp.setzeNachfolger(l);
        }
    }
    

}
