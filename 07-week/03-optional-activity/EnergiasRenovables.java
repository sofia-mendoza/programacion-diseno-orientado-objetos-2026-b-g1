/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class EnergiasRenovables extends Ingenieros {
     private double huellaCarbonoMitigada;

    public EnergiasRenovables(String nombre, String especialidad, int añosExperiencia, boolean estadoLaboral){
        super(nombre, especialidad, añosExperiencia, estadoLaboral);
        this.huellaCarbonoMitigada = 0.0;

    }

    public void registrarProyectoLimpio(double toneladasAhorradas) {
        if (toneladasAhorradas > 0) {
            this.huellaCarbonoMitigada += toneladasAhorradas; // Acumula las toneladas

            System.out.println("¡Proyecto ecológico exitoso!");
            // Eliminamos la mención a la fuente de energía del mensaje
            System.out.println("El Ing. " + getNombre() + " ha mitigado " + toneladasAhorradas + " toneladas de CO2.");
            System.out.println("Total histórico reducido por este ingeniero: " + this.huellaCarbonoMitigada + " toneladas.");
        } else {
            System.out.println("Error: Las toneladas mitigadas deben ser un valor positivo.");
        }
    }
}
