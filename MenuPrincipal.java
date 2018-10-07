import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPrincipal extends ItensMenu
{
    public MenuPrincipal(){
        img.scale(290,38);
        setImage(img);
    }
    
    /**
     * Act - do whatever the MenuPrincipal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(menu);
        }
    }
    
    private GreenfootImage img = new GreenfootImage("menuPrincipal.png");
    private World menu = new Menu();
}
