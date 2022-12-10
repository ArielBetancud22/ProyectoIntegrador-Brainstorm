package precio;
//import leer.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Arrays;

public class RestauranBrainStorm {
    //Usamos Calendar para obtner la fecha actual
    static Calendar Fecha = Calendar.getInstance();
    public static String [] NC = new String [3];
    public static int [] DM = new int [5];

    public static void main(String[] args) throws InterruptedException {
        Scanner tec = new Scanner(System.in);
        int formapago;
        int cantPersonas = 0;
        double descuento;
        double total = 0;
        int cont;
        
        String nombrePersona[] = new String[cantPersonas];
        //Case 4, definir variables para reservas por fecha
        int dia, mes;
        dia = Fecha.get(Calendar.DATE);
        mes = Fecha.get(Calendar.MONTH);
        String ID;
        int opcion3 = 0;
       
        
        /*
     * Se pedirá la cantidad de artículos que elija el cliente y se dará el precio a pagar según esa lo elegido. 
         */

        System.out.println(" ");
        System.out.println("\tBienvenidos al restaurante BrainStorm");
        System.out.println(" ");
        System.out.println("\t--------------------------------------");
        System.out.println("\t-Le recordamos que tiene que reservar-");
        System.out.println("\t-con antipacion para mesas con mas de-");
        System.out.println("\t------------seis personas-------------");
        System.out.println("\t-------------!GRACIAS¡----------------");
        System.out.println("\t--------------------------------------");
        System.out.println(" ");
        
        boolean next =true;
        boolean continuar = true;
        int lecturaProducto, lecturaCantidad; //Variables para seleccionar el producto y la cantidad que se quiere comprar

        //Se instancian y cargan los productos
        Producto plato1 = new Combos("Milanesas con pure + Gasosa 500ml ----------------$580", 580.00, true);
        Producto plato2 = new Combos("Ravioles con salsa blanca + Gaseosa 500ml --------$600", 600.00, true);
        Producto plato3 = new Combos("Pizza de panceta para 6 personas + Andes 1L ------$800", 800.00, true);
        Producto plato4 = new Combos("Lomo simple + Gaseosa 500ml ----------------------$700", 700.00, true);
        Producto plato5 = new Combos("Parrilla libre + Bebida a eleccion ---------------$1500", 1500.00, false);
        

        //Se crea el array "catálogo" para contener los productos. Su dimensión viene del número de veces que se
        //instancia el contructor de Producto
        Producto catalogo[] = new Producto[Producto.dimesionArray];
        //Se crea el objeto gestion para trabajar (mostrar, vender, y mostrar caja)
        Gestion gestion = new Gestion();

        //Se rellena el array catálogo
        catalogo[0] = plato1;
        catalogo[1] = plato2;
        catalogo[2] = plato3;
        catalogo[3] = plato4;
        catalogo[4] = plato5;
        

        do {
            //Mostramos las opciones principales que el usuario puede seleccionar
            System.out.println(" ");
            System.out.println("\tIntroduzca la opción que desea realizar: ");
            System.out.println("\t1. Mostrar productos");
            System.out.println("\t2. Ordenar combos");
            System.out.println("\t3. Mostrar total");
            System.out.println("\t4. Reserva\n");
            System.out.println("SALIR --> Pulse cualquier otro número");
            System.out.println("--------------------------------------------");
            System.out.print("Opcion: ");

            switch (Leer.datoInt()) {
                case 1:
                    //Mostramos el menù disponible
                    gestion.mostrarProductos(catalogo);
                    Thread.sleep(1 * 1000);
                    break;
                case 2:
                    do {
                        System.out.println(" ");
                        System.out.println("Ingresar cantidad de personas: ");
                        cantPersonas = tec.nextInt();
                        if (cantPersonas > 6) {
                            System.out.println("Ingrese cantidad permitida");
                        }
                    } while (cantPersonas > 6);

                    for (int i = 0; i < cantPersonas; i++) {

                        nombrePersona = new String[cantPersonas];

                        System.out.println("-> Persona " + (i + 1));
                        System.out.println("-> Nombre: ");
                        nombrePersona[i] = Leer.dato();
                        //tec.nextLine();
                        do {
                            System.out.println(" ");
                            System.out.println(nombrePersona[i] + " ¿Que combos desea ordenar?\n");
                            gestion.mostrarNombreProductos(catalogo);
                            Thread.sleep(1 * 1000);
                            System.out.println("Opcion: ");
                            lecturaProducto = Leer.datoInt();
                            if (lecturaProducto > 5) {
                                System.out.println("\nPor favor ingrese un combo disponible");
                            }
                        } while (lecturaProducto > 5);
                        System.out.println("¿Cuántas unidades desea ordenar?");
                        lecturaCantidad = Leer.datoInt();
                        //Se carga el producto y la cantidad solicitada por el usuario
                        gestion.comprarProducto(catalogo, lecturaProducto, lecturaCantidad);
                    }
                    break;
                case 3:
                    if (cantPersonas == 0) {
                        System.out.println(" ");
                        System.out.println("Por favor primero ingrese su nombre y pedido");
                        System.out.println(" ");
                        Thread.sleep(1 * 1000);
                    } else {
                        System.out.println("$ " + gestion.mostrarCaja());//En gestion.mostrarCaja se suman la lecturaProducto y lecturaCantidad
                        System.out.println(" ");
                        System.out.println("[1]Desea pagar \n[2]Seguir continuar con los pedidos?");
                        cont = tec.nextInt();
                        if (cont == 1) {
                            System.out.println(" ");
                            System.out.println("Como desea abonar: ");
                            System.out.println("Elija un metodo de pago(1-3)\n");
                            // Mostramos las opciones de pago al usuario
                            System.out.println("(1).Efectivo 15% de descuento");
                            System.out.println("(2).Tarjeta 10% de descuento");
                            System.out.println("(3).Billetera virtual 8% de descuento\n");
                            do {
                                System.out.println("Digite su opcion");
                                //Solicitamos el metodo elegido
                                formapago = tec.nextInt();
                                if (formapago > 3) {
                                    System.out.println("Opcion incorrecta");
                                }
                            } while (formapago > 3);
                            descuento = 0;
                            switch (formapago) {// Segun la opcion seleccionada aplicar el descuento correspondiente
                                case 1:
                                    descuento = gestion.mostrarCaja() * 0.15;
                                    total = gestion.mostrarCaja() - descuento;
                                    
                                    break;
                                case 2:
                                    descuento = gestion.mostrarCaja() * 0.10;
                                    total = gestion.mostrarCaja() - descuento;
                                    break;
                                case 3:
                                    descuento = gestion.mostrarCaja() * 0.08;
                                    total = gestion.mostrarCaja() - descuento;
                                    break;

                            }
                            // Mostrar total a pagar
                            System.out.println("El total a pagar es de $" + total);
                            Thread.sleep(2 * 1000);
                            System.out.println(""); // no hay forma directa de borrar la consola en Java
                            // Animacion
                            System.out.println("\t...Procesando el pago...");
                            Thread.sleep(2 * 1000);
                            System.out.println(""); // no hay forma directa de borrar la consola en Java
                            // Mensaje de agradecimiento
                            System.out.println("Pago realizado. Muchas gracias por su visita, lo esperamos en otra ocasión.");
                        }
                    }
                    break;
                
                case 4:
                    System.out.println("1) Reservar"
                            + "\n2) Mostrar reserva"
                            + "\n3) Eliminar reservacion\n");
                    System.out.println("SALIR --> Pulse cualquier otro número");
            System.out.println("--------------------------------------------");
            System.out.print("Opcion: ");
                    opcion3 = tec.nextInt();
                    switch (opcion3){
                        case 1: 
                            //A partir de esta linea se llenaran los array NC y DM
                            System.out.println("\nIngrese su nombre");
                            NC[0] = Leer.dato();
                            System.out.print("\nIngrese su numero de contacto: ");
                            NC[1] = Leer.dato();;
                            do{
                                //Si se ingresa un dia anterior al dia actual del ordenador, pedira que vuelva a ingresar el dia
                                System.out.println("\nIngrese el dia de reserva: ");
                                DM [0]= tec.nextInt();
                                if (DM [0] < dia){
                                    System.out.println("\nIngrese un dia valido\n");
                                }
                                //Si se ingresa un mes anterior al mes actual del ordenador, pedira que vuelva a ingresar el mes
                                System.out.println("\nIngrese el mes a reservar:");
                                DM [1]= tec.nextInt();
                                if (DM [1] < mes){
                                    System.out.println("Ingrese un mes valido\n");
                                }
                            //Esto se repetira hasta que el ingreso sea correcto
                            }while (DM [0] < dia || DM [1] < mes);
                            
                            //Pedimos que dijite las horas que esten disponibles
                            do{
                                System.out.println("\nIngresa la hora deseada (formato de 24hs): ");
                                DM [2]=tec.nextInt();
                                if (DM [2] > 22 || DM [2] < 7){
                                    System.out.println("\nIngrese un horario disponible\n");
                                }
                            //Se repetira mientras el usuario ingrese horas fuera de comercio
                            } while (DM [2] > 22 || DM [2] < 7);
                            System.out.println("\nIngrese los minutos deseados: ");
                            DM [3]=tec.nextInt();
                            System.out.println("Ingrese la cantidad de sillas a usar: ");
                            DM[4] = tec.nextInt();
           
                            break;
                        case 2:
                            // Si NC esta vacio pedira que primero realice una reservacion
                            if(NC[1] == null){
                                System.out.println("Por favor, primero debe realizar la reserva");
                                Thread.sleep(1 * 1000);
                            }
                            //Mostramos las matrices en el oreden que fueron llenadas
                            System.out.println("Cliente: " + NC[0]);
                            System.out.println("Numero: " + NC[1]);
                            System.out.println("Su reserva es el: " + DM[0] + "/" + DM[1]);
                            System.out.println("A las: " + DM[2] + ":" + DM[3] + " hs");
                            System.out.println("Cantidad de sillas reservadas: " + DM[4]);
                            Thread.sleep(1 * 1000);
                            break;
                        case 3: 
                            System.out.println("Ingrese su numero de contacto");
                            ID = Leer.dato();
                            //Si el ID es diferente del numero de contacto pedido en la NC dara incorrecto
                            if (ID != NC[1]){
                                System.out.println("Numero incorrecto");
                            }
                            //Si el Id es correcto se procedera a elimarse
                                if (NC[1] == null){
                                } else {
                                if (NC[1].contains(ID)){
                                    System.out.println("\n\nReserva eliminada con exito ");
                                    Arrays.fill(NC, "0");
                                    for (int i = 0; i < 3; i++){
                                        
                                        System.out.print(NC[i]);
                                    }
                                    Arrays.fill(DM, 0);
                                    for (int j = 0; j < 5; j++){
                                        System.out.print(DM[j]);
                                        
                                    }

                                }
                             }
                               Thread.sleep(1 * 1000); 
                            
                            break;
                        default:
                            next = false;
                        }
                     break;       
   
                default:
                    //Se sale del programa
                    continuar = false;
            }

        } while (continuar);

        System.out.println("---- Gracias por usar la aplicación. ----");

    }
}
