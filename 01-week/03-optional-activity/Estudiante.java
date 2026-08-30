public class Estudiante {
    // Atributos (estado)
    private String nombre;
    private String programa;
    private int semestre;

    // Constructor
    public Estudiante(String nombre, String programa, int semestre) {
        this.nombre = nombre;
        this.programa = programa;
        this.semestre = semestre;
    }

    // Método que imprime la presentación (comportamiento)
    public void presentarse() {
        System.out.println("Hola, mi nombre es " + nombre + ", estudio " + programa + " y voy en " + semestre + "° semestre.");
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}