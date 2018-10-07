import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe representa a vida de flora.
 * 
 
 * @since Novembro, 2013.
 */
public class VidaFlora extends Vidas
{
    /**
     * Nesse construtor as imagens do array img 
     * são redimensionadas
     */   
    public VidaFlora(){
        for(int x=0;x<img.length;x++)
            img[x].scale(260, 30);
            setPontosDeVida(50);
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
      setImage(img[getPontoVida()/10]);  
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act(){
        if(getPontoVida()%10==0)
        setImage(img[getPontoVida()/10]);
    }
    
   private GreenfootImage[] img ={
    new GreenfootImage("FloraB06.png"),new GreenfootImage("FloraB05.png"),new GreenfootImage("FloraB04.png"),new GreenfootImage("FloraB03.png"),
    new GreenfootImage("FloraB02.png"),new GreenfootImage("FloraB01.png")};
}
