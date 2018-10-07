import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este classe é referente a
 * espada de oberon.
 * 
 * @since Novembro, 2013.
 */
public class Espada extends ArmasOberon
{
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        colisao();
        if(remossao!=true)
           
            getWorld().removeObject(this);
    }    
}
