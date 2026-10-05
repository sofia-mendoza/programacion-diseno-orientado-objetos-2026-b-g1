package base;

/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public abstract class Pokemones {
    protected int numPokedex;
    protected String nombre;
    protected double peso;
    protected String sexo;
    protected int temporada;
    protected double altura;

    // Constructor vacío
    public Pokemones() {
    }

    // Constructor completo
    public Pokemones(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.peso = peso;
        this.sexo = sexo;
        this.temporada = temporada;
        this.altura = altura;
    }

    // Métodos abstractos generales (ataques básicos que todos pueden aprender/hacer)
    public abstract void atacarPlacaje();
    public abstract void atacarMordisco();
    public abstract void atacarAraniazo();

    // Getters y Setters
    public int getNumPokedex() { return numPokedex; }
    public void setNumPokedex(int numPokedex) { this.numPokedex = numPokedex; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public int getTemporada() { return temporada; }
    public void setTemporada(int temporada) { this.temporada = temporada; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
}
