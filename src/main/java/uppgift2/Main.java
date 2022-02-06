package uppgift2;

interface Bilfabrik{
    void model();
}

class Audi implements Bilfabrik{

    @Override
    public void model() {
        System.out.println("Detta är en Audi");
    }
}

class Bmw implements Bilfabrik{

    @Override
    public void model(){
        System.out.println("Detta är en BMW");
    }
}

public class Main {
    public static void main(String[] args) {
        Audi nyBil1 = new Audi();
        Bmw nuBil2 = new Bmw();

        nyBil1.model();
        nuBil2.model();

    }
}
