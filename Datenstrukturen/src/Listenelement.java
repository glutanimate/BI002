

public class Listenelement
{
    private char nutzdaten;
    private Listenelement nachfolger;

    public Listenelement()
    {
    }
    
    public Listenelement(char input)
    {
        nutzdaten = input;
    }
    
    public void setzeNachfolger(Listenelement nf) {
        nachfolger = nf;
    }
    
    public Listenelement nachfolger() {
        return nachfolger;
    }
    
    public char gibNutzDaten() {
        return nutzdaten;
    }

}
