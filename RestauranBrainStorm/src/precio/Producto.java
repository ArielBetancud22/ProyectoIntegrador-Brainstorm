
package precio;

public abstract class Producto {

  //Atributos
  private String nombre;
  private double precioUnit;
  //private int cantStock;
  private boolean disponible = false;
  public static int dimesionArray;
  
  
  //Constructores
  public Producto() { }
  public Producto(String nombre, double precioUnit, boolean disponible) {
    this.nombre   = nombre;
    this.precioUnit = precioUnit;
    this.disponible = disponible;
    
    dimesionArray++;//Se obtiene con esta variable la dimensión del array. Según número de instancias del constructor
  }
  
  
  //Metodos
  @Override
  public String toString() {
    return  "Combo: "      +this.getNombre()+    "\n";
          // + "Precio unidad: $" +this.getPrecioUnit()+  " \n";
  }
  
  //Get y Set
  public String getNombre() {
    return this.nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public double getPrecioUnit() {
    return this.precioUnit;
  }
  public void setPrecioUnit(double precioUnit) {
    this.precioUnit = precioUnit;
  }
  /*
  public boolean isDisponible() {
    if(getCantStock()>0) this.disponible = true;
    return this.disponible;
  }
  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }*/

}

