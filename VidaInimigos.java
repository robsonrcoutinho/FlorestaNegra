import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente a vida de todas
 * os inimigos que não sejam chefões.
 * 
 * @since Novembro 2013.
 */
public class VidaInimigos extends Vidas
{
    /**
     * Nesse construtor as imagens do array img 
     * são redimensionadas
     */   
    public VidaInimigos(){
        for(int x=0;x<img.length;x++)
            img[x].scale(100, 15);
            setPontosDeVida(5);
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
      setImage(img[getPontoVida()]);  
    }
    
     /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act(){
        setImage(img[getPontoVida()]);
    }
    
   private GreenfootImage[] img ={
    new GreenfootImage("barraMonstro0.png"),new GreenfootImage("barraMonstro1.png"),new GreenfootImage("barraMonstro2.png"),new GreenfootImage("barraMonstro3.png"),
    new GreenfootImage("barraMonstro4.png"),new GreenfootImage("barraMonstro5.png")};
}
