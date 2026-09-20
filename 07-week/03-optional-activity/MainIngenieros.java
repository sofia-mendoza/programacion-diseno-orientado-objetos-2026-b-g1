/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class MainIngenieros {

     public static void main (String[] args){

         Mecatronica ingenieroMecatronica = new Mecatronica("Sofía", "automatización", 5, true, "TIA Portal");
         ingenieroMecatronica.trabajar();
         ingenieroMecatronica.mostrarSoftware();


         Industrial ingenieroIndustrial = new Industrial("Carlos", "logística y cadena de suminsitro", 2, true, 5);
         ingenieroIndustrial.trabajar();
         ingenieroIndustrial.contratarProveedor();
         ingenieroIndustrial.contratarProveedor();
         ingenieroIndustrial.despedirProveedor();


         EnergiasRenovables ingenieroEnergiasRenovables = new EnergiasRenovables("Daniel", "transición energética", 7, false);
         ingenieroEnergiasRenovables.trabajar();
         ingenieroEnergiasRenovables.registrarProyectoLimpio(0.0);

     }

}
