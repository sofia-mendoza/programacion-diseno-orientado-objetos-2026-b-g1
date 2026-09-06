/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Termostato {
        // 1. Identidad inmutable (solo lectura)
        private final String id;
        private String ubicacion;
        private double temperatura;

        // Constantes que definen la INVARIANTE de dominio (Rango permitido)
        public static final double TEMP_MIN = 10.0;
        public static final double TEMP_MAX = 30.0;

        // 3. Constructor completo con validación de la invariante
        public Termostato(String id, String ubicacion, double temperatura) {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("El ID no puede estar vacio.");
            }
            // Validación para proteger la invariante desde la construcción
            if (temperatura < TEMP_MIN || temperatura > TEMP_MAX) {
                throw new IllegalArgumentException("La temperatura inicial debe estar entre " + TEMP_MIN + "°C y " + TEMP_MAX + "°C.");
            }
            this.id = id;
            this.ubicacion = (ubicacion != null) ? ubicacion : "Sin ubicacion";
            this.temperatura = temperatura;
        }

        // 3. Constructor reducido que delega con this() (Inicia por defecto en 20.0°C)
        public Termostato(String id, String ubicacion) {
            this(id, ubicacion, 20.0);
        }

        // 2. Getter para la identidad 'id' (Sin Setter)
        public String getId() {
            return id;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }

        public double getTemperatura() {
            return temperatura;
        }

        // 4. Operaciones de dominio validadas (Protegen la invariante)
        public void subirTemperatura(double delta) {
            if (delta <= 0) {
                throw new IllegalArgumentException("El incremento debe ser mayor a 0.");
            }
            if (this.temperatura + delta > TEMP_MAX) {
                throw new IllegalStateException("Operacion rechazada: Excede la temperatura maxima permitida (" + TEMP_MAX + "°C).");
            }
            this.temperatura += delta;
        }

        public void bajarTemperatura(double delta) {
            if (delta <= 0) {
                throw new IllegalArgumentException("El decremento debe ser mayor a 0.");
            }
            if (this.temperatura - delta < TEMP_MIN) {
                throw new IllegalStateException("Operacion rechazada: Es menor a la temperatura minima permitida (" + TEMP_MIN + "°C).");
            }
            this.temperatura -= delta;
        }

        // 5. Sobrescribir toString()
        @Override
        public String toString() {
            return "Termostato{" +
                    "id='" + id + '\'' +
                    ", ubicacion='" + ubicacion + '\'' +
                    ", temperatura=" + temperatura + "°C" +
                    '}';
        }

        // 5. Implementación de equals() basada en la identidad 'id'
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Termostato otro = (Termostato) o;
            if (this.id == null) {
                return otro.id == null;
            }
            return this.id.equals(otro.id);
        }

        // 5. Implementación de hashCode()
        @Override
        public int hashCode() {
            return (this.id != null) ? this.id.hashCode() : 0;
        }
    }

