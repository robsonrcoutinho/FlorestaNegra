import greenfoot.*;

/**
 * Esta classe é referente a um espinho,
 * @since Novembro, 2013.
 */
public class Spike extends Terrain{
    public Spike(int rotacao)
    {
       setRotation(rotacao);
    }
   
    public Spike()
    {
    }
    
    public void act(){
       possivelColisor=getOneIntersectingObject(Jogador.class);
       if(possivelColisor!=null)
            ((Jogador)possivelColisor).dano2(); 
    }
   
    
    private Actor possivelColisor; 
}
