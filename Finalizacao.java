import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Finalizacao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Finalizacao extends World
{

    /**
     * Constructor for objects of class Finalizacao.
     * 
     */
    public Finalizacao()
    {    
        
        super(800, 400, 1); 
        img.scale(800,400);
        setBackground(img);
        
        
    }
    
    public void act(){
        passaTempo();
        
    }
    
    public void passaTempo(){        
        if(tempo == 250){
            Greenfoot.setWorld(new Creditos());
            
            
            
        
        }
        tempo++;
        
        
        
    }
      private int tempo = 0;
    
    private GreenfootImage img = new GreenfootImage("fim.jpg") ;
    
    
    
}
