import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reiniciar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reiniciar extends ItensMenu
{
    public Reiniciar(Reiniciavel fase){
        this.fase=fase;
        img.scale(290,38);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Reiniciar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            fase.reiniciarTotalmente();
        }
    }
    
    private GreenfootImage img = new GreenfootImage("reiniciar.png");
    private Reiniciavel fase;
}
