public class Vaca {

    String nombre;
    double precio;

    Vaca(String nombre,double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "*VACA* Nombre:"+this.nombre+" Precio:"+this.precio+"\n";
    }
}
