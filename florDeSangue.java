import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class florDeSangue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class florDeSangue extends Actor
{
    /**
     * Act - do whatever the florDeSangue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Oberon.class)){
           ((Apocalipse)getWorld()).concluirFase();
           ((Apocalipse)getWorld()).removerObjeto(this);
        }
    }    
}
