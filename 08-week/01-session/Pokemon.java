public abstract class Pokemon {
    protected int numPokedex;
    protected String nombre;
    protected double peso;
    protected String sexo;
    protected int temporada;
    protected double altura;

    protected abstract void atacarPlacaje();
    protected abstract void atacarRasguno();
    protected abstract void atacarMordisco();
    protected abstract void atacarPatada();
    protected abstract void atacarEscupir();
    
}