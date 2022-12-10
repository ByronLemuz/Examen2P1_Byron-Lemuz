import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*
    Final del juego:
    - El administrador de la granja comienza a sentirse mal después de un día cualquiera en la granja,
    en los días siguientes empieza a notar que una de las vacas comienza a verse cansada y sin apetito, por lo que
    no pasta y baja de peso considerablemente. La salud del administrador parece ir en el mismo rumbo, al cabo de unas semanas comienza
    a sentirse igual y acude a un médico para poder obtener la asistencia médica correspondiente.
    EL doctor le comenta que tienen muy poca información sobre la enfermedad que presente este y que se presume que fue trasmitida
    de un mamífero, para tal enfermedad debido a su rareza y falta de información, no es posible obtener cura y en la medida en que avance,
    el estado de los riñones se deteriore hasta causar la muerte.
    El administrador, consulta con varios anciones del pueblo en el que vive y uno de estos, le comenta que la tradición oral del pueblo narra que una vez
    un popular terrateniente padecía los mismos síntomas, y que se curó gracias a una plantación de vegetales de la que se presumía que tenía propiedades únicas,
    por esto, el administrador de la granja empieza a cultivar muchos vegetales, con la esperanza de dar con especies similares a las de aquella plantación con la que se salvó el terrateniente
    de su pueblo.

    - La enfermedad tendrá una duración aleatoria de días (100 y 365)
    - La enfermedad aparecerá entre los días 15 y 30
    - La probabilidad de que la plantación sea la salvación del administrador es 100/10, de cada 100 vegetales 10 pueden salvarte.









 */
public class Main {
    public static void main(String[] args) {
        Granja migranja = new Granja("MI HUERTO",1000);
        Random gen = new Random();
        System.out.println("Bienvenido a la granja:"+ migranja.nombre);
        Scanner lector = new Scanner(System.in);
        int dia = 0;
        boolean running = true;
        int tiempoRestanteCosechas = 5;
        ArrayList<Vegetales> cosechaTemporal = new ArrayList<Vegetales>();

        int duracionEnfermedad = gen.nextInt(100,365);
        int aparicionEnfermedad = gen.nextInt(15,30);

        do{
            if(dia == aparicionEnfermedad){
                System.out.println("*** COMIENZAS A SENTIRTE MAL MISTERIOSAMENTE, SE PRESUME QUE ESTÁS ENFERMO ***");
                System.out.printf("*** TIENES %d DÍAS HASTA QUE ENCUENTRES LA FORMA DE CURARTE ***\n",duracionEnfermedad);
            }
            int opc = Menu();
            System.out.println("********DÍA: "+dia+" ********");
            if (cosechaTemporal.size() == 0){
                System.out.println("No tienes cosechas!");
            }
            else{

                System.out.printf("Faltan %d días para que estén listas tus cosechas\n",tiempoRestanteCosechas);
            };
            if(tiempoRestanteCosechas == 0 && cosechaTemporal.size() != 0){
                System.out.println("******** YA PUEDES RECOGER TUS COSECHAS ******");
            }
            switch(opc){
                case 1:
                    System.out.println("Cuántas cosechas desea plantar?: ");
                    int cantidadCosechas = lector.nextInt();
                    tiempoRestanteCosechas = 5;
                    System.out.println("Plantando cosechas...");
                    for(int i = 0; i<cantidadCosechas; i++){
                        cosechaTemporal.add(i,new Vegetales(100));
                    }
                    System.out.println("Podrás recogerlas en 5 días!");

                    break;
                case 2:
                    if(cosechaTemporal.size() > 0 && tiempoRestanteCosechas == 0){
                        System.out.println("Recogiendo cosechas....");
                        int cosechas = cosechaTemporal.size();
                        for(int i = 0; i<cosechas; i++){
                            migranja.añadirVegetal(cosechaTemporal.get(i));

                        }

                        cosechaTemporal.clear();
                    }
                    else{
                        System.out.println("Todavía no puedes recoger las cosechas");
                    }

                    break;
                case 3:
                    System.out.println("Cantidad de dinero actual :"+migranja.monets);
                    System.out.printf("Qué animales deseas ?\n" +
                            "1.Conejos -> 150 monets\n" +
                            "2.Vacas -> 350 monets\n");
                    int choice = lector.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Cuántos conejos deseas?");
                            int conejos = lector.nextInt();
                            int costoConejos = 150*conejos;
                            lector.nextLine();
                            if(costoConejos <= migranja.monets){
                                System.out.println("Realizando compra...");
                                migranja.monets -= costoConejos;
                                for(int i = 0; i<conejos; i++){
                                    System.out.println("Ingrese nombre de su nuevo conejo:");
                                    String nombre = lector.nextLine();
                                    migranja.añadirConejo(new Conejo(nombre,150));
                                }
                                System.out.println("Tu nuevo saldo es :"+migranja.monets);
                            }
                            else{
                                System.out.println("No tienes el dinero suficiente para comprar esta cantida de conejos;");
                            }
                            break;
                        case 2:
                            System.out.println("Cuántas vacas deseas?");
                            int vacas = lector.nextInt();
                            lector.nextLine();
                            int costoVacas = 350*vacas;
                            if(costoVacas <= migranja.monets){
                                System.out.println("Realizando compra...");
                                migranja.monets-=costoVacas;
                                for(int i = 0; i<vacas; i++){
                                    System.out.println("Ingrese el nombre de su vaca");
                                    String nombre = lector.nextLine();
                                    migranja.añadirVaca(new Vaca(nombre,350));
                                }
                                System.out.println("Tu nuevo saldo es :"+migranja.monets);
                            }
                            else{
                                System.out.println("No tienes el dinero suficiente para comprar esta cantidad de vacas!");
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("--- ANIMALES DE GRANJA ---");
                    System.out.printf("Tienes %d Vegetales\n",migranja.getSizeVegetales());
                    System.out.printf("Tienes %d Vacas\n",migranja.getSizeVacas());
                    System.out.printf("Tienes %d Conejos\n",migranja.getSizeConejos());
                    System.out.printf("Tienes %f Monetes\n",migranja.monets);

                    System.out.printf("Selecciona\n1.-Vegetales\n2.-Conejos\n3.-Vacas\n");
                    int opcion = lector.nextInt();
                    switch (opcion){
                        case 1:
                            System.out.println("Mostrando vacas en la granja...");
                            for(int i = 0; i< migranja.getSizeVacas(); i++){
                                System.out.println(migranja.listaVacas.get(i));
                            }
                            if(migranja.getSizeVacas() > 0){
                                System.out.println("Ingrese la cantidad a vender");
                                int cantidadVenta = lector.nextInt();
                                if(cantidadVenta <= migranja.getSizeVacas()) {
                                    for (int i = 0; i < cantidadVenta; i++) {
                                        migranja.listaVacas.remove(i);
                                    }
                                    System.out.printf("\nSe han vendido %d vacas ",cantidadVenta);
                                    migranja.monets += cantidadVenta*350;
                                    System.out.println("La nueva cantidad de monets es:"+migranja.monets);
                                }
                                else{
                                    System.out.println("No tienes esa cantidad de vacas disponibles");
                                }
                            }
                            else{
                                System.out.println("No tienes vacas para vender!");
                            }
                            break;
                        case 2:
                            System.out.println("Mostrando conejos en la granja...");
                            for(int i = 0; i< migranja.getSizeConejos(); i++){
                                System.out.println(migranja.listaConejos.get(i));
                            }
                            if(migranja.getSizeConejos() > 0){
                                System.out.println("Ingrese la cantidad a vender");
                                int cantidadVenta = lector.nextInt();
                                if(cantidadVenta <= migranja.getSizeConejos()) {
                                    for (int i = 0; i < cantidadVenta; i++) {
                                        migranja.listaConejos.remove(i);
                                    }
                                    migranja.monets += cantidadVenta*150;
                                    System.out.printf("\nSe han vendido %d Conejos\n ",cantidadVenta);
                                    System.out.println("La nueva cantidad de monets es:"+migranja.monets);
                                }
                                else{
                                    System.out.println("No tienes esa cantidad de conejos disponibles");
                                }
                            }
                            else{
                                System.out.println("No tienes conejos para vender!");
                            }
                            break;
                        case 3:

                            if(migranja.getSizeVegetales() > 0){
                                System.out.println("Ingrese la cantidad a vender");
                                int cantidadVenta = lector.nextInt();
                                if(cantidadVenta <= migranja.getSizeVacas()) {
                                    for (int i = 0; i < cantidadVenta; i++) {
                                        migranja.listaVacas.remove(i);
                                    }
                                    System.out.printf("\nSe han vendido %d Vegetales ",cantidadVenta);
                                    migranja.monets = cantidadVenta*100;
                                    System.out.println("La nueva cantidad de monets es:"+migranja.monets);
                                }
                                else{
                                    System.out.println("No tienes esa cantidad de Vegetales disponibles");


                                }
                            }
                            else{
                                System.out.println("No tienes Vegetales para vender!");
                            }
                    }
                    break;
                case 5:
                    System.out.println("Durmiendo...");
                    break;
                case 6:
                    System.out.println("Fin del juego...");
                    running = false;
                    break;

            }
            if(cosechaTemporal.size() != 0 && tiempoRestanteCosechas>0){
                tiempoRestanteCosechas--;
            }
            else{
                tiempoRestanteCosechas = 0;
            }
            if(dia > aparicionEnfermedad){

            }
            System.out.println("<----------- FIN DEL DÍA --------->");
            dia++;
        }while(running);



    }
    public static int Menu(){
        Scanner lector = new Scanner(System.in);
        System.out.printf("Qué desea hacer?\n1.-Plantar Cosechas\n2.-Cosechar las cosechas\n3.-Conseguir animales\n4.-Vender Cosas\n5.-Dormir\n6.-Salir\n");
        int opc = lector.nextInt();
        return opc;
    }
}