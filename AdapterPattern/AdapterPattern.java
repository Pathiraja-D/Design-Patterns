package AdapterPattern;

interface EuropeanDevice{
    void plugEuropean();
}

class AmericanOutlet{
    void socket(){
        System.out.println("American Type");
    }
}

class Adapter implements EuropeanDevice{
    private AmericanOutlet americanOutlet;

    public Adapter(AmericanOutlet americanOutlet) {
        this.americanOutlet = americanOutlet;
    }

    @Override
    public void plugEuropean(){
        System.out.println("Converting to american ");
        americanOutlet.socket();
    }
}



class AdapterPattern {
    public static void main(String[] args) {
        AmericanOutlet americanOutlet = new AmericanOutlet();
        EuropeanDevice laptop = new Adapter(americanOutlet);

        laptop.plugEuropean(); 
    }
}