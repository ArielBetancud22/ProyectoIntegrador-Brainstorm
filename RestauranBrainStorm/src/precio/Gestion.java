
package precio;

public class Gestion {
    //Atributes
  private Producto productos[] = null;
  private double caja;
  
  //Constructores
  public Gestion() { }
  public Gestion(Producto[] productos) {
    this.productos = productos;
  }
  
  //Metodos
  public Producto[] cargarProductos() {

    return productos;
  }
  
  public void mostrarProductos(Producto[] productos) { 
      for (int i = 0; i < productos.length; i++) {
        System.out.print(productos[i]);
      }
  }
  public void mostrarNombreProductos(Producto[] productos) { 
      for (int i = 0; i < productos.length; i++) {
        System.out.println(i+1 +" "+productos[i].getNombre()+"n");
      }
      System.out.println(" ");
  }   
  public double comprarProducto(Producto[] productos, int num, int cantidadUnidades) {
   for (int i = 0; i < productos.length; i++){
       return caja+=cantidadUnidades*productos[num-1].getPrecioUnit();
   }
    return caja;
  }
  public double mostrarCaja() {
    //System.out.print("El total de la caja es ");
    //caja=(caja*100);
    return caja;///100;
  } 

}

