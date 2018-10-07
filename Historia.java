import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente ao botão história 
 * do menu inicial.
 * 
 * @since Novembro, 2013.
 */
public class Historia extends ItensMenu
{
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
            img.scale(200,33);
            setImage(img);
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        
    }
    
    
    private GreenfootImage img = new GreenfootImage("Botao3.jpg");
}
