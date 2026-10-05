
public class Gengar extends Pokemon implements InterfaceFantasma {

    public Gengar() {

    }
    
    @Override
    protected void atacarPlacaje(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void atacarRasguno(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void atacarMordisco(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void atacarPatada(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void atacarEscupir(){
        System.out.println("Gengar lanza un escupitajo de veneno.");
    }

    @Override
    public void atacarBolaSombra(){
        System.out.println("Gengar lanza una bola de sombra pesadilla.");
    }

    @Override
    public void atacarVeneno(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

}