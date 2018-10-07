import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends World
{
    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos()
    {    
        super(800, 400, 1);
        img.scale(800,400);
        setBackground(img);
    }
     public void act(){
        passaTempo();
        
    }
    
    public void passaTempo(){        
        if(tempo == 400){
            Greenfoot.setWorld(new Menu());
            
        
        }
        tempo++;
        
        
        
    }
      private int tempo = 0;
    
    private GreenfootImage img = new GreenfootImage("creditos.png");
}
