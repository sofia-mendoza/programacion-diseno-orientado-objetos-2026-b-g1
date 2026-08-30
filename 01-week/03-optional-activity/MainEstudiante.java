public class MainEstudiante {
    public static void main(String[] args) {
        // Bloque de identificación exigido
        String fullName = "Sofía Mendoza";
        String githubUser = "sofia-mendoza";
        System.out.println("FULL_NAME: " + fullName + " | GITHUB_USER: " + githubUser);
        System.out.println("--------------------------------------------------");

        // Creación de dos objetos distintos de la clase Estudiante
        Estudiante estudiante1 = new Estudiante("Sofía Mendoza", "Ingeniería Mecatrónica", 4);
        Estudiante estudiante2 = new Estudiante("Carlos Gómez", "Ingeniería Industrial", 5);

        // Llamada al método presentarse() en cada uno
        estudiante1.presentarse();
        estudiante2.presentarse();
    }
}