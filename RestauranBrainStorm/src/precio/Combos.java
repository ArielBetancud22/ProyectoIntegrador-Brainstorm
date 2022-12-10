
package precio;

public class Combos extends Producto {

  //Atributo
  
  //Constructor
  public Combos() { }
  public Combos(String nombre, double precioUnit, boolean disponible) {
    super(nombre, precioUnit, disponible);
  }
  
  
  //Metodo
  @Override
  public String toString() {
    return  "COMBOS DISPONIBLES\n"+
        super.toString();
  }
}  
