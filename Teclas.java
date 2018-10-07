import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teclas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teclas extends ItensMenu
{
    public Teclas(){
        img.scale(240, 35);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Teclas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    private GreenfootImage img = new GreenfootImage("teclasdeAtalho.png");
}
