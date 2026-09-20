/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Industrial extends Ingenieros {
     private int proveedoresControlados;

    public Industrial(String nombre, String especialidad, int añosExperiencia, boolean estadoLaboral, int proveedoresIniciales){
        super(nombre, especialidad, añosExperiencia, estadoLaboral);
        this.proveedoresControlados = proveedoresIniciales;
    }

    public void contratarProveedor() {
        this.proveedoresControlados++; // Suma 1 al contador
        System.out.println("Se ha asignado un nuevo proveedor a " + getNombre() +
                ". Total a cargo: " + this.proveedoresControlados);
    }

    public void despedirProveedor() {
        if (this.proveedoresControlados > 0) {
            this.proveedoresControlados--; // Resta 1 al contador
            System.out.println("Se ha retirado un proveedor. Total a cargo: " + this.proveedoresControlados);
        } else {
            System.out.println("No se puede quitar nada. El ingeniero ya tiene 0 proveedores.");
        }
    }
}
