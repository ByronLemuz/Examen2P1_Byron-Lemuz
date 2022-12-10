import java.util.ArrayList;

public class Granja {
    String nombre;
    ArrayList<Vaca> listaVacas = new ArrayList<Vaca>();
    ArrayList<Conejo> listaConejos = new ArrayList<Conejo>();
    ArrayList<Vegetales> listaVegetales = new ArrayList<Vegetales>();

    double monets;
    Granja(String nombre,double monets){
        this.nombre = nombre;
        this.monets = monets;

    }

     void printVacas(){

    }
    void printConejos(){

    }

    void añadirVaca(Vaca vaca){
        this.listaVacas.add(vaca);
        System.out.println("La vaca "+vaca.nombre+" ha sido añadadia a la granja");
    }

    void añadirConejo(Conejo conejo){
        this.listaConejos.add(conejo);
        System.out.println("El conejo "+conejo.nombre+" ha sido añadido a la granja");
    }
    void añadirVegetal(Vegetales vegetal){
        this.listaVegetales.add(vegetal);
    }

    int getSizeVacas(){
        return this.listaVacas.size();
    }

    int getSizeConejos(){
        return this.listaConejos.size();
    }

    int getSizeVegetales(){
        return this.listaVegetales.size();
    }

    void print(){
        System.out.println("Mostrando vacas...");
        for(int i = 0; i<this.getSizeVacas(); i++){
            System.out.println(this.listaVacas.get(i));
        }
        System.out.println("Mostrando conejos...");
        for(int i = 0; i<this.getSizeConejos(); i++){
            System.out.println(this.listaConejos.get(i));
        }
    }
}
