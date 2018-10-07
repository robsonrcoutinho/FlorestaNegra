import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class voltar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Voltar extends ItensMenu
{
    public Voltar(World mundoAVoltar){
        img.scale(240, 35);
        setImage(img);
        this.mundoAVoltar=mundoAVoltar;
    }
    
    /**
     * Act - do whatever the Teclas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(mundoAVoltar);
        }
    }
    
    private GreenfootImage img = new GreenfootImage("botaoVoltar.png");    
    private World mundoAVoltar;
}
