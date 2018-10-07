import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ajuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class botaoAjuda extends ItensMenu
{
    public  botaoAjuda(){
        img.scale(290,38);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Teclas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
                Greenfoot.setWorld(new Ajuda(getWorld()));
        }
    }
    
    private GreenfootImage img = new GreenfootImage("botaoAjuda.png");    
}
