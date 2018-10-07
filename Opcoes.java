import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class opcoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opcoes extends ItensMenu
{
    protected void  addedToWorld(World world){
            img.scale(200,33);
            setImage(img);
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MenuOpcoes());
        }
    }
        GreenfootImage img = new GreenfootImage("Botao2.jpg");

}
