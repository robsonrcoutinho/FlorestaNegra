import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe representa a barra de vida
 * de Oberon.
 * 
 * @since Novembro, 2013.
 */
public class OberonVida extends Vidas
{   
    /**
     * No construtor deste objeto
     * é redimensionado todas as imagens
     * do array img.
     */
    public OberonVida()
    {
        for(int x=0;x<img.length;x++)
            img[x].scale(260, 30);
            setPontosDeVida(10);
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
    new GreenfootImage("barraOberon.png"),new GreenfootImage("barraOberon1.png"),new GreenfootImage("barraOberon2.png"),
    new GreenfootImage("barraOberon3.png"),new GreenfootImage("barraOberon4.png"),new GreenfootImage("barraOberon5.png"),
    new GreenfootImage("barraOberon6.png"),new GreenfootImage("barraOberon7.png"),new GreenfootImage("barraOberon8.png"),
    new GreenfootImage("barraOberon9.png"),new GreenfootImage("barraOberon10.png"),};

}
