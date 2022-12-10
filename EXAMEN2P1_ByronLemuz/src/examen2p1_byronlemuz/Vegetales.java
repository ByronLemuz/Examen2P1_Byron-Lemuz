import java.util.Random;

public class Vegetales {
    double precio;
    boolean sana;

    Random gen = new Random();

    Vegetales(double precio){
        this.precio = precio;
        if(gen.nextInt(10,20) == 5){
            this.sana = true;
        }
        this.sana = false;
    }

}
