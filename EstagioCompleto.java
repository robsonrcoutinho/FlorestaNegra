import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EstagioCompleto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstagioCompleto extends World
{

    /**
     * Constructor for objects of class EstagioCompleto.
     * 
     */
    public EstagioCompleto(World proximoMundo)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        img.scale(800,400);
        setBackground(img);
        proxima=proximoMundo;
    }
    
    public void act(){
        esperaParaMudar();
    }
    
    
    private void esperaParaMudar(){
        if(esperaTempo==200)
            Greenfoot.setWorld(proxima);
        esperaTempo++;    
    }
    
    private GreenfootImage img  = new GreenfootImage("estagioCompleto.jpg");
    private int esperaTempo;
    private World proxima;
}
