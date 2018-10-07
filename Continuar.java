import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Continuar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Continuar extends ItensMenu
{
    public Continuar(Pausavel fasePausada){
        this.fasePausada=fasePausada;
        img.scale(290,38);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Continuar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
            fasePausada.continuar();
        }
    }
    
    private GreenfootImage img = new GreenfootImage("continuar.png");
    private Pausavel fasePausada;
}
