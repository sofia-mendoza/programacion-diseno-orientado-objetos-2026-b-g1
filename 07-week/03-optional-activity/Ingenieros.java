/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Ingenieros {

     protected String nombre;
     protected String especialidad;
     protected int añosExperiencia;
     protected boolean estadoLaboral;

     public Ingenieros(String nombre, String especialidad, int añosExperiencia, boolean estadoLaboral){
          this.nombre = nombre;
          this.especialidad = especialidad;
          this.añosExperiencia = añosExperiencia;
          this.estadoLaboral = estadoLaboral;
     }

     // Dentro de la clase Ingeniero
     public String getNombre() {
          return this.nombre; // Retorna el atributo privado nombre
     }


     public void trabajar() {
          if (estadoLaboral){
               estadoLaboral = true;
               System.out.println("El/la ingeniero/a " + nombre + " se encuentra empleado/a.");
          }
          else {
               System.out.println("El/la ingeniero/a " + nombre + " se encuentra desempleado/a.");
          }
     }
}
