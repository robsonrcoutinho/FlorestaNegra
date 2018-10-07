import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Class;
/**
 * Write a description of class Orbe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orbe extends Terrain
{
    public void act() 
    {
        if(pisca)
            animacao();
            
        if(pisca==false&&aceso==false)
            setImage(img[0]);
            
        if(pisca==false&&aceso==true)
            setImage(img[1]);
    }
    
    public void pararDePiscar(){
        pisca=false;
    }
    
    public void piscar(){
        pisca=true;
    }
    
    public void acender(){
        aceso=true;
    }
    
    public void apagar(){
        aceso=false;
    }
    
    private void animacao(){
        if(posImg%10==0)
            setImage(img[posImg/10]);
        
        if(posImg==18)
            posImg=-1;
        
            posImg++;    
    }
    
    public boolean sendoTocado(java.lang.Class cls){
        return isTouching(cls);
    }
    
    private GreenfootImage[] img = {new GreenfootImage("orb.png"), new GreenfootImage("orb1.png")};
    private int posImg;
    private boolean pisca=true;
    private boolean aceso;
    
}
