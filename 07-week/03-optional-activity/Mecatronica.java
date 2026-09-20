/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Mecatronica extends Ingenieros {
     private String softwareDiseño;

     public Mecatronica(String nombre, String especialidad, int añosExperiencia, boolean estadoLaboral, String softwareDiseño){
         super(nombre, especialidad, añosExperiencia, estadoLaboral);
         this.softwareDiseño = softwareDiseño;
     }

     public void mostrarSoftware(){
         System.out.println("El/la ingeniero/a " + nombre + " con " + añosExperiencia + " años de experiencia, para su cargo de " + especialidad + " utiliza " + softwareDiseño);
     }
}
